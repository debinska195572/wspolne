package applicationStructure;

import javax.swing.SpringLayout;

import org.hibernate.Session;

import calculations.BMI;
import calculations.GenerateRecipe;
import calculations.NeedCalories;
import calculations.saveToFile;
import databaseController.AccountController;
import databaseController.IngredientController;

import databaseController.RecipeController;
import databaseManager.User;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class DietWindow extends javax.swing.JPanel {

	RecipeController rc;
	IngredientController ic;

	AccountController ac;
	float bmi;
	String obesityInfo;
	float minCalories;
	JTextArea textArea;
	float obliczoneKalorie;
	String xml;
	int i;
	String string;
	JLabel IlePowinnoKalLabel ;

	public DietWindow(final User loggedUser, final Session sessionDB) {

		bmi = BMI.getBmi(loggedUser.getHeight(), loggedUser.getWeight());
		obesityInfo = BMI.getObesityInfo(bmi);
		minCalories = NeedCalories.minCalories(loggedUser.getGender(), loggedUser.getWeight(), loggedUser.getHeight(),
				loggedUser.getAge());

		final java.text.DecimalFormat df = new java.text.DecimalFormat(); // tworzymy
																			// obiekt
																			// DecimalFormat
		df.setMaximumFractionDigits(1); // dla df ustawiamy największą ilość
										// miejsc po przecinku
		df.setMinimumFractionDigits(1);

		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		JLabel lblBmi = new JLabel("BMI:");
		springLayout.putConstraint(SpringLayout.NORTH, lblBmi, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblBmi, 10, SpringLayout.WEST, this);
		add(lblBmi);

		JLabel resultBmiLabel = new JLabel("  ");
		springLayout.putConstraint(SpringLayout.NORTH, resultBmiLabel, 0, SpringLayout.NORTH, lblBmi);
		springLayout.putConstraint(SpringLayout.WEST, resultBmiLabel, 18, SpringLayout.EAST, lblBmi);
		springLayout.putConstraint(SpringLayout.EAST, resultBmiLabel, 63, SpringLayout.EAST, lblBmi);
		add(resultBmiLabel);

		resultBmiLabel.setText(String.valueOf(df.format(bmi)));

		JLabel lblInformacjaOPoziomie = new JLabel("Informacja o poziomie otyłości:");
		springLayout.putConstraint(SpringLayout.NORTH, lblInformacjaOPoziomie, 6, SpringLayout.SOUTH, lblBmi);
		springLayout.putConstraint(SpringLayout.WEST, lblInformacjaOPoziomie, 10, SpringLayout.WEST, this);
		add(lblInformacjaOPoziomie);

		JLabel obseityinfolabel = new JLabel("     ");
		springLayout.putConstraint(SpringLayout.NORTH, obseityinfolabel, 30, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, obseityinfolabel, 6, SpringLayout.EAST, lblInformacjaOPoziomie);
		springLayout.putConstraint(SpringLayout.EAST, obseityinfolabel, 271, SpringLayout.EAST, lblInformacjaOPoziomie);
		add(obseityinfolabel);

		obseityinfolabel.setText(obesityInfo);

		JLabel lblMinimumDzienneZapotrzebowanie = new JLabel("Minimum dzienne zapotrzebowanie kalorii: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblMinimumDzienneZapotrzebowanie, 5, SpringLayout.SOUTH,
				lblInformacjaOPoziomie);
		springLayout.putConstraint(SpringLayout.WEST, lblMinimumDzienneZapotrzebowanie, 10, SpringLayout.WEST, this);
		add(lblMinimumDzienneZapotrzebowanie);

		JLabel minCalLabel = new JLabel("         ");
		springLayout.putConstraint(SpringLayout.NORTH, minCalLabel, 6, SpringLayout.SOUTH, obseityinfolabel);
		springLayout.putConstraint(SpringLayout.WEST, minCalLabel, 6, SpringLayout.EAST,
				lblMinimumDzienneZapotrzebowanie);
		springLayout.putConstraint(SpringLayout.EAST, minCalLabel, 79, SpringLayout.EAST,
				lblMinimumDzienneZapotrzebowanie);
		add(minCalLabel);
		minCalLabel.setText(String.valueOf(minCalories));

		JButton btnGenerujJadospis = new JButton("Generuj jadłospis");
		springLayout.putConstraint(SpringLayout.NORTH, btnGenerujJadospis, 6, SpringLayout.SOUTH,
				lblMinimumDzienneZapotrzebowanie);
		springLayout.putConstraint(SpringLayout.WEST, btnGenerujJadospis, 0, SpringLayout.WEST, lblBmi);
		add(btnGenerujJadospis);

		btnGenerujJadospis.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				i = 0;

				new Thread(() -> {
					
					boolean juz = false;
					
					
					while (juz == false) {
						i++;
						obliczoneKalorie = 0;
						xml = "<Jadłospis>";
						string="";

						GenerateRecipe generateRecipe = new GenerateRecipe(loggedUser, sessionDB);
						
						string=generateRecipe.getRecipe(minCalories, "OBIAD");
						//textArea.setText(generateRecipe.getRecipe(minCalories, "OBIAD"));
						obliczoneKalorie += generateRecipe.getObliczoneKalorie();
						xml += generateRecipe.getStringXml();
						
						string+=generateRecipe.getRecipe(minCalories, "DESER");
						//textArea.setText(textArea.getText() + generateRecipe.getRecipe(minCalories, "DESER"));
						obliczoneKalorie += generateRecipe.getObliczoneKalorie();
						xml += generateRecipe.getStringXml();
						
						string+=generateRecipe.getRecipe(minCalories, "KOLACJA");
						//textArea.setText(textArea.getText() + generateRecipe.getRecipe(minCalories, "KOLACJA"));
						obliczoneKalorie += generateRecipe.getObliczoneKalorie();
						xml += generateRecipe.getStringXml();
						
						string+=generateRecipe.getRecipe(minCalories, "PRZEKASKA");
						//textArea.setText(textArea.getText() + generateRecipe.getRecipe(minCalories, "PRZEKASKA"));
						obliczoneKalorie += generateRecipe.getObliczoneKalorie();
						xml += generateRecipe.getStringXml();
						
						string+=generateRecipe.getRecipe(minCalories, "SNIADANIE");
						//textArea.setText(textArea.getText() + generateRecipe.getRecipe(minCalories, "SNIADANIE"));
						obliczoneKalorie += generateRecipe.getObliczoneKalorie();
						xml += generateRecipe.getStringXml();
						xml += "</Jadłospis>";
						
						string+="Łączenie kalorii: " + String.valueOf(df.format(obliczoneKalorie));
//						textArea.setText(
//								textArea.getText() + "Łączenie kalorii: " + String.valueOf(df.format(obliczoneKalorie)));

						if ((obliczoneKalorie > minCalories)|| i==20) {
							juz = true;
							textArea.setText(string);
						}

					}
					
					if(i>=20)
					{
						textArea.setText("Przykro mi, nie znaleziono przepisów, których łączna ilosć kalorii odpowiadałaby twoim wymogom");
					}
					
					IlePowinnoKalLabel.setText(BMI.getHowMuchCalShould());
					
				}).start();
				
				
				
				
				
				
				

			}

		});

		JButton btnZapiszDoPliku = new JButton("Zapisz do pliku TXT");
		springLayout.putConstraint(SpringLayout.NORTH, btnZapiszDoPliku, -4, SpringLayout.NORTH, lblBmi);
		springLayout.putConstraint(SpringLayout.EAST, btnZapiszDoPliku, -10, SpringLayout.EAST, this);
		add(btnZapiszDoPliku);

		btnZapiszDoPliku.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				File selectedFile = null;

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					selectedFile = fileChooser.getSelectedFile();
					System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				}

				saveToFile.saveToTxt(textArea.getText(), selectedFile.getAbsolutePath() + ".txt");

				
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, btnGenerujJadospis);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -21, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, obseityinfolabel);
		add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 59, SpringLayout.SOUTH, btnGenerujJadospis);
		springLayout.putConstraint(SpringLayout.WEST, textArea, 366, SpringLayout.WEST, this);
		textArea.setLineWrap(true);
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, -28, SpringLayout.NORTH, btnZapiszDoPliku);
		springLayout.putConstraint(SpringLayout.EAST, textArea, 0, SpringLayout.EAST, btnZapiszDoPliku);
		
		JButton btnNewButton = new JButton("Zapisz do pliku XML");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 6, SpringLayout.SOUTH, obseityinfolabel);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, btnZapiszDoPliku);
		add(btnNewButton);
		
		IlePowinnoKalLabel = new JLabel("        ");
		springLayout.putConstraint(SpringLayout.WEST, IlePowinnoKalLabel, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, IlePowinnoKalLabel, -1, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, IlePowinnoKalLabel, 543, SpringLayout.WEST, this);
		add(IlePowinnoKalLabel);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				File selectedFile = null;

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					selectedFile = fileChooser.getSelectedFile();
					System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				}
				
				try {
					saveToFile.loadXMLFromString(xml, selectedFile.getAbsolutePath() + "XML.xml");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
				
			}
		});
		//

		// TODO Auto-generated constructor stub
	}
}

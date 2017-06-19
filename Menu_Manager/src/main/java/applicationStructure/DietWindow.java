package applicationStructure;
import javax.swing.SpringLayout;

import org.hibernate.Session;

import calculations.BMI;
import calculations.GenerateRecipe;
import calculations.NeedCalories;
import databaseController.AccountController;
import databaseController.IngredientController;

import databaseController.RecipeController;
import databaseManager.User;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

public class DietWindow extends javax.swing.JPanel {
	
	RecipeController rc;
	IngredientController ic;
	
	AccountController ac;
	float bmi;
	String obesityInfo;
	float minCalories;
	JTextArea textArea;

	public DietWindow(final User loggedUser, final Session sessionDB) {
		
		bmi=BMI.getBmi(loggedUser.getHeight(), loggedUser.getWeight());
		obesityInfo=BMI.getObesityInfo(bmi);
		minCalories=NeedCalories.minCalories(loggedUser.getGender(), loggedUser.getWeight(), loggedUser.getHeight(), loggedUser.getAge());
		
		java.text.DecimalFormat df=new java.text.DecimalFormat(); //tworzymy obiekt DecimalFormat
		df.setMaximumFractionDigits(1); //dla df ustawiamy największą ilość miejsc po przecinku
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
		springLayout.putConstraint(SpringLayout.NORTH, lblMinimumDzienneZapotrzebowanie, 5, SpringLayout.SOUTH, lblInformacjaOPoziomie);
		springLayout.putConstraint(SpringLayout.WEST, lblMinimumDzienneZapotrzebowanie, 10, SpringLayout.WEST, this);
		add(lblMinimumDzienneZapotrzebowanie);
		
		JLabel minCalLabel = new JLabel("         ");
		springLayout.putConstraint(SpringLayout.NORTH, minCalLabel, 6, SpringLayout.SOUTH, obseityinfolabel);
		springLayout.putConstraint(SpringLayout.WEST, minCalLabel, 6, SpringLayout.EAST, lblMinimumDzienneZapotrzebowanie);
		springLayout.putConstraint(SpringLayout.EAST, minCalLabel, 79, SpringLayout.EAST, lblMinimumDzienneZapotrzebowanie);
		add(minCalLabel);
		minCalLabel.setText(String.valueOf(minCalories));
		
		JButton btnGenerujJadospis = new JButton("Generuj jadłospis");
		springLayout.putConstraint(SpringLayout.NORTH, btnGenerujJadospis, 6, SpringLayout.SOUTH, lblMinimumDzienneZapotrzebowanie);
		springLayout.putConstraint(SpringLayout.WEST, btnGenerujJadospis, 0, SpringLayout.WEST, lblBmi);
		add(btnGenerujJadospis);
		
		btnGenerujJadospis.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				GenerateRecipe generateRecipe = new GenerateRecipe(loggedUser, sessionDB);
				textArea.setText(generateRecipe.getRecipe(minCalories, "OBIAD"));
				textArea.setText(textArea.getText() +generateRecipe.getRecipe(minCalories, "DESER") );
				
			}
		});
		
		 textArea = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 6, SpringLayout.SOUTH, btnGenerujJadospis);
		springLayout.putConstraint(SpringLayout.WEST, textArea, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, 225, SpringLayout.SOUTH, btnGenerujJadospis);
		springLayout.putConstraint(SpringLayout.EAST, textArea, 275, SpringLayout.WEST, this);
		add(textArea);
		
		JButton btnZapiszDoPliku = new JButton("Zapisz do pliku");
		springLayout.putConstraint(SpringLayout.SOUTH, btnZapiszDoPliku, -21, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnZapiszDoPliku, -10, SpringLayout.EAST, this);
		add(btnZapiszDoPliku);
		//
		
		
		
		
		// TODO Auto-generated constructor stub
	}
}

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

	public DietWindow(final User loggedUser, final Session sessionDB) {
		
		bmi=BMI.getBmi(loggedUser.getHeight(), loggedUser.getWeight());
		obesityInfo=BMI.getObesityInfo(bmi);
		minCalories=NeedCalories.minCalories(loggedUser.getGender(), loggedUser.getWeight(), loggedUser.getHeight(), loggedUser.getAge());
		
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblMyBMI = new JLabel("Moje BMI");
		lblMyBMI.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblMyBMI);
		
		JLabel labelBMI = new JLabel("0");
		springLayout.putConstraint(SpringLayout.NORTH, labelBMI, 0, SpringLayout.NORTH, lblMyBMI);
		springLayout.putConstraint(SpringLayout.WEST, labelBMI, 16, SpringLayout.EAST, lblMyBMI);
		labelBMI.setFont(new Font("Calibri", Font.BOLD, 15));
		add(labelBMI);
		//
		java.text.DecimalFormat df=new java.text.DecimalFormat(); //tworzymy obiekt DecimalFormat
		df.setMaximumFractionDigits(1); //dla df ustawiamy największą ilość miejsc po przecinku
		df.setMinimumFractionDigits(1); 
		//
		labelBMI.setText(String.valueOf(df.format(bmi)));
		
		JButton btnGenerateDiet = new JButton("GENERUJ JADŁOSPIS");
		springLayout.putConstraint(SpringLayout.NORTH, btnGenerateDiet, 10, SpringLayout.NORTH, this);
		add(btnGenerateDiet);
		
		btnGenerateDiet.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				GenerateRecipe gRecipe = new GenerateRecipe(loggedUser, sessionDB);
				gRecipe.getSniadanie(minCalories);
				
			}
		});
		
		JLabel lblBreakfast = new JLabel("Śniadanie");
		springLayout.putConstraint(SpringLayout.NORTH, lblMyBMI, -29, SpringLayout.NORTH, lblBreakfast);
		springLayout.putConstraint(SpringLayout.WEST, lblMyBMI, 0, SpringLayout.WEST, lblBreakfast);
		springLayout.putConstraint(SpringLayout.SOUTH, lblMyBMI, -10, SpringLayout.NORTH, lblBreakfast);
		springLayout.putConstraint(SpringLayout.WEST, lblBreakfast, 10, SpringLayout.WEST, this);
		lblBreakfast.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblBreakfast);
		
		JLabel lblSnack = new JLabel("Przekąska");
		springLayout.putConstraint(SpringLayout.WEST, lblSnack, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblBreakfast, -22, SpringLayout.NORTH, lblSnack);
		lblSnack.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblSnack);
		
		JLabel lblLunch = new JLabel("Obiad");
		springLayout.putConstraint(SpringLayout.WEST, lblLunch, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblSnack, -32, SpringLayout.NORTH, lblLunch);
		lblLunch.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblLunch);
		
		JLabel lblDessert = new JLabel("Deser");
		springLayout.putConstraint(SpringLayout.WEST, lblDessert, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblLunch, -29, SpringLayout.NORTH, lblDessert);
		lblDessert.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblDessert);
		
		JLabel lblSupper = new JLabel("Kolacja");
		springLayout.putConstraint(SpringLayout.SOUTH, lblDessert, -27, SpringLayout.NORTH, lblSupper);
		springLayout.putConstraint(SpringLayout.WEST, lblSupper, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblSupper, -56, SpringLayout.SOUTH, this);
		lblSupper.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblSupper);
		
		JButton btnSaveFile = new JButton("ZAPISZ DO PLIKU");
		springLayout.putConstraint(SpringLayout.WEST, btnSaveFile, 0, SpringLayout.WEST, lblMyBMI);
		springLayout.putConstraint(SpringLayout.SOUTH, btnSaveFile, 0, SpringLayout.SOUTH, this);
		add(btnSaveFile);
		
		JLabel obesityLabel = new JLabel("      ");
		springLayout.putConstraint(SpringLayout.WEST, btnGenerateDiet, 66, SpringLayout.EAST, obesityLabel);
		springLayout.putConstraint(SpringLayout.NORTH, obesityLabel, 14, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, obesityLabel, -400, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, obesityLabel, 0, SpringLayout.WEST, lblMyBMI);
		add(obesityLabel);
		obesityLabel.setText(obesityInfo);
		
		JLabel minColorieLabel = new JLabel("    ");
		springLayout.putConstraint(SpringLayout.NORTH, minColorieLabel, 6, SpringLayout.SOUTH, obesityLabel);
		springLayout.putConstraint(SpringLayout.WEST, minColorieLabel, 0, SpringLayout.WEST, lblMyBMI);
		springLayout.putConstraint(SpringLayout.EAST, minColorieLabel, -348, SpringLayout.EAST, this);
		add(minColorieLabel);
		
		minColorieLabel.setText("Potrzebujesz dziennie minimum: " + df.format(minCalories) + " dziennie");
		
		JTextArea textArea = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textArea, -212, SpringLayout.NORTH, btnSaveFile);
		springLayout.putConstraint(SpringLayout.WEST, textArea, 19, SpringLayout.EAST, labelBMI);
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, -62, SpringLayout.NORTH, btnSaveFile);
		springLayout.putConstraint(SpringLayout.EAST, textArea, 0, SpringLayout.EAST, btnGenerateDiet);
		add(textArea);
		// TODO Auto-generated constructor stub
	}
}

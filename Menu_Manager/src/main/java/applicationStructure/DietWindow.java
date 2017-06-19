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
	JTextArea textArea ;
	
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
		springLayout.putConstraint(SpringLayout.WEST, lblMyBMI, 10, SpringLayout.WEST, this);
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
				textArea.setText(gRecipe.getSniadanie(minCalories));
				
			}
		});
		
		JButton btnSaveFile = new JButton("ZAPISZ DO PLIKU");
		springLayout.putConstraint(SpringLayout.SOUTH, lblMyBMI, -248, SpringLayout.NORTH, btnSaveFile);
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
		springLayout.putConstraint(SpringLayout.NORTH, lblMyBMI, 21, SpringLayout.SOUTH, minColorieLabel);
		springLayout.putConstraint(SpringLayout.NORTH, minColorieLabel, 6, SpringLayout.SOUTH, obesityLabel);
		springLayout.putConstraint(SpringLayout.WEST, minColorieLabel, 0, SpringLayout.WEST, lblMyBMI);
		springLayout.putConstraint(SpringLayout.EAST, minColorieLabel, -348, SpringLayout.EAST, this);
		add(minColorieLabel);
		
		minColorieLabel.setText("Potrzebujesz dziennie minimum: " + df.format(minCalories) + " dziennie");
		
		textArea = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textArea, -212, SpringLayout.NORTH, btnSaveFile);
		springLayout.putConstraint(SpringLayout.WEST, textArea, 0, SpringLayout.WEST, lblMyBMI);
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, -62, SpringLayout.NORTH, btnSaveFile);
		springLayout.putConstraint(SpringLayout.EAST, textArea, 0, SpringLayout.EAST, btnGenerateDiet);
		add(textArea);
		// TODO Auto-generated constructor stub
	}
}

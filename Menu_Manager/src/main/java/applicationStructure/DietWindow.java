package applicationStructure;
import javax.swing.SpringLayout;

import org.hibernate.Session;

import calculations.BMI;
import calculations.GenerateRecipe;
import calculations.NeedCalories;
import databaseController.AccountController;
import databaseController.IngredientController;
import databaseController.RIController;
import databaseController.RecipeController;
import databaseManager.User;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DietWindow extends javax.swing.JPanel {
	
	RecipeController rc;
	IngredientController ic;
	RIController ric;
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
		springLayout.putConstraint(SpringLayout.NORTH, labelBMI, 10, SpringLayout.NORTH, this);
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
				GenerateRecipe.getLunch(loggedUser, sessionDB);
				
			}
		});
		
		JLabel lblBreakfast = new JLabel("Śniadanie");
		springLayout.putConstraint(SpringLayout.NORTH, lblMyBMI, -29, SpringLayout.NORTH, lblBreakfast);
		springLayout.putConstraint(SpringLayout.WEST, lblMyBMI, 0, SpringLayout.WEST, lblBreakfast);
		springLayout.putConstraint(SpringLayout.SOUTH, lblMyBMI, -10, SpringLayout.NORTH, lblBreakfast);
		springLayout.putConstraint(SpringLayout.WEST, lblBreakfast, 10, SpringLayout.WEST, this);
		lblBreakfast.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblBreakfast);
		
		JList listBreakfast = new JList();
		springLayout.putConstraint(SpringLayout.WEST, labelBMI, 0, SpringLayout.WEST, listBreakfast);
		springLayout.putConstraint(SpringLayout.NORTH, listBreakfast, 1, SpringLayout.NORTH, lblBreakfast);
		springLayout.putConstraint(SpringLayout.SOUTH, listBreakfast, 15, SpringLayout.NORTH, lblBreakfast);
		add(listBreakfast);
		
		JLabel lblSnack = new JLabel("Przekąska");
		springLayout.putConstraint(SpringLayout.WEST, lblSnack, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblBreakfast, -22, SpringLayout.NORTH, lblSnack);
		lblSnack.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblSnack);
		
		JList listSnack = new JList();
		springLayout.putConstraint(SpringLayout.WEST, listBreakfast, 0, SpringLayout.WEST, listSnack);
		springLayout.putConstraint(SpringLayout.EAST, listBreakfast, 0, SpringLayout.EAST, listSnack);
		springLayout.putConstraint(SpringLayout.WEST, listSnack, 55, SpringLayout.EAST, lblSnack);
		springLayout.putConstraint(SpringLayout.EAST, listSnack, -198, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, listSnack, 1, SpringLayout.NORTH, lblSnack);
		add(listSnack);
		
		JLabel lblLunch = new JLabel("Obiad");
		springLayout.putConstraint(SpringLayout.WEST, lblLunch, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblSnack, -32, SpringLayout.NORTH, lblLunch);
		lblLunch.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblLunch);
		
		JList listLunch = new JList();
		springLayout.putConstraint(SpringLayout.WEST, listLunch, 79, SpringLayout.EAST, lblLunch);
		springLayout.putConstraint(SpringLayout.EAST, listLunch, -198, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, listSnack, -37, SpringLayout.NORTH, listLunch);
		springLayout.putConstraint(SpringLayout.NORTH, listLunch, 1, SpringLayout.NORTH, lblLunch);
		springLayout.putConstraint(SpringLayout.SOUTH, listLunch, -4, SpringLayout.SOUTH, lblLunch);
		add(listLunch);
		
		JLabel lblDessert = new JLabel("Deser");
		springLayout.putConstraint(SpringLayout.WEST, lblDessert, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblLunch, -29, SpringLayout.NORTH, lblDessert);
		lblDessert.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblDessert);
		
		JList listDessert = new JList();
		springLayout.putConstraint(SpringLayout.NORTH, listDessert, 1, SpringLayout.NORTH, lblDessert);
		springLayout.putConstraint(SpringLayout.WEST, listDessert, 80, SpringLayout.EAST, lblDessert);
		springLayout.putConstraint(SpringLayout.SOUTH, listDessert, 15, SpringLayout.NORTH, lblDessert);
		springLayout.putConstraint(SpringLayout.EAST, listDessert, -198, SpringLayout.EAST, this);
		add(listDessert);
		
		JLabel lblSupper = new JLabel("Kolacja");
		springLayout.putConstraint(SpringLayout.SOUTH, lblDessert, -27, SpringLayout.NORTH, lblSupper);
		springLayout.putConstraint(SpringLayout.WEST, lblSupper, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblSupper, -56, SpringLayout.SOUTH, this);
		lblSupper.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblSupper);
		
		JList listSupper = new JList();
		springLayout.putConstraint(SpringLayout.NORTH, listSupper, 1, SpringLayout.NORTH, lblSupper);
		springLayout.putConstraint(SpringLayout.WEST, listSupper, 72, SpringLayout.EAST, lblSupper);
		springLayout.putConstraint(SpringLayout.SOUTH, listSupper, -60, SpringLayout.SOUTH, this);
		add(listSupper);
		
		JButton btnSaveFile = new JButton("ZAPISZ DO PLIKU");
		springLayout.putConstraint(SpringLayout.EAST, btnGenerateDiet, 0, SpringLayout.EAST, btnSaveFile);
		springLayout.putConstraint(SpringLayout.EAST, listSupper, -40, SpringLayout.WEST, btnSaveFile);
		springLayout.putConstraint(SpringLayout.NORTH, btnSaveFile, -2, SpringLayout.NORTH, lblSupper);
		springLayout.putConstraint(SpringLayout.EAST, btnSaveFile, -41, SpringLayout.EAST, this);
		add(btnSaveFile);
		
		JLabel obesityLabel = new JLabel("      ");
		springLayout.putConstraint(SpringLayout.NORTH, obesityLabel, 2, SpringLayout.NORTH, lblMyBMI);
		springLayout.putConstraint(SpringLayout.WEST, obesityLabel, 24, SpringLayout.EAST, labelBMI);
		springLayout.putConstraint(SpringLayout.EAST, obesityLabel, 172, SpringLayout.EAST, labelBMI);
		add(obesityLabel);
		obesityLabel.setText(obesityInfo);
		
		JLabel minColorieLabel = new JLabel("    ");
		springLayout.putConstraint(SpringLayout.NORTH, minColorieLabel, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, minColorieLabel, -110, SpringLayout.EAST, listBreakfast);
		springLayout.putConstraint(SpringLayout.EAST, minColorieLabel, -22, SpringLayout.WEST, btnGenerateDiet);
		add(minColorieLabel);
		
		minColorieLabel.setText("Potrzebujesz dziennie minimum: " + df.format(minCalories) + " dziennie");
		// TODO Auto-generated constructor stub
	}
}

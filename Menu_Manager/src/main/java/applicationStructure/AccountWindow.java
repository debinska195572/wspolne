package applicationStructure;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import org.hibernate.Session;

import databaseController.AccountController;
import databaseController.DietException;
import databaseManager.User;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class AccountWindow extends javax.swing.JPanel  {
	private JTextField textFieldLogin;
	private JTextField textFieldPassword;
	private JTextField textFieldAge;
	private JTextField textFieldHeight;
	private JTextField textFieldWeight;
	private JTextField textFieldDiet;
	JCheckBox checkBoxLactose;
	JCheckBox chckbxGluten;
	JRadioButton rdbtnM;
	JRadioButton rdbtnK;
	JLabel labelNoData;
	
	User loggedUser;
	String passwordNew;
	int ageNew;
	int heightNew;
	int weightNew;
	boolean lactoseNew;
	boolean glutenNew;
	String dietNew;
	String genderNew;
	
	AccountController ac;


	public AccountWindow( User logged, Session sessionDB) {
	
		this.loggedUser=logged;
		ac = new AccountController(sessionDB);
		
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblName = new JLabel("Login");
		springLayout.putConstraint(SpringLayout.WEST, lblName, 35, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblName, -375, SpringLayout.EAST, this);
		lblName.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblName);
		
		JLabel lblPassword = new JLabel("Hasło");
		springLayout.putConstraint(SpringLayout.SOUTH, lblName, -13, SpringLayout.NORTH, lblPassword);
		springLayout.putConstraint(SpringLayout.NORTH, lblPassword, 55, SpringLayout.NORTH, this);
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblPassword);
		
		JLabel lblAge = new JLabel("Wiek");
		springLayout.putConstraint(SpringLayout.NORTH, lblAge, 14, SpringLayout.SOUTH, lblPassword);
		springLayout.putConstraint(SpringLayout.EAST, lblPassword, 0, SpringLayout.EAST, lblAge);
		springLayout.putConstraint(SpringLayout.WEST, lblAge, 36, SpringLayout.WEST, this);
		lblAge.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblAge);
		
		JLabel lblHeight = new JLabel("Wzrost");
		springLayout.putConstraint(SpringLayout.WEST, lblHeight, 35, SpringLayout.WEST, this);
		lblHeight.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblHeight);
		
		JLabel lblWeight = new JLabel("Waga");
		springLayout.putConstraint(SpringLayout.NORTH, lblWeight, 163, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblHeight, -18, SpringLayout.NORTH, lblWeight);
		springLayout.putConstraint(SpringLayout.WEST, lblWeight, 34, SpringLayout.WEST, this);
		lblWeight.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblWeight);
		
		JLabel lblLactose = new JLabel("Tolerancja laktozy");
		springLayout.putConstraint(SpringLayout.WEST, lblLactose, 0, SpringLayout.WEST, lblName);
		lblLactose.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblLactose);
		
		JLabel lblGluten = new JLabel("Tolerancja glutenu");
		springLayout.putConstraint(SpringLayout.WEST, lblGluten, 0, SpringLayout.WEST, lblName);
		lblGluten.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblGluten);
		
		JLabel lblDiet = new JLabel("Dieta");
		springLayout.putConstraint(SpringLayout.NORTH, lblDiet, 36, SpringLayout.SOUTH, lblGluten);
		springLayout.putConstraint(SpringLayout.WEST, lblDiet, 0, SpringLayout.WEST, lblAge);
		lblDiet.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblDiet);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setEnabled(false);
		springLayout.putConstraint(SpringLayout.WEST, textFieldLogin, 220, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, textFieldLogin, -1, SpringLayout.NORTH, lblName);
		springLayout.putConstraint(SpringLayout.EAST, textFieldLogin, 185, SpringLayout.EAST, lblName);
		textFieldLogin.setText(loggedUser.getLogin());
		add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setEnabled(false);
		springLayout.putConstraint(SpringLayout.NORTH, textFieldPassword, -1, SpringLayout.NORTH, lblPassword);
		springLayout.putConstraint(SpringLayout.WEST, textFieldPassword, 0, SpringLayout.WEST, textFieldLogin);
		springLayout.putConstraint(SpringLayout.EAST, textFieldPassword, 0, SpringLayout.EAST, textFieldLogin);
		textFieldPassword.setText(loggedUser.getPassword());
		add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		textFieldAge = new JTextField();
		textFieldAge.setEnabled(false);
		springLayout.putConstraint(SpringLayout.NORTH, textFieldAge, -1, SpringLayout.NORTH, lblAge);
		springLayout.putConstraint(SpringLayout.WEST, textFieldAge, 151, SpringLayout.EAST, lblAge);
		springLayout.putConstraint(SpringLayout.EAST, textFieldAge, 0, SpringLayout.EAST, textFieldLogin);
		textFieldAge.setText(Integer.toString((loggedUser.getAge())));
		add(textFieldAge);
		textFieldAge.setColumns(10);
		
		textFieldHeight = new JTextField();
		textFieldHeight.setEnabled(false);
		springLayout.putConstraint(SpringLayout.NORTH, textFieldHeight, -1, SpringLayout.NORTH, lblHeight);
		springLayout.putConstraint(SpringLayout.WEST, textFieldHeight, 141, SpringLayout.EAST, lblHeight);
		springLayout.putConstraint(SpringLayout.EAST, textFieldHeight, 0, SpringLayout.EAST, textFieldLogin);
		textFieldHeight.setText(Integer.toString((loggedUser.getHeight())));
		add(textFieldHeight);
		textFieldHeight.setColumns(10);
		
		textFieldWeight = new JTextField();
		textFieldWeight.setEnabled(false);
		springLayout.putConstraint(SpringLayout.NORTH, textFieldWeight, -1, SpringLayout.NORTH, lblWeight);
		springLayout.putConstraint(SpringLayout.WEST, textFieldWeight, 151, SpringLayout.EAST, lblWeight);
		springLayout.putConstraint(SpringLayout.EAST, textFieldWeight, 0, SpringLayout.EAST, textFieldLogin);
		textFieldWeight.setText(Integer.toString((loggedUser.getWeight())));
		add(textFieldWeight);
		textFieldWeight.setColumns(10);
		
		checkBoxLactose = new JCheckBox("");
		checkBoxLactose.setEnabled(false);
		springLayout.putConstraint(SpringLayout.SOUTH, lblLactose, 0, SpringLayout.SOUTH, checkBoxLactose);
		springLayout.putConstraint(SpringLayout.WEST, checkBoxLactose, 220, SpringLayout.WEST, this);
		
		if(loggedUser.isLactoseTolerance()==true)
			checkBoxLactose.setSelected(true);
		checkBoxLactose.setEnabled(false);
		
		add(checkBoxLactose);
		
		chckbxGluten = new JCheckBox("");
		chckbxGluten.setEnabled(false);
		springLayout.putConstraint(SpringLayout.NORTH, chckbxGluten, 245, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, checkBoxLactose, -20, SpringLayout.NORTH, chckbxGluten);
		springLayout.putConstraint(SpringLayout.NORTH, lblGluten, 0, SpringLayout.NORTH, chckbxGluten);
		springLayout.putConstraint(SpringLayout.WEST, chckbxGluten, 0, SpringLayout.WEST, textFieldLogin);
		
		if(loggedUser.isGlutenTolerance()==true)
			chckbxGluten.setSelected(true);
		chckbxGluten.setEnabled(false);
		
		add(chckbxGluten);
		
		textFieldDiet = new JTextField();
		textFieldDiet.setEnabled(false);
		springLayout.putConstraint(SpringLayout.NORTH, textFieldDiet, -1, SpringLayout.NORTH, lblDiet);
		springLayout.putConstraint(SpringLayout.WEST, textFieldDiet, 0, SpringLayout.WEST, textFieldLogin);
		springLayout.putConstraint(SpringLayout.EAST, textFieldDiet, -190, SpringLayout.EAST, this);
		textFieldDiet.setText(loggedUser.getDiet());
		add(textFieldDiet);
		textFieldDiet.setColumns(10);
		
		JButton btnEdytuj = new JButton("EDYTUJ");
		springLayout.putConstraint(SpringLayout.NORTH, btnEdytuj, -2, SpringLayout.NORTH, lblName);
		springLayout.putConstraint(SpringLayout.EAST, btnEdytuj, -40, SpringLayout.EAST, this);
		btnEdytuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textFieldPassword.setEnabled(true);
				textFieldAge.setEnabled(true);
				textFieldHeight.setEnabled(true);
				textFieldWeight.setEnabled(true);
				checkBoxLactose.setEnabled(true);
				chckbxGluten.setEnabled(true);
				textFieldDiet.setEnabled(true);
				rdbtnM.setEnabled(true);
				rdbtnK.setEnabled(true);
			}
		});
		add(btnEdytuj);
		
		JButton btnZapisz = new JButton("ZAPISZ");
		springLayout.putConstraint(SpringLayout.NORTH, btnZapisz, 0, SpringLayout.NORTH, lblPassword);
		springLayout.putConstraint(SpringLayout.WEST, btnZapisz, 0, SpringLayout.WEST, btnEdytuj);
		btnZapisz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(textFieldPassword.getText().equals(""))
					labelNoData.setText("Hasło jest wymagane!");
				else{
				
				passwordNew=textFieldPassword.getText();
				if(textFieldAge.getText().equals("")||textFieldHeight.getText().equals("")
						|| textFieldWeight.getText().equals("") || textFieldDiet.getText().equals("") )
				{
						loggedUser=ac.changePssword(loggedUser, passwordNew);
					
				}
					
				else
				{
				ageNew=Integer.parseInt(textFieldAge.getText());
				heightNew=Integer.parseInt(textFieldHeight.getText());
				weightNew=Integer.parseInt(textFieldWeight.getText());
				if(checkBoxLactose.isSelected()==true)
					lactoseNew=true;
				else
					lactoseNew=false;
				
				if(chckbxGluten.isSelected()==true)
					glutenNew=true;
				else
					glutenNew=true;
				if(rdbtnM.isSelected()==true)
					genderNew="M";
				else if(rdbtnK.isSelected()==true)
					genderNew="K";
				
				dietNew=textFieldDiet.getText();
				
				
				
				
						try {
							loggedUser=ac.updateUser(loggedUser, passwordNew, ageNew, dietNew, heightNew, weightNew, glutenNew, lactoseNew, genderNew);
						} catch (DietException e1) {
							
							e1.printStackTrace();
						}
												
				}
				}
				textFieldPassword.setEnabled(false);
				textFieldAge.setEnabled(false);
				textFieldHeight.setEnabled(false);
				textFieldWeight.setEnabled(false);
				checkBoxLactose.setEnabled(false);
				chckbxGluten.setEnabled(false);
				textFieldDiet.setEnabled(false);
				rdbtnM.setEnabled(false);
				rdbtnK.setEnabled(false);
			  }		
			
		});
		add(btnZapisz);
		
		JLabel lblGender = new JLabel("Płeć");
		lblGender.setFont(new Font("Calibri", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblGender, 30, SpringLayout.SOUTH, lblDiet);
		springLayout.putConstraint(SpringLayout.WEST, lblGender, 0, SpringLayout.WEST, lblName);
		add(lblGender);
		
		rdbtnM = new JRadioButton("M");
		rdbtnM.setEnabled(false);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnM, 0, SpringLayout.NORTH, lblGender);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnM, 0, SpringLayout.WEST, textFieldLogin);
		add(rdbtnM);
		
		rdbtnK = new JRadioButton("K");
		rdbtnK.setEnabled(false);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnK, 0, SpringLayout.NORTH, lblGender);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnK, 31, SpringLayout.EAST, rdbtnM);
		add(rdbtnK);
		

		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(rdbtnM);
		genderGroup.add(rdbtnK);
		
		if(loggedUser.getGender().equals("M"))
			rdbtnM.setSelected(true);
		else if(loggedUser.getGender().equals("K"))
			rdbtnK.setSelected(true);
		
		
		labelNoData = new JLabel("");
		springLayout.putConstraint(SpringLayout.SOUTH, labelNoData, 0, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, labelNoData, 0, SpringLayout.EAST, lblHeight);
		add(labelNoData);
		
	
		
	}
}

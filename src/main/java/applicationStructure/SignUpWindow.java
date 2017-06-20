package applicationStructure;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.SpringLayout;

import org.hibernate.Session;

import databaseController.AccountController;
import databaseController.DietException;
import databaseManager.User;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;

public class SignUpWindow extends JFrame {
	private JTextField textFieldLoginNew;
	private JTextField textFieldPasswordNew;
	private JTextField textFieldAgeNew;
	private JTextField textFieldHeightNew;
	private JTextField textFieldWeightNew;
	JComboBox comboBoxDiet;
	JCheckBox checkBoxLactoseNew;
	JCheckBox checkBoxGlutenNew;
	JLabel labelNoLoginPassword;
	JRadioButton rdbtnM;
	JRadioButton rdbtnK;
	AccountController ac;
	String nameNew;
	String passwordNew;
	int ageNew;
	int heightNew;
	int weightNew;
	boolean lactoseNew;
	boolean glutenNew;
	String dietNew;
	String genderNew;

	public SignUpWindow(final Session sessionDB) {
		sessionDB.beginTransaction();
		ac= new AccountController(sessionDB);
		this.setSize(531, 487);
		this.setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignUpWindow.class.getResource("/applicationStructure/jablka.png")));
		getContentPane().setBackground(new Color(176, 224, 230));
		setTitle("Rejestracja nowego użytkownika");
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		textFieldLoginNew = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textFieldLoginNew, 269, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textFieldLoginNew, 32, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textFieldLoginNew, -97, SpringLayout.EAST, getContentPane());
		getContentPane().add(textFieldLoginNew);
		textFieldLoginNew.setColumns(10);
		
		textFieldPasswordNew = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldPasswordNew, 6, SpringLayout.SOUTH, textFieldLoginNew);
		springLayout.putConstraint(SpringLayout.WEST, textFieldPasswordNew, 0, SpringLayout.WEST, textFieldLoginNew);
		springLayout.putConstraint(SpringLayout.EAST, textFieldPasswordNew, 0, SpringLayout.EAST, textFieldLoginNew);
		getContentPane().add(textFieldPasswordNew);
		textFieldPasswordNew.setColumns(10);
		
		textFieldAgeNew = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, textFieldPasswordNew, -21, SpringLayout.NORTH, textFieldAgeNew);
		springLayout.putConstraint(SpringLayout.WEST, textFieldAgeNew, 269, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textFieldAgeNew, 0, SpringLayout.EAST, textFieldLoginNew);
		getContentPane().add(textFieldAgeNew);
		textFieldAgeNew.setColumns(10);
		
		textFieldHeightNew = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textFieldHeightNew, 0, SpringLayout.WEST, textFieldLoginNew);
		springLayout.putConstraint(SpringLayout.EAST, textFieldHeightNew, 0, SpringLayout.EAST, textFieldLoginNew);
		getContentPane().add(textFieldHeightNew);
		textFieldHeightNew.setColumns(10);
		
		textFieldWeightNew = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textFieldWeightNew, 269, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textFieldWeightNew, 0, SpringLayout.EAST, textFieldLoginNew);
		getContentPane().add(textFieldWeightNew);
		textFieldWeightNew.setColumns(10);
		
		JLabel lblLoginNew = new JLabel("Login: *");
		springLayout.putConstraint(SpringLayout.NORTH, lblLoginNew, 13, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textFieldLoginNew, -3, SpringLayout.NORTH, lblLoginNew);
		lblLoginNew.setFont(new Font("Calibri", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.WEST, lblLoginNew, 24, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblLoginNew, 80, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblLoginNew);
		
		JLabel lblPasswordNew = new JLabel("Hasło: *");
		springLayout.putConstraint(SpringLayout.NORTH, lblPasswordNew, 48, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblLoginNew, -19, SpringLayout.NORTH, lblPasswordNew);
		lblPasswordNew.setFont(new Font("Calibri", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.WEST, lblPasswordNew, 0, SpringLayout.WEST, lblLoginNew);
		springLayout.putConstraint(SpringLayout.EAST, lblPasswordNew, 80, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblPasswordNew);
		
		JLabel lblAgeNew = new JLabel("Wiek:");
		springLayout.putConstraint(SpringLayout.NORTH, textFieldAgeNew, -2, SpringLayout.NORTH, lblAgeNew);
		springLayout.putConstraint(SpringLayout.NORTH, lblAgeNew, 16, SpringLayout.SOUTH, lblPasswordNew);
		lblAgeNew.setFont(new Font("Calibri", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.WEST, lblAgeNew, 0, SpringLayout.WEST, lblLoginNew);
		springLayout.putConstraint(SpringLayout.EAST, lblAgeNew, 80, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblAgeNew);
		
		JLabel lblHeightNew = new JLabel("Wzrost:");
		springLayout.putConstraint(SpringLayout.NORTH, textFieldHeightNew, -1, SpringLayout.NORTH, lblHeightNew);
		springLayout.putConstraint(SpringLayout.NORTH, lblHeightNew, 118, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblAgeNew, -19, SpringLayout.NORTH, lblHeightNew);
		lblHeightNew.setFont(new Font("Calibri", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.WEST, lblHeightNew, 0, SpringLayout.WEST, lblLoginNew);
		springLayout.putConstraint(SpringLayout.EAST, lblHeightNew, 80, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblHeightNew);
		
		JLabel lblWeightNew = new JLabel("Waga:");
		springLayout.putConstraint(SpringLayout.NORTH, lblWeightNew, 16, SpringLayout.SOUTH, lblHeightNew);
		springLayout.putConstraint(SpringLayout.NORTH, textFieldWeightNew, -3, SpringLayout.NORTH, lblWeightNew);
		lblWeightNew.setFont(new Font("Calibri", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.WEST, lblWeightNew, 0, SpringLayout.WEST, lblLoginNew);
		springLayout.putConstraint(SpringLayout.EAST, lblWeightNew, 80, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblWeightNew);
		
		JLabel lblLactoseNew = new JLabel("Tolerancja laktozy:");
		springLayout.putConstraint(SpringLayout.NORTH, lblLactoseNew, 188, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblWeightNew, -19, SpringLayout.NORTH, lblLactoseNew);
		lblLactoseNew.setFont(new Font("Calibri", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.WEST, lblLactoseNew, 0, SpringLayout.WEST, lblLoginNew);
		springLayout.putConstraint(SpringLayout.EAST, lblLactoseNew, 197, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblLactoseNew);
		
		JLabel lblGlutenNew = new JLabel("Tolerancja glutenu:");
		springLayout.putConstraint(SpringLayout.NORTH, lblGlutenNew, 16, SpringLayout.SOUTH, lblLactoseNew);
		lblGlutenNew.setFont(new Font("Calibri", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.WEST, lblGlutenNew, 24, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblGlutenNew, 0, SpringLayout.EAST, lblLactoseNew);
		getContentPane().add(lblGlutenNew);
		
		JLabel lblDietNew = new JLabel("Dieta:");
		springLayout.putConstraint(SpringLayout.NORTH, lblDietNew, 16, SpringLayout.SOUTH, lblGlutenNew);
		lblDietNew.setFont(new Font("Calibri", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.WEST, lblDietNew, 0, SpringLayout.WEST, lblLoginNew);
		springLayout.putConstraint(SpringLayout.EAST, lblDietNew, 80, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblDietNew);
		
		checkBoxLactoseNew = new JCheckBox("");
		springLayout.putConstraint(SpringLayout.NORTH, checkBoxLactoseNew, 6, SpringLayout.SOUTH, textFieldWeightNew);
		springLayout.putConstraint(SpringLayout.WEST, checkBoxLactoseNew, 0, SpringLayout.WEST, textFieldLoginNew);
		getContentPane().add(checkBoxLactoseNew);
		
		checkBoxGlutenNew = new JCheckBox("");
		springLayout.putConstraint(SpringLayout.NORTH, checkBoxGlutenNew, 6, SpringLayout.SOUTH, checkBoxLactoseNew);
		springLayout.putConstraint(SpringLayout.WEST, checkBoxGlutenNew, 0, SpringLayout.WEST, textFieldLoginNew);
		getContentPane().add(checkBoxGlutenNew);
		
		labelNoLoginPassword = new JLabel("");
		springLayout.putConstraint(SpringLayout.WEST, labelNoLoginPassword, 0, SpringLayout.WEST, lblLoginNew);
		springLayout.putConstraint(SpringLayout.SOUTH, labelNoLoginPassword, 380, SpringLayout.NORTH, textFieldLoginNew);
		getContentPane().add(labelNoLoginPassword);
		
		JButton btnCreate = new JButton("UTWÓRZ KONTO");
		springLayout.putConstraint(SpringLayout.SOUTH, btnCreate, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnCreate, -29, SpringLayout.EAST, getContentPane());
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textFieldLoginNew.getText().equals("")|| textFieldPasswordNew.getText().equals(""))
					labelNoLoginPassword.setText("Pola oznaczone * są wymagane!");
				else{
				nameNew=textFieldLoginNew.getText();
				passwordNew=textFieldPasswordNew.getText();
				if(textFieldAgeNew.getText().equals("")||textFieldHeightNew.getText().equals("")
						|| textFieldWeightNew.getText().equals("")  )
				{
						User checkUser = ac.getUser(nameNew);
						if(checkUser!=null)
							labelNoLoginPassword.setText("Użytkownik o tej nazwie już istnieje");
						else{
						User newUser=ac.createUser(nameNew, passwordNew);
						LoginWindow loginWindow = new LoginWindow(sessionDB);
						loginWindow.setVisible(true);
						
						dispose();
						}
					
				}
					
				else
				{
				ageNew=Integer.parseInt(textFieldAgeNew.getText());
				heightNew=Integer.parseInt(textFieldHeightNew.getText());
				weightNew=Integer.parseInt(textFieldWeightNew.getText());
				if(checkBoxLactoseNew.isSelected()==true)
					lactoseNew=true;
				else
					lactoseNew=false;
				
				if(checkBoxGlutenNew.isSelected()==true)
					glutenNew=true;
				else
					glutenNew=false;
				if(rdbtnM.isSelected()==true)
					genderNew="M";
				else if(rdbtnK.isSelected()==true)
					genderNew="K";
				
				dietNew=comboBoxDiet.getSelectedItem().toString();
				
				User checkUser = ac.getUser(nameNew);
				if(checkUser!=null)
					labelNoLoginPassword.setText("Użytkownik o tej nazwie już istnieje");
				else{
				
					try {
						
						User newUser=ac.createSpecificUser(nameNew, passwordNew, ageNew, heightNew, weightNew, lactoseNew, glutenNew, dietNew, genderNew);
						LoginWindow loginWindow = new LoginWindow(sessionDB);
						loginWindow.setVisible(true);
						
						
					} catch (DietException e1) {
						
						e1.printStackTrace();
					}
					finally{
						
						dispose();
					}
				  }				
				}
			  }
			}
			
		});
		getContentPane().add(btnCreate);
		
		JButton btnBack = new JButton("ANUULUJ");
		springLayout.putConstraint(SpringLayout.NORTH, btnBack, 0, SpringLayout.NORTH, btnCreate);
		springLayout.putConstraint(SpringLayout.WEST, btnBack, 0, SpringLayout.WEST, lblLoginNew);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpenWindow openWindow= new OpenWindow();
				openWindow.setVisible(true);
				sessionDB.close();
				dispose();
				
			}
		});
		getContentPane().add(btnBack);
		
		JLabel lblGenderNew = new JLabel("Płeć");
		lblGenderNew.setFont(new Font("Calibri", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblGenderNew, 29, SpringLayout.SOUTH, lblDietNew);
		springLayout.putConstraint(SpringLayout.WEST, lblGenderNew, 0, SpringLayout.WEST, lblLoginNew);
		getContentPane().add(lblGenderNew);
		
		rdbtnM = new JRadioButton("M");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnM, 0, SpringLayout.NORTH, lblGenderNew);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnM, 0, SpringLayout.WEST, textFieldLoginNew);
		getContentPane().add(rdbtnM);
		
		rdbtnK = new JRadioButton("K");
		springLayout.putConstraint(SpringLayout.WEST, rdbtnK, 39, SpringLayout.EAST, rdbtnM);
		springLayout.putConstraint(SpringLayout.SOUTH, rdbtnK, 0, SpringLayout.SOUTH, rdbtnM);
		getContentPane().add(rdbtnK);
		
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(rdbtnM);
		genderGroup.add(rdbtnK);
		
		comboBoxDiet = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxDiet, -1, SpringLayout.NORTH, lblDietNew);
		springLayout.putConstraint(SpringLayout.WEST, comboBoxDiet, 0, SpringLayout.WEST, textFieldLoginNew);
		springLayout.putConstraint(SpringLayout.EAST, comboBoxDiet, 33, SpringLayout.EAST, rdbtnK);
		String n="NORMALNA";
		String w="WEGETARIAŃSKA";
		comboBoxDiet.addItem(n);
		comboBoxDiet.addItem(w);
		
		
		getContentPane().add(comboBoxDiet);
		// TODO Auto-generated constructor stub
	}
}

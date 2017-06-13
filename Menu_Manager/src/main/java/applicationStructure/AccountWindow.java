package applicationStructure;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class AccountWindow extends javax.swing.JPanel {
	private JTextField textFieldLogin;
	private JTextField textFieldPassword;
	private JTextField textFieldAge;
	private JTextField textFieldHeight;
	private JTextField textFieldWeight;
	private JTextField textFieldDiet;

	public AccountWindow() {
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
		springLayout.putConstraint(SpringLayout.WEST, textFieldLogin, 220, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, textFieldLogin, -1, SpringLayout.NORTH, lblName);
		springLayout.putConstraint(SpringLayout.EAST, textFieldLogin, 185, SpringLayout.EAST, lblName);
		textFieldLogin.setEditable(false);
		add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		textFieldPassword = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldPassword, -1, SpringLayout.NORTH, lblPassword);
		springLayout.putConstraint(SpringLayout.WEST, textFieldPassword, 0, SpringLayout.WEST, textFieldLogin);
		springLayout.putConstraint(SpringLayout.EAST, textFieldPassword, 0, SpringLayout.EAST, textFieldLogin);
		textFieldPassword.setEditable(false);
		add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		textFieldAge = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldAge, -1, SpringLayout.NORTH, lblAge);
		springLayout.putConstraint(SpringLayout.WEST, textFieldAge, 151, SpringLayout.EAST, lblAge);
		springLayout.putConstraint(SpringLayout.EAST, textFieldAge, 0, SpringLayout.EAST, textFieldLogin);
		textFieldAge.setEditable(false);
		add(textFieldAge);
		textFieldAge.setColumns(10);
		
		textFieldHeight = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldHeight, -1, SpringLayout.NORTH, lblHeight);
		springLayout.putConstraint(SpringLayout.WEST, textFieldHeight, 141, SpringLayout.EAST, lblHeight);
		springLayout.putConstraint(SpringLayout.EAST, textFieldHeight, 0, SpringLayout.EAST, textFieldLogin);
		textFieldHeight.setEditable(false);
		add(textFieldHeight);
		textFieldHeight.setColumns(10);
		
		textFieldWeight = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldWeight, -1, SpringLayout.NORTH, lblWeight);
		springLayout.putConstraint(SpringLayout.WEST, textFieldWeight, 151, SpringLayout.EAST, lblWeight);
		springLayout.putConstraint(SpringLayout.EAST, textFieldWeight, 0, SpringLayout.EAST, textFieldLogin);
		textFieldWeight.setEditable(false);
		add(textFieldWeight);
		textFieldWeight.setColumns(10);
		
		JCheckBox checkBoxLactose = new JCheckBox("");
		springLayout.putConstraint(SpringLayout.SOUTH, lblLactose, 0, SpringLayout.SOUTH, checkBoxLactose);
		springLayout.putConstraint(SpringLayout.WEST, checkBoxLactose, 220, SpringLayout.WEST, this);
		checkBoxLactose.setEnabled(false);
		add(checkBoxLactose);
		
		JCheckBox chckbxGluten = new JCheckBox("");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxGluten, 245, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, checkBoxLactose, -20, SpringLayout.NORTH, chckbxGluten);
		springLayout.putConstraint(SpringLayout.NORTH, lblGluten, 0, SpringLayout.NORTH, chckbxGluten);
		springLayout.putConstraint(SpringLayout.WEST, chckbxGluten, 0, SpringLayout.WEST, textFieldLogin);
		chckbxGluten.setEnabled(false);
		add(chckbxGluten);
		
		textFieldDiet = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldDiet, -1, SpringLayout.NORTH, lblDiet);
		springLayout.putConstraint(SpringLayout.WEST, textFieldDiet, 0, SpringLayout.WEST, textFieldLogin);
		springLayout.putConstraint(SpringLayout.EAST, textFieldDiet, -190, SpringLayout.EAST, this);
		textFieldDiet.setEditable(false);
		add(textFieldDiet);
		textFieldDiet.setColumns(10);
		
		JButton btnEdytuj = new JButton("EDYTUJ");
		springLayout.putConstraint(SpringLayout.NORTH, btnEdytuj, 9, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnEdytuj, -40, SpringLayout.EAST, this);
		add(btnEdytuj);
		
		JButton btnZapisz = new JButton("ZAPISZ");
		springLayout.putConstraint(SpringLayout.NORTH, btnZapisz, 21, SpringLayout.SOUTH, btnEdytuj);
		springLayout.putConstraint(SpringLayout.WEST, btnZapisz, 0, SpringLayout.WEST, btnEdytuj);
		add(btnZapisz);
		// TODO Auto-generated constructor stub
	}
}

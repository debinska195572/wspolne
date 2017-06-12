package applicationStructure;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class AccountWindow extends javax.swing.JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public AccountWindow() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblName = new JLabel("Login");
		springLayout.putConstraint(SpringLayout.WEST, lblName, 35, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblName, 33, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblName, -375, SpringLayout.EAST, this);
		lblName.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblName);
		
		JLabel lblNazwisko = new JLabel("Hasło");
		springLayout.putConstraint(SpringLayout.NORTH, lblNazwisko, 6, SpringLayout.SOUTH, lblName);
		springLayout.putConstraint(SpringLayout.WEST, lblNazwisko, 0, SpringLayout.WEST, lblName);
		add(lblNazwisko);
		
		JLabel lblWiek = new JLabel("Wiek");
		springLayout.putConstraint(SpringLayout.WEST, lblWiek, 0, SpringLayout.WEST, lblName);
		add(lblWiek);
		
		JLabel lblWzrost = new JLabel("Wzrost");
		springLayout.putConstraint(SpringLayout.WEST, lblWzrost, 0, SpringLayout.WEST, lblName);
		add(lblWzrost);
		
		JLabel lblWaga = new JLabel("Waga");
		springLayout.putConstraint(SpringLayout.EAST, lblWaga, 0, SpringLayout.EAST, lblNazwisko);
		add(lblWaga);
		
		JLabel lblTolerancjaLaktozy = new JLabel("Tolerancja laktozy");
		springLayout.putConstraint(SpringLayout.WEST, lblTolerancjaLaktozy, 0, SpringLayout.WEST, lblName);
		add(lblTolerancjaLaktozy);
		
		JLabel lblTolerancjaGlutenu = new JLabel("Tolerancja glutenu");
		springLayout.putConstraint(SpringLayout.WEST, lblTolerancjaGlutenu, 0, SpringLayout.WEST, lblName);
		add(lblTolerancjaGlutenu);
		
		JLabel lblDieta = new JLabel("Dieta");
		springLayout.putConstraint(SpringLayout.WEST, lblDieta, 0, SpringLayout.WEST, lblName);
		add(lblDieta);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, textField, 97, SpringLayout.EAST, lblName);
		springLayout.putConstraint(SpringLayout.NORTH, lblName, -3, SpringLayout.NORTH, textField);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 12, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_2, 13, SpringLayout.SOUTH, textField_1);
		springLayout.putConstraint(SpringLayout.NORTH, lblWiek, 3, SpringLayout.NORTH, textField_2);
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 0, SpringLayout.WEST, textField);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lblWzrost, 3, SpringLayout.NORTH, textField_3);
		springLayout.putConstraint(SpringLayout.NORTH, textField_3, 15, SpringLayout.SOUTH, textField_2);
		springLayout.putConstraint(SpringLayout.EAST, textField_3, 0, SpringLayout.EAST, textField);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lblWaga, 3, SpringLayout.NORTH, textField_4);
		springLayout.putConstraint(SpringLayout.NORTH, textField_4, 15, SpringLayout.SOUTH, textField_3);
		springLayout.putConstraint(SpringLayout.EAST, textField_4, 0, SpringLayout.EAST, textField);
		add(textField_4);
		textField_4.setColumns(10);
		
		JCheckBox checkBox = new JCheckBox("");
		springLayout.putConstraint(SpringLayout.NORTH, lblTolerancjaLaktozy, 0, SpringLayout.NORTH, checkBox);
		springLayout.putConstraint(SpringLayout.NORTH, checkBox, 13, SpringLayout.SOUTH, textField_4);
		springLayout.putConstraint(SpringLayout.WEST, checkBox, 0, SpringLayout.WEST, textField);
		add(checkBox);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		springLayout.putConstraint(SpringLayout.NORTH, lblTolerancjaGlutenu, 0, SpringLayout.NORTH, chckbxNewCheckBox);
		springLayout.putConstraint(SpringLayout.NORTH, chckbxNewCheckBox, 20, SpringLayout.SOUTH, checkBox);
		springLayout.putConstraint(SpringLayout.WEST, chckbxNewCheckBox, 0, SpringLayout.WEST, textField);
		add(chckbxNewCheckBox);
		
		textField_5 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_5, 11, SpringLayout.SOUTH, chckbxNewCheckBox);
		springLayout.putConstraint(SpringLayout.NORTH, lblDieta, 3, SpringLayout.NORTH, textField_5);
		springLayout.putConstraint(SpringLayout.WEST, textField_5, 0, SpringLayout.WEST, textField);
		add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnEdytuj = new JButton("EDYTUJ");
		springLayout.putConstraint(SpringLayout.NORTH, btnEdytuj, 2, SpringLayout.NORTH, lblName);
		springLayout.putConstraint(SpringLayout.EAST, btnEdytuj, -40, SpringLayout.EAST, this);
		add(btnEdytuj);
		
		JButton btnZapisz = new JButton("ZAPISZ");
		springLayout.putConstraint(SpringLayout.NORTH, btnZapisz, 21, SpringLayout.SOUTH, btnEdytuj);
		springLayout.putConstraint(SpringLayout.WEST, btnZapisz, 0, SpringLayout.WEST, btnEdytuj);
		add(btnZapisz);
		// TODO Auto-generated constructor stub
	}
}

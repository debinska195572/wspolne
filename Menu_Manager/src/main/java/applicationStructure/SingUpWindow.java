package applicationStructure;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.SpringLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.Toolkit;

public class SingUpWindow extends JFrame {
	private JTextField textFieldLoginNew;
	private JTextField textFieldPasswordNew;
	private JTextField textFieldAgeNew;
	private JTextField textFieldHeightNew;
	private JTextField textFieldWeightNew;
	private JTextField textFieldDietNew;

	public SingUpWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SingUpWindow.class.getResource("/applicationStructure/jablka.png")));
		getContentPane().setBackground(new Color(176, 224, 230));
		setTitle("Rejestracja nowego użytkownika");
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		textFieldLoginNew = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldLoginNew, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textFieldLoginNew, 197, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textFieldLoginNew, 32, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textFieldLoginNew, 313, SpringLayout.WEST, getContentPane());
		getContentPane().add(textFieldLoginNew);
		textFieldLoginNew.setColumns(10);
		
		textFieldPasswordNew = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldPasswordNew, 45, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textFieldPasswordNew, 197, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textFieldPasswordNew, 67, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textFieldPasswordNew, 313, SpringLayout.WEST, getContentPane());
		getContentPane().add(textFieldPasswordNew);
		textFieldPasswordNew.setColumns(10);
		
		textFieldAgeNew = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldAgeNew, 80, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textFieldAgeNew, 197, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textFieldAgeNew, 102, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textFieldAgeNew, 313, SpringLayout.WEST, getContentPane());
		getContentPane().add(textFieldAgeNew);
		textFieldAgeNew.setColumns(10);
		
		textFieldHeightNew = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldHeightNew, 115, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textFieldHeightNew, 197, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textFieldHeightNew, 137, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textFieldHeightNew, 313, SpringLayout.WEST, getContentPane());
		getContentPane().add(textFieldHeightNew);
		textFieldHeightNew.setColumns(10);
		
		textFieldWeightNew = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldWeightNew, 150, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textFieldWeightNew, 197, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textFieldWeightNew, 172, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textFieldWeightNew, 313, SpringLayout.WEST, getContentPane());
		getContentPane().add(textFieldWeightNew);
		textFieldWeightNew.setColumns(10);
		
		textFieldDietNew = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldDietNew, 255, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textFieldDietNew, 197, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textFieldDietNew, 277, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textFieldDietNew, 313, SpringLayout.WEST, getContentPane());
		getContentPane().add(textFieldDietNew);
		textFieldDietNew.setColumns(10);
		
		JLabel lblLoginNew = new JLabel("Login:");
		lblLoginNew.setFont(new Font("Calibri", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblLoginNew, 3, SpringLayout.NORTH, textFieldLoginNew);
		springLayout.putConstraint(SpringLayout.WEST, lblLoginNew, 24, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblLoginNew, 29, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblLoginNew, 80, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblLoginNew);
		
		JLabel lblPasswordNew = new JLabel("Hasło:");
		lblPasswordNew.setFont(new Font("Calibri", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblPasswordNew, 3, SpringLayout.NORTH, textFieldPasswordNew);
		springLayout.putConstraint(SpringLayout.WEST, lblPasswordNew, 0, SpringLayout.WEST, lblLoginNew);
		springLayout.putConstraint(SpringLayout.EAST, lblPasswordNew, 80, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblPasswordNew);
		
		JLabel lblAgeNew = new JLabel("Wiek:");
		lblAgeNew.setFont(new Font("Calibri", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblAgeNew, 3, SpringLayout.NORTH, textFieldAgeNew);
		springLayout.putConstraint(SpringLayout.WEST, lblAgeNew, 0, SpringLayout.WEST, lblLoginNew);
		springLayout.putConstraint(SpringLayout.SOUTH, lblAgeNew, 99, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblAgeNew, 80, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblAgeNew);
		
		JLabel lblHeightNew = new JLabel("Wzrost:");
		lblHeightNew.setFont(new Font("Calibri", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblHeightNew, 3, SpringLayout.NORTH, textFieldHeightNew);
		springLayout.putConstraint(SpringLayout.WEST, lblHeightNew, 0, SpringLayout.WEST, lblLoginNew);
		springLayout.putConstraint(SpringLayout.EAST, lblHeightNew, 80, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblHeightNew);
		
		JLabel lblWeightNew = new JLabel("Waga:");
		lblWeightNew.setFont(new Font("Calibri", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblWeightNew, 3, SpringLayout.NORTH, textFieldWeightNew);
		springLayout.putConstraint(SpringLayout.WEST, lblWeightNew, 0, SpringLayout.WEST, lblLoginNew);
		springLayout.putConstraint(SpringLayout.SOUTH, lblWeightNew, 169, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblWeightNew, 80, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblWeightNew);
		
		JLabel lblLactoseNew = new JLabel("Tolerancja laktozy:");
		springLayout.putConstraint(SpringLayout.NORTH, lblLactoseNew, 19, SpringLayout.SOUTH, lblWeightNew);
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
		lblDietNew.setFont(new Font("Calibri", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblDietNew, 3, SpringLayout.NORTH, textFieldDietNew);
		springLayout.putConstraint(SpringLayout.WEST, lblDietNew, 0, SpringLayout.WEST, lblLoginNew);
		springLayout.putConstraint(SpringLayout.EAST, lblDietNew, 80, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblDietNew);
		
		JButton btnAnuluj = new JButton("Anuluj");
		springLayout.putConstraint(SpringLayout.NORTH, btnAnuluj, 321, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnAnuluj, 244, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnAnuluj, 346, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnAnuluj, 360, SpringLayout.WEST, getContentPane());
		getContentPane().add(btnAnuluj);
		
		JCheckBox checkBox = new JCheckBox("");
		springLayout.putConstraint(SpringLayout.NORTH, checkBox, 0, SpringLayout.NORTH, lblLactoseNew);
		springLayout.putConstraint(SpringLayout.WEST, checkBox, 0, SpringLayout.WEST, textFieldLoginNew);
		getContentPane().add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("");
		springLayout.putConstraint(SpringLayout.NORTH, checkBox_1, 0, SpringLayout.NORTH, lblGlutenNew);
		springLayout.putConstraint(SpringLayout.WEST, checkBox_1, 1, SpringLayout.EAST, lblGlutenNew);
		getContentPane().add(checkBox_1);
		
		JButton btnCreate = new JButton("UTWÓRZ KONTO");
		springLayout.putConstraint(SpringLayout.SOUTH, btnCreate, -6, SpringLayout.NORTH, btnAnuluj);
		springLayout.putConstraint(SpringLayout.EAST, btnCreate, -35, SpringLayout.EAST, getContentPane());
		getContentPane().add(btnCreate);
		
		JButton btnBack = new JButton("ANUULUJ");
		springLayout.putConstraint(SpringLayout.WEST, btnBack, 25, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnBack, -6, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnBack);
		// TODO Auto-generated constructor stub
	}
}

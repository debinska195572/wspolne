package applicationStructure;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;

public class SingUpWindow extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	public SingUpWindow() {
		setTitle("Rejestracja nowego użytkownika");
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(197, 10, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(197, 45, 116, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(197, 80, 116, 22);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(197, 115, 116, 22);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(197, 150, 116, 22);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(197, 185, 116, 22);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(197, 220, 116, 22);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(197, 255, 116, 22);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setBounds(80, 13, 56, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Hasło:");
		lblNewLabel_1.setBounds(80, 48, 56, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Wiek:");
		lblNewLabel_2.setBounds(80, 83, 56, 16);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Wzrost:");
		lblNewLabel_3.setBounds(80, 118, 56, 16);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Wiek:");
		lblNewLabel_4.setBounds(80, 153, 56, 16);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Tolerancja laktozy (tak/nie):");
		lblNewLabel_5.setBounds(12, 188, 173, 16);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Tolerancja glutenu (tak/nie):");
		lblNewLabel_6.setBounds(12, 223, 173, 16);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Dieta:");
		lblNewLabel_7.setBounds(80, 258, 56, 16);
		getContentPane().add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Potwierdzam");
		btnNewButton.setBounds(39, 321, 116, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnAnuluj = new JButton("Anuluj");
		btnAnuluj.setBounds(244, 321, 116, 25);
		getContentPane().add(btnAnuluj);
		// TODO Auto-generated constructor stub
	}
}

package applicationStructure;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SpringLayout;

public class LoginWindow  extends JFrame{
	private JTextField textFieldLogin;
	private JTextField textFieldPassword;

	public LoginWindow() {
		getContentPane().setBackground(new Color(176, 224, 230));
		setTitle("Panel logowania");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginWindow.class.getResource("/applicationStructure/jablka.png")));
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		textFieldLogin = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldLogin, 34, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textFieldLogin, 202, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textFieldLogin, 302, SpringLayout.WEST, getContentPane());
		getContentPane().add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		springLayout.putConstraint(SpringLayout.NORTH, lblLogin, 28, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblLogin, 53, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblLogin, 58, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblLogin, 153, SpringLayout.WEST, getContentPane());
		lblLogin.setFont(new Font("Calibri", Font.BOLD, 20));
		getContentPane().add(lblLogin);
		
		textFieldPassword = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldPassword, 91, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textFieldPassword, 202, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textFieldPassword, 302, SpringLayout.WEST, getContentPane());
		getContentPane().add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JLabel lblNewPassword = new JLabel("Hasło");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewPassword, 85, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewPassword, 53, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewPassword, 115, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewPassword, 153, SpringLayout.WEST, getContentPane());
		lblNewPassword.setFont(new Font("Calibri", Font.BOLD, 20));
		getContentPane().add(lblNewPassword);
		
		JButton btnLogInUser = new JButton("ZALOGUJ");
		springLayout.putConstraint(SpringLayout.NORTH, btnLogInUser, 146, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnLogInUser, 119, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnLogInUser, 169, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnLogInUser, 208, SpringLayout.WEST, getContentPane());
		btnLogInUser.setFont(new Font("Calibri", Font.PLAIN, 15));
		getContentPane().add(btnLogInUser);
		// TODO Auto-generated constructor stub
	}
}

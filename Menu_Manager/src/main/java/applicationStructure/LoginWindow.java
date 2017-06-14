package applicationStructure;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SpringLayout;

import org.hibernate.Session;

import databaseController.AccountController;
import databaseManager.HibernateUtil;
import databaseManager.User;

public class LoginWindow  extends JFrame{
	private JTextField textFieldLogin;
	private JPasswordField textFieldPassword;
	AccountController ac;

	public LoginWindow(final Session sessionDB ) {
		
		sessionDB.beginTransaction();
		ac= new AccountController(sessionDB);
		getContentPane().setBackground(new Color(176, 224, 230));
		setTitle("Panel logowania");
		this.setSize(340, 241);
		this.setLocationRelativeTo(null);
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
		
		textFieldPassword = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldPassword, 91, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textFieldPassword, 202, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textFieldPassword, 302, SpringLayout.WEST, getContentPane());
		getContentPane().add(textFieldPassword);
		textFieldPassword.setEchoChar('*');
		textFieldPassword.setColumns(10);
		
		JLabel lblNewPassword = new JLabel("Hasło");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewPassword, 85, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewPassword, 53, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewPassword, 115, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewPassword, 153, SpringLayout.WEST, getContentPane());
		lblNewPassword.setFont(new Font("Calibri", Font.BOLD, 20));
		getContentPane().add(lblNewPassword);
		
		final JLabel labelBad = new JLabel("");
		springLayout.putConstraint(SpringLayout.WEST, labelBad, 120, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, labelBad, -10, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(labelBad);
		
		JButton btnLogInUser = new JButton("ZALOGUJ");
		springLayout.putConstraint(SpringLayout.NORTH, btnLogInUser, 34, SpringLayout.SOUTH, textFieldPassword);
		springLayout.putConstraint(SpringLayout.WEST, btnLogInUser, 0, SpringLayout.WEST, textFieldLogin);
		springLayout.putConstraint(SpringLayout.EAST, btnLogInUser, -37, SpringLayout.EAST, getContentPane());
		btnLogInUser.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnLogInUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User loggedUser=ac.getUser(textFieldLogin.getText());
				if(loggedUser!=null && textFieldPassword.getText().equals(loggedUser.getPassword()))
						{
					MainWindow mainWindow = new MainWindow(loggedUser, sessionDB);
					mainWindow.setVisible(true);
					
					dispose();
					
						}
				else
				{
					labelBad.setText("Zły login lub hasło");
				}
				
			}
		});
		getContentPane().add(btnLogInUser);
		
		JButton btnAnuluj = new JButton("ANULUJ");
		btnAnuluj.setFont(new Font("Tahoma", Font.PLAIN, 11));
		springLayout.putConstraint(SpringLayout.NORTH, btnAnuluj, 30, SpringLayout.SOUTH, lblNewPassword);
		springLayout.putConstraint(SpringLayout.WEST, btnAnuluj, 0, SpringLayout.WEST, lblLogin);
		btnAnuluj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpenWindow openWindow= new OpenWindow();
				openWindow.setVisible(true);
				sessionDB.close();
				dispose();
				
			}
		});
		getContentPane().add(btnAnuluj);
		
		
		// TODO Auto-generated constructor stub
	}
}

package applicationStructure;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import org.hibernate.Session;

import databaseManager.HibernateUtil;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SpringLayout;

public class OpenWindow extends JFrame {
	 Session sessionDB = HibernateUtil.getSessionFactory().openSession();
	 
	public OpenWindow() {
		
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter()
		{
		public void windowClosing(WindowEvent e)
		{
		sessionDB.close();
		System.exit(0); 
		
		}
		}); 
		
		setSize(450, 300);
		this.setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(176, 224, 230));
		setForeground(Color.LIGHT_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(OpenWindow.class.getResource("/applicationStructure/jablka.png")));
		setTitle("Dietetyk 2017 !");
		
		JButton btnLogin = new JButton("Logowanie");
		btnLogin.setFont(new Font("Segoe Script", Font.BOLD, 20));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginWindow loginWindow= new LoginWindow(sessionDB);
				
				loginWindow.setVisible(true);
				dispose();
				
			}
		});
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, btnLogin, 156, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnLogin, 12, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnLogin, 228, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnLogin, 169, SpringLayout.WEST, getContentPane());
		getContentPane().setLayout(springLayout);
		getContentPane().add(btnLogin);
		
		JButton btnSignUp = new JButton("Rejestracja");
		springLayout.putConstraint(SpringLayout.NORTH, btnSignUp, 156, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnSignUp, 263, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnSignUp, 228, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnSignUp, 420, SpringLayout.WEST, getContentPane());
		btnSignUp.setFont(new Font("Segoe Script", Font.BOLD, 20));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpWindow signUpWindow= new SignUpWindow(sessionDB);
				
				signUpWindow.setVisible(true);
				dispose();
			}
		});
		getContentPane().add(btnSignUp);
		
		JLabel lblNewLabel = new JLabel("Dietetyk 2017 !");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 13, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 12, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 94, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 420, SpringLayout.WEST, getContentPane());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 55));
		getContentPane().add(lblNewLabel);
		// TODO Auto-generated constructor stub
		
	}
	
}

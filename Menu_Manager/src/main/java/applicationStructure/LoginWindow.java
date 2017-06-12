package applicationStructure;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Color;

public class LoginWindow extends JFrame {

	public LoginWindow() {
		getContentPane().setBackground(new Color(176, 224, 230));
		setForeground(Color.RED);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\wojci\\Documents\\GitHub\\wspolne\\Menu_Manager\\src\\main\\java\\applicationStructure\\jablka.png"));
		setTitle("Dietetyk 2017 !");
		getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Logowanie");
		btnLogin.setFont(new Font("Segoe Script", Font.BOLD, 20));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setBounds(12, 156, 157, 72);
		getContentPane().add(btnLogin);
		
		JButton btnSignUp = new JButton("Rejestracja");
		btnSignUp.setFont(new Font("Segoe Script", Font.BOLD, 20));
		btnSignUp.setBounds(263, 156, 157, 72);
		getContentPane().add(btnSignUp);
		
		JLabel lblNewLabel = new JLabel("Dietetyk 2017 !");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 55));
		lblNewLabel.setBounds(12, 13, 408, 81);
		getContentPane().add(lblNewLabel);
		// TODO Auto-generated constructor stub
	}
}

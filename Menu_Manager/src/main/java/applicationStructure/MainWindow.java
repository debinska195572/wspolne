package applicationStructure;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SpringLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import org.hibernate.Session;

import databaseController.AccountController;
import databaseManager.User;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.Color;

public class MainWindow extends JFrame{
	private final JButton btnLogOut = new JButton("WYLOGUJ");
	private JTabbedPane tabbedPaneRecipes;
	AccountController ac;

	public MainWindow(final User loggedUser, final Session sessionDB) {
		ac= new AccountController(sessionDB);
		this.setSize(800,  600);
		this.setLocationRelativeTo(null);
		AccountWindow accountWindow =new AccountWindow(loggedUser, sessionDB);
		RecipesWindow recipesWindow =new RecipesWindow(loggedUser, sessionDB);
		CreatorWindow creatorWindow =new CreatorWindow(loggedUser, sessionDB);
		DietWindow dietWindow =new DietWindow(loggedUser, sessionDB);
		getContentPane().setBackground(new Color(176, 224, 230));
		setTitle("Główny Panel");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/applicationStructure/jablka.png")));
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, btnLogOut, 0, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnLogOut, 20, SpringLayout.NORTH, getContentPane());
		getContentPane().setLayout(springLayout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		springLayout.putConstraint(SpringLayout.WEST, btnLogOut, -100, SpringLayout.EAST, tabbedPane);
		springLayout.putConstraint(SpringLayout.EAST, btnLogOut, 0, SpringLayout.EAST, tabbedPane);
		springLayout.putConstraint(SpringLayout.NORTH, tabbedPane, 23, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, tabbedPane, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, tabbedPane, 0, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, tabbedPane, 0, SpringLayout.EAST, getContentPane());
		getContentPane().add(tabbedPane);
		
		tabbedPaneRecipes = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneRecipes.setToolTipText("");
		tabbedPane.addTab("Przepisy", recipesWindow);
		
		
		JTabbedPane tabbedPaneAccount = new JTabbedPane(JTabbedPane.TOP);
		
		JTabbedPane tabbedPaneCreate = new JTabbedPane(JTabbedPane.TOP);
		
		tabbedPane.addTab("Moje Konto", accountWindow);
		tabbedPane.addTab("Kreator przepisów", creatorWindow);
		
		JTabbedPane tabbedPaneDiet = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Moja dieta", dietWindow);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpenWindow openWindow= new OpenWindow();
				openWindow.setVisible(true);
				sessionDB.close();
				dispose();
				
			}
		});
		getContentPane().add(btnLogOut);
		
		JButton btnDeleteAccount = new JButton("USUŃ KONTO");
		springLayout.putConstraint(SpringLayout.NORTH, btnDeleteAccount, 0, SpringLayout.NORTH, btnLogOut);
		springLayout.putConstraint(SpringLayout.SOUTH, btnDeleteAccount, 0, SpringLayout.SOUTH, btnLogOut);
		springLayout.putConstraint(SpringLayout.EAST, btnDeleteAccount, -10, SpringLayout.WEST, btnLogOut);
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ac.deleteUser(loggedUser);
				OpenWindow openWindow= new OpenWindow();
				openWindow.setVisible(true);
				
				dispose();
				
			}
		});
		getContentPane().add(btnDeleteAccount);
		
	}
	public JTabbedPane getTabbedPaneRecipes() {
		return tabbedPaneRecipes;
	}
}

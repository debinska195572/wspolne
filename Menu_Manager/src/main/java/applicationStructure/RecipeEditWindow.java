package applicationStructure;
import javax.swing.SpringLayout;

import org.hibernate.Session;

import databaseController.IngredientController;

import databaseController.RecipeController;
import databaseManager.User;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextField;

public class RecipeEditWindow extends javax.swing.JFrame{
	private JTextField textFieldNameEdited;
	private JTextField textFieldTypeEdited;
	RecipeController rc;
	IngredientController ic;

	
	public RecipeEditWindow(User loggedUser, Session sessionDB) {
		
		
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblNameEdited = new JLabel("Nazwa");
		lblNameEdited.setFont(new Font("Calibri", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblNameEdited, 47, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNameEdited, 10, SpringLayout.WEST, this);
		add(lblNameEdited);
		
		textFieldNameEdited = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textFieldNameEdited, 33, SpringLayout.EAST, lblNameEdited);
		springLayout.putConstraint(SpringLayout.SOUTH, textFieldNameEdited, 0, SpringLayout.SOUTH, lblNameEdited);
		add(textFieldNameEdited);
		textFieldNameEdited.setColumns(10);
		
		JLabel lblTypeEdited = new JLabel("Typ");
		lblTypeEdited.setFont(new Font("Calibri", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblTypeEdited, 23, SpringLayout.SOUTH, lblNameEdited);
		springLayout.putConstraint(SpringLayout.WEST, lblTypeEdited, 0, SpringLayout.WEST, lblNameEdited);
		add(lblTypeEdited);
		
		textFieldTypeEdited = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldTypeEdited, 0, SpringLayout.NORTH, lblTypeEdited);
		springLayout.putConstraint(SpringLayout.WEST, textFieldTypeEdited, 0, SpringLayout.WEST, textFieldNameEdited);
		add(textFieldTypeEdited);
		textFieldTypeEdited.setColumns(10);
		
		JLabel lblDescEdited = new JLabel("Opis");
		lblDescEdited.setFont(new Font("Calibri", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.WEST, lblDescEdited, 0, SpringLayout.WEST, lblNameEdited);
		add(lblDescEdited);
		
		JTextArea txtrDescEdited = new JTextArea();
		springLayout.putConstraint(SpringLayout.SOUTH, lblDescEdited, -18, SpringLayout.NORTH, txtrDescEdited);
		springLayout.putConstraint(SpringLayout.NORTH, txtrDescEdited, 171, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtrDescEdited, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, txtrDescEdited, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, txtrDescEdited, 176, SpringLayout.WEST, this);
		txtrDescEdited.setText("Przepis\r\n1.\r\n2.\r\n3.\r\n4.\r\n5.\r\n6.");
		add(txtrDescEdited);
		
		JLabel lblAddedEdited = new JLabel("Dodane składniki");
		springLayout.putConstraint(SpringLayout.WEST, lblAddedEdited, 47, SpringLayout.EAST, textFieldNameEdited);
		springLayout.putConstraint(SpringLayout.SOUTH, lblAddedEdited, -239, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblAddedEdited, 279, SpringLayout.EAST, lblNameEdited);
		lblAddedEdited.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblAddedEdited);
		
		JList listAddedEdited = new JList();
		springLayout.putConstraint(SpringLayout.NORTH, listAddedEdited, 6, SpringLayout.SOUTH, lblAddedEdited);
		springLayout.putConstraint(SpringLayout.WEST, listAddedEdited, 0, SpringLayout.WEST, lblAddedEdited);
		springLayout.putConstraint(SpringLayout.SOUTH, listAddedEdited, -176, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, listAddedEdited, -9, SpringLayout.EAST, this);
		add(listAddedEdited);
		
		JLabel lblAllEdited = new JLabel("Wszystkie składniki");
		springLayout.putConstraint(SpringLayout.NORTH, lblAllEdited, -2, SpringLayout.NORTH, txtrDescEdited);
		springLayout.putConstraint(SpringLayout.WEST, lblAllEdited, 0, SpringLayout.WEST, lblAddedEdited);
		springLayout.putConstraint(SpringLayout.EAST, lblAllEdited, 131, SpringLayout.WEST, lblAddedEdited);
		lblAllEdited.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblAllEdited);
		
		JButton btnDeleteEdited = new JButton("USUŃ");
		springLayout.putConstraint(SpringLayout.NORTH, btnDeleteEdited, -2, SpringLayout.NORTH, lblDescEdited);
		springLayout.putConstraint(SpringLayout.WEST, btnDeleteEdited, 0, SpringLayout.WEST, lblAddedEdited);
		btnDeleteEdited.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnDeleteEdited);
		
		JList listAllEdited = new JList();
		springLayout.putConstraint(SpringLayout.NORTH, listAllEdited, 6, SpringLayout.SOUTH, lblAllEdited);
		springLayout.putConstraint(SpringLayout.WEST, listAllEdited, 41, SpringLayout.EAST, txtrDescEdited);
		springLayout.putConstraint(SpringLayout.EAST, listAllEdited, -11, SpringLayout.EAST, this);
		add(listAllEdited);
		
		JButton btnAddEdited = new JButton("DODAJ");
		springLayout.putConstraint(SpringLayout.SOUTH, listAllEdited, -6, SpringLayout.NORTH, btnAddEdited);
		springLayout.putConstraint(SpringLayout.WEST, btnAddEdited, 0, SpringLayout.WEST, lblAddedEdited);
		springLayout.putConstraint(SpringLayout.SOUTH, btnAddEdited, 0, SpringLayout.SOUTH, txtrDescEdited);
		add(btnAddEdited);
		
		JButton btnSaveEdited = new JButton("ZAPISZ");
		springLayout.putConstraint(SpringLayout.NORTH, btnSaveEdited, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnSaveEdited, -11, SpringLayout.EAST, this);
		add(btnSaveEdited);
		
		JButton btnBack = new JButton("ANUULUJ");
		springLayout.putConstraint(SpringLayout.WEST, btnBack, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnBack, 0, SpringLayout.SOUTH, btnSaveEdited);
		add(btnBack);
		// TODO Auto-generated constructor stub
	}

}

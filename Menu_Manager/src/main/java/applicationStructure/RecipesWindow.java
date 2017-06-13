package applicationStructure;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.SpringLayout;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class RecipesWindow extends javax.swing.JPanel{

	public RecipesWindow() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JCheckBox chckbxMyRecipes = new JCheckBox("Moje przepisy");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxMyRecipes, 35, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, chckbxMyRecipes, -30, SpringLayout.EAST, this);
		chckbxMyRecipes.setFont(new Font("Calibri", Font.BOLD, 15));
		add(chckbxMyRecipes);
		
		JList listRecipes = new JList();
		springLayout.putConstraint(SpringLayout.WEST, listRecipes, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, listRecipes, -28, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, listRecipes, 351, SpringLayout.WEST, this);
		add(listRecipes);
		
		JLabel lblRecipes = new JLabel("Przepisy");
		lblRecipes.setFont(new Font("Calibri", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.WEST, lblRecipes, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, listRecipes, 11, SpringLayout.SOUTH, lblRecipes);
		springLayout.putConstraint(SpringLayout.NORTH, lblRecipes, 10, SpringLayout.NORTH, this);
		add(lblRecipes);
		
		JButton btnEdit = new JButton("EDYTUJ");
		btnEdit.setEnabled(false);
		springLayout.putConstraint(SpringLayout.WEST, btnEdit, 0, SpringLayout.WEST, chckbxMyRecipes);
		springLayout.putConstraint(SpringLayout.SOUTH, btnEdit, -192, SpringLayout.SOUTH, this);
		add(btnEdit);
		
		JButton btnDelete = new JButton("USUŃ");
		btnDelete.setEnabled(false);
		springLayout.putConstraint(SpringLayout.NORTH, btnDelete, 24, SpringLayout.SOUTH, btnEdit);
		springLayout.putConstraint(SpringLayout.WEST, btnDelete, 0, SpringLayout.WEST, chckbxMyRecipes);
		add(btnDelete);
		// TODO Auto-generated constructor stub
	}

}

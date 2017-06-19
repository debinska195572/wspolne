package applicationStructure;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.JCheckBox;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.hibernate.Session;

import databaseController.IngredientController;

import databaseController.RecipeController;
import databaseManager.Ingredient;
import databaseManager.Recipe;
import databaseManager.User;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RecipesWindow extends javax.swing.JPanel{
	
	RecipeController rc;
	IngredientController ic;
	JTable listRecipes;
	JCheckBox chckbxMyRecipes;

	public RecipesWindow(final User loggedUser, final Session sessionDB) {
		
	
		
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		chckbxMyRecipes = new JCheckBox("Moje przepisy");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxMyRecipes, 35, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, chckbxMyRecipes, -30, SpringLayout.EAST, this);
		chckbxMyRecipes.setFont(new Font("Calibri", Font.BOLD, 15));
		add(chckbxMyRecipes);
		
		DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nazwa");
        model.addColumn("Typ");
        model.addColumn("Opis");
        model.addColumn("Owner");
		
		listRecipes = new JTable(model);
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
		springLayout.putConstraint(SpringLayout.WEST, btnEdit, 0, SpringLayout.WEST, chckbxMyRecipes);
		springLayout.putConstraint(SpringLayout.SOUTH, btnEdit, -179, SpringLayout.SOUTH, this);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] row_indexes=listRecipes.getSelectedRows();
				for(int i=0;i<row_indexes.length;i++){
				  String wartosc = listRecipes.getValueAt(row_indexes[i], 0).toString();  
				  System.out.println(wartosc);
				  
				}
			}
		});
		btnEdit.setEnabled(true);
		add(btnEdit);
		
		JButton btnLoad = new JButton("Wczytaj");
		springLayout.putConstraint(SpringLayout.SOUTH, btnLoad, -209, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, btnEdit, 7, SpringLayout.SOUTH, btnLoad);
		springLayout.putConstraint(SpringLayout.WEST, btnLoad, 0, SpringLayout.WEST, chckbxMyRecipes);
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populateIngredients(sessionDB,loggedUser );
			}
		});
		add(btnLoad);
		
		JButton btnNewButton = new JButton("Podgląd");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 6, SpringLayout.SOUTH, btnEdit);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 43, SpringLayout.EAST, listRecipes);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, 132, SpringLayout.EAST, listRecipes);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] row_indexes=listRecipes.getSelectedRows();
				String przepis = "";
				for(int i=0;i<row_indexes.length;i++){
					  String wartosc = listRecipes.getValueAt(row_indexes[i], 0).toString();
					  // pobranie przepisu
					  przepis=wartosc;
					  System.out.println(wartosc);
				}
				ViewRecipe window = new ViewRecipe(sessionDB,przepis);
				window.setVisible(true);
			}
		});
		add(btnNewButton);
		// TODO Auto-generated constructor stub
	}
	public TableModel getDataFromDatabase(Session psessionDB, User logedUser)
	{
	    
	    RecipeController db = new RecipeController(psessionDB);
		List<Recipe> przepisy = db.getAllRecipes();	
		
		DefaultTableModel model = new DefaultTableModel(0,4);
		System.out.println("Ilość przepisów: " + przepisy.size());
		for (Recipe przepis : db.getAllRecipes()) {
		    System.out.println(przepis);
		    if(chckbxMyRecipes.isSelected()){		
				if(przepis.getOwner()==logedUser){
					if(przepis.getRecipeName()!=null){
					model.addRow(new Object[] { przepis.getRecipeName(), przepis.getRecipeType(), przepis.getContent(),
				    		przepis.getOwner() });
					}
				}
			}else
			{if(przepis.getRecipeName()!=null){
				model.addRow(new Object[] { przepis.getRecipeName(), przepis.getRecipeType(), przepis.getContent(),
			    		przepis.getOwner() });
			}
			}
		    
		}
	    return model;
	}
	
	private void populateIngredients(Session psessionDB,User loggedUser)
	{	
		listRecipes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	 
		listRecipes.setModel(getDataFromDatabase(psessionDB,loggedUser));
		listRecipes.repaint();
	}
}

/*
 * 
 */
package applicationStructure;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.hibernate.Session;

import databaseController.IngredientController;
import databaseController.RecipeController;
import databaseManager.Ingredient;
import databaseManager.Recipe;
import databaseManager.RecipeIngredient;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JList;

public class ViewRecipe extends javax.swing.JFrame {

	private JFrame frame ;
	JLabel lblName;
	JLabel lblDesc;
	private JTable listIngredients;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//ViewRecipe window = new ViewRecipe();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewRecipe(final Session sessionDB, String Recipe_Name) {
		initialize();
		setSize(new Dimension(400, 400));
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		lblName = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, lblName, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblName, 139, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblName);
		
		lblDesc = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, lblDesc, 28, SpringLayout.SOUTH, lblName);
		getContentPane().add(lblDesc);
		
		
		DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nazwa");
        model.addColumn("L");
        model.addColumn("G");
        model.addColumn("M");
        model.addColumn("Kalorycznosc");
		
		JButton btnBack = new JButton("Wroc");
		springLayout.putConstraint(SpringLayout.WEST, btnBack, 10, SpringLayout.WEST, getContentPane());
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false); 
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnBack, -10, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnBack);
		
		listIngredients = new JTable(model);
		springLayout.putConstraint(SpringLayout.WEST, listIngredients, 20, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, listIngredients, -10, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblDesc, 0, SpringLayout.WEST, listIngredients);
		springLayout.putConstraint(SpringLayout.SOUTH, lblDesc, -6, SpringLayout.NORTH, listIngredients);
		springLayout.putConstraint(SpringLayout.EAST, lblDesc, 0, SpringLayout.EAST, listIngredients);
		springLayout.putConstraint(SpringLayout.NORTH, listIngredients, 119, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, listIngredients, 0, SpringLayout.NORTH, btnBack);
		listIngredients.setBackground(Color.YELLOW);
		getContentPane().add(listIngredients);
		getData(Recipe_Name,sessionDB);
	}
	
	private void getData(String id_recipe, Session psessionDB)
	{
		RecipeController db = new RecipeController(psessionDB);
		//bug z commitem
		if(!psessionDB.getTransaction().isActive()){
	    	psessionDB.beginTransaction();
		  }
		Recipe przepis = db.getRecipe(id_recipe);
		lblName.setText(przepis.getRecipeName());
		lblDesc.setText(przepis.getContent());
		populateIngredients(psessionDB,id_recipe);
	}
	
	public TableModel getDataFromDatabase(Session psessionDB, String Rec_id)
	{    
		RecipeController db = new RecipeController(psessionDB);
	    if(!psessionDB.getTransaction().isActive()){
	    	psessionDB.beginTransaction();
		  }
	    Recipe przepis = db.getRecipe(Rec_id);		
		Set<RecipeIngredient> skladniki = db.getIngredientsFromRecipe(przepis);
		DefaultTableModel model = new DefaultTableModel(0,5);
		System.out.println("Ilość składników z przepisu: " + skladniki.size());
		for (RecipeIngredient skladnik : db.getIngredientsFromRecipe(przepis)) {
		    System.out.println(skladnik);
		    model.addRow(new Object[] { skladnik.getIngredient().getIngredientName(), skladnik.getIngredient().isLactose(), skladnik.getIngredient().isGluten(),
		    				skladnik.getIngredient().isMeat(), skladnik.getIngredient().getCalories() });
		}
	    return model;
	}
	
	private void populateIngredients(Session psessionDB,String Rec_id)
	{
		listIngredients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	 
		listIngredients.setModel(getDataFromDatabase(psessionDB,Rec_id));
		listIngredients.repaint();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}

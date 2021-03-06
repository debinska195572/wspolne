package applicationStructure;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.hibernate.Session;
import databaseController.RecipeController;
import databaseManager.Recipe;
import databaseManager.RecipeIngredient;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;

public class ViewRecipe extends javax.swing.JFrame {

	private JFrame frame;
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
					// ViewRecipe window = new ViewRecipe();
					// window.frame.setVisible(true);
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
		springLayout.putConstraint(SpringLayout.WEST, lblDesc, 20, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblDesc, -240, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblDesc, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(lblDesc);

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Nazwa");
		model.addColumn("L");
		model.addColumn("G");
		model.addColumn("M");
		model.addColumn("Kalorycznosc");

		JButton btnBack = new JButton("WRÓĆ");
		springLayout.putConstraint(SpringLayout.WEST, btnBack, 10, SpringLayout.WEST, getContentPane());
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnBack, -10, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, lblDesc);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, lblDesc);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -6, SpringLayout.NORTH, btnBack);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(scrollPane);
		
				listIngredients = new JTable(model);
				scrollPane.setViewportView(listIngredients);
				springLayout.putConstraint(SpringLayout.NORTH, listIngredients, 6, SpringLayout.SOUTH, lblDesc);
				springLayout.putConstraint(SpringLayout.WEST, listIngredients, 20, SpringLayout.WEST, getContentPane());
				springLayout.putConstraint(SpringLayout.SOUTH, listIngredients, -117, SpringLayout.NORTH, btnBack);
				springLayout.putConstraint(SpringLayout.EAST, listIngredients, -228, SpringLayout.EAST, getContentPane());
				listIngredients.setBackground(Color.WHITE);
		getData(Recipe_Name, sessionDB);
	}

	private void getData(String id_recipe, Session psessionDB) {
		RecipeController db = new RecipeController(psessionDB);

		if (!psessionDB.getTransaction().isActive()) {
			psessionDB.beginTransaction();
		}
		Recipe przepis = db.getRecipe(id_recipe);
		lblName.setText(przepis.getRecipeName());
		lblDesc.setText(przepis.getContent());
		populateIngredients(psessionDB, id_recipe);
	}

	public TableModel getDataFromDatabase(Session psessionDB, String Rec_id) {
		RecipeController db = new RecipeController(psessionDB);
		if (!psessionDB.getTransaction().isActive()) {
			psessionDB.beginTransaction();
		}
		Recipe przepis = db.getRecipe(Rec_id);
		Set<RecipeIngredient> skladniki = db.getIngredientsFromRecipe(przepis);
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Nazwa");
		model.addColumn("L");
		model.addColumn("G");
		model.addColumn("M");
		model.addColumn("Kalorycznosc");
		System.out.println("Ilość składników z przepisu: " + skladniki.size());
		for (RecipeIngredient skladnik : db.getIngredientsFromRecipe(przepis)) {
			System.out.println(skladnik);
			model.addRow(new Object[] { skladnik.getIngredient().getIngredientName(),
					skladnik.getIngredient().isLactose(), skladnik.getIngredient().isGluten(),
					skladnik.getIngredient().isMeat(), skladnik.getIngredient().getCalories() });
		}
		return model;
	}

	private void populateIngredients(Session psessionDB, String Rec_id) {
		listIngredients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listIngredients.setModel(getDataFromDatabase(psessionDB, Rec_id));
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

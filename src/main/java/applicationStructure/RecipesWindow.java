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
import javax.swing.JScrollPane;

public class RecipesWindow extends javax.swing.JPanel {

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

		JLabel lblRecipes = new JLabel("Przepisy");
		lblRecipes.setFont(new Font("Calibri", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.WEST, lblRecipes, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, lblRecipes, 10, SpringLayout.NORTH, this);
		add(lblRecipes);

		JButton btnEdit = new JButton("EDYTUJ");
		springLayout.putConstraint(SpringLayout.WEST, btnEdit, 0, SpringLayout.WEST, chckbxMyRecipes);
		springLayout.putConstraint(SpringLayout.SOUTH, btnEdit, -149, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnEdit, 0, SpringLayout.EAST, chckbxMyRecipes);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] row_indexes = listRecipes.getSelectedRows();
				for (int i = 0; i < row_indexes.length; i++) {
					String wartosc = listRecipes.getValueAt(row_indexes[i], 0).toString();
					System.out.println(wartosc);
					EditRecipe window = new EditRecipe(wartosc, sessionDB);
					window.setVisible(true);
				}
			}
		});
		btnEdit.setEnabled(true);
		add(btnEdit);

		JButton btnLoad = new JButton("WCZYTAJ");
		springLayout.putConstraint(SpringLayout.SOUTH, btnLoad, -209, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnLoad, 0, SpringLayout.EAST, chckbxMyRecipes);
		springLayout.putConstraint(SpringLayout.WEST, btnLoad, 0, SpringLayout.WEST, chckbxMyRecipes);
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populateIngredients(sessionDB, loggedUser);
			}
		});
		add(btnLoad);

		JButton btnNewButton = new JButton("PODGLĄD");
		springLayout.putConstraint(SpringLayout.NORTH, btnEdit, 6, SpringLayout.SOUTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 6, SpringLayout.SOUTH, btnLoad);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, chckbxMyRecipes);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, chckbxMyRecipes);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] row_indexes = listRecipes.getSelectedRows();
				String przepis = "";
				for (int i = 0; i < row_indexes.length; i++) {
					String wartosc = listRecipes.getValueAt(row_indexes[i], 0).toString();
					// pobranie przepisu
					przepis = wartosc;
					System.out.println(wartosc);
				}
				ViewRecipe window = new ViewRecipe(sessionDB, przepis);
				window.setVisible(true);
			}
		});
		add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 17, SpringLayout.SOUTH, lblRecipes);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 476, SpringLayout.SOUTH, lblRecipes);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -6, SpringLayout.WEST, chckbxMyRecipes);
		add(scrollPane);

		listRecipes = new JTable(model);
		scrollPane.setViewportView(listRecipes);
		springLayout.putConstraint(SpringLayout.EAST, listRecipes, 351, SpringLayout.WEST, chckbxMyRecipes);
		listRecipes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		springLayout.putConstraint(SpringLayout.WEST, listRecipes, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, listRecipes, -28, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, listRecipes, 307, SpringLayout.SOUTH, lblRecipes);
		// TODO Auto-generated constructor stub
	}

	public TableModel getDataFromDatabase(Session psessionDB, User logedUser) {

		RecipeController db = new RecipeController(psessionDB);
		List<Recipe> przepisy = db.getAllRecipes();

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Nazwa");
		model.addColumn("Typ");
		model.addColumn("Opis");
		model.addColumn("Owner");

		System.out.println("Ilość przepisów: " + przepisy.size());
		for (Recipe przepis : db.getAllRecipes()) {
			System.out.println(przepis);
			if (chckbxMyRecipes.isSelected()) {
				if (przepis.getOwner() == logedUser) {
					if (przepis.getRecipeName() != null) {
						model.addRow(new Object[] { przepis.getRecipeName(), przepis.getRecipeType(),
								przepis.getContent(), przepis.getOwner().getLogin() });
					}
				}
			} else {
				if (przepis.getRecipeName() != null) {
					model.addRow(new Object[] { przepis.getRecipeName(), przepis.getRecipeType(), przepis.getContent(),
							przepis.getOwner().getLogin() });
				}
			}

		}
		return model;
	}

	private void populateIngredients(Session psessionDB, User loggedUser) {
		listRecipes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listRecipes.setModel(getDataFromDatabase(psessionDB, loggedUser));
		listRecipes.repaint();
	}
}

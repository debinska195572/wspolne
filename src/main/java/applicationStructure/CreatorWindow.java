package applicationStructure;

import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.hibernate.Session;
import databaseController.IngredientController;
import databaseController.RIController;
import databaseController.RecipeController;
import databaseManager.Ingredient;
import databaseManager.Recipe;
import databaseManager.RecipeIngredient;
import databaseManager.User;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import applicationStructure.NewIngredient;

public class CreatorWindow extends javax.swing.JPanel {
	private JTextField textFieldName;
	private JTextArea txtrDesc;
	RecipeController rc;
	IngredientController ic;
	JTable listAdded;
	private String Rec_id = "";
	JComboBox comboBoxTyp;
	private JTable table;

	public CreatorWindow(final User loggedUser, final Session sessionDB) {

		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		JButton btnAdd = new JButton("DODAJ PRZEPIS");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textFieldName.getText().length() > 0) {
					RecipeController db = new RecipeController(sessionDB);
					if (comboBoxTyp.getSelectedItem() != null) {
						System.out.println(comboBoxTyp.getSelectedItem().toString());
					}
					try {
						db.addRecipe(textFieldName.getText(), comboBoxTyp.getSelectedItem().toString(), loggedUser,
								txtrDesc.getText());
						Rec_id = textFieldName.getText();

						JOptionPane.showMessageDialog(null, "Przepis dodany pomyślnie", "Informacja",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,
								"Nie można dodać przepisu do bazy. Błąd:\n" + e.getMessage(), "Błąd",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Uzupełnij dane przepisu", "Błąd",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnAdd, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, btnAdd, 10, SpringLayout.WEST, this);
		add(btnAdd);

		JLabel lblName = new JLabel("Nazwa");
		lblName.setFont(new Font("Calibri", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblName, 18, SpringLayout.SOUTH, btnAdd);
		springLayout.putConstraint(SpringLayout.WEST, lblName, 0, SpringLayout.WEST, btnAdd);
		add(lblName);

		textFieldName = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldName, -1, SpringLayout.NORTH, lblName);
		springLayout.putConstraint(SpringLayout.WEST, textFieldName, 16, SpringLayout.EAST, lblName);
		add(textFieldName);
		textFieldName.setColumns(10);

		JLabel lblType = new JLabel("Typ");
		springLayout.putConstraint(SpringLayout.WEST, lblType, 0, SpringLayout.WEST, btnAdd);
		lblType.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblType);

		JLabel lblDesc = new JLabel("Opis");
		lblDesc.setFont(new Font("Calibri", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblDesc, 157, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblType, -32, SpringLayout.NORTH, lblDesc);
		springLayout.putConstraint(SpringLayout.WEST, lblDesc, 0, SpringLayout.WEST, btnAdd);
		add(lblDesc);

		txtrDesc = new JTextArea();
		springLayout.putConstraint(SpringLayout.WEST, txtrDesc, 10, SpringLayout.WEST, this);
		txtrDesc.setRows(10);
		txtrDesc.setText("Przepis\r\n1.\r\n2.\r\n3.\r\n4.\r\n5.\r\n6.\r\n");
		add(txtrDesc);

		JLabel lblIngredients = new JLabel("Składniki:");
		springLayout.putConstraint(SpringLayout.WEST, lblIngredients, 188, SpringLayout.WEST, this);
		lblIngredients.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblIngredients);

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Nazwa");
		model.addColumn("L");
		model.addColumn("G");
		model.addColumn("M");
		model.addColumn("Kalorycznosc");

		JButton btnAddIngredient = new JButton("DODAJ DO PRZEPISU");
		springLayout.putConstraint(SpringLayout.NORTH, btnAddIngredient, -4, SpringLayout.NORTH, lblIngredients);
		springLayout.putConstraint(SpringLayout.WEST, btnAddIngredient, 20, SpringLayout.EAST, lblIngredients);
		btnAddIngredient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Rec_id.length() > 0) {
					int[] row_indexes = table.getSelectedRows();
					for (int i = 0; i < row_indexes.length; i++) {
						String wartosc = table.getValueAt(row_indexes[i], 0).toString();
						System.out.println(wartosc);

						RecipeController db = new RecipeController(sessionDB);
						IngredientController dbin = new IngredientController(sessionDB);
						Ingredient skladnik = dbin.getIngredient(wartosc);
						RIController ri = new RIController(sessionDB);

						if (!sessionDB.getTransaction().isActive()) {
							sessionDB.beginTransaction();
						}
						Recipe przepis = db.getRecipe(Rec_id);
						Set<Recipe> przepisy = new HashSet<Recipe>();

						try {
							if (!sessionDB.getTransaction().isActive()) {
								sessionDB.beginTransaction();
							}

							RecipeIngredient recipeI = ri.addRI(przepis, skladnik, 1);
							if (!sessionDB.getTransaction().isActive()) {
								sessionDB.beginTransaction();
							}
							przepis.addRecipeIngredient(recipeI);

							if (sessionDB.getTransaction().isActive()) {
								sessionDB.getTransaction().commit();
							}
							JOptionPane.showMessageDialog(null, "Składnik pomyślnie dodany do przepisu", "Informacja",
									JOptionPane.INFORMATION_MESSAGE);

						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Wystąpił błąd:" + e2.getMessage(), "Błąd",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Najpierw uzupełnij dane przepisu", "Błąd",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		add(btnAddIngredient);

		JLabel lblAdded = new JLabel("Dodane");
		lblAdded.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblAdded);

		listAdded = new JTable(model);
		springLayout.putConstraint(SpringLayout.NORTH, listAdded, 320, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, listAdded, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblAdded, -6, SpringLayout.NORTH, listAdded);
		springLayout.putConstraint(SpringLayout.WEST, listAdded, 553, SpringLayout.WEST, this);
		add(listAdded);

		JButton btnSave = new JButton("ZAPISZ PRZEPIS");
		springLayout.putConstraint(SpringLayout.EAST, lblAdded, 0, SpringLayout.EAST, btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					RecipeController db = new RecipeController(sessionDB);
					if (!sessionDB.getTransaction().isActive()) {
						sessionDB.beginTransaction();
					}
					Recipe przepis = db.getRecipe(Rec_id);
					Set<RecipeIngredient> skladniki = new HashSet<RecipeIngredient>();
					skladniki = przepis.getRecipesIngredients();
					db.addIngredientsToRecipe(przepis, skladniki);

				} catch (Exception e2) {

				}
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, btnSave, -25, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnSave, 0, SpringLayout.SOUTH, btnAdd);
		add(btnSave);

		JButton btnNewIngredient = new JButton("NOWY SKŁADNIK");
		springLayout.putConstraint(SpringLayout.EAST, listAdded, 0, SpringLayout.EAST, btnNewIngredient);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewIngredient, 36, SpringLayout.SOUTH, btnSave);
		springLayout.putConstraint(SpringLayout.EAST, btnNewIngredient, -10, SpringLayout.EAST, this);
		btnNewIngredient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewIngredient window = new NewIngredient(sessionDB);
				window.setVisible(true);
			}
		});
		add(btnNewIngredient);

		JButton btnRefresh = new JButton("ODŚWIEŻ");
		springLayout.putConstraint(SpringLayout.EAST, btnAddIngredient, -114, SpringLayout.WEST, btnRefresh);
		springLayout.putConstraint(SpringLayout.NORTH, btnRefresh, 36, SpringLayout.SOUTH, btnSave);
		springLayout.putConstraint(SpringLayout.EAST, btnRefresh, -130, SpringLayout.EAST, this);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				populateIngredients(sessionDB);
				populateAdded(sessionDB);
			}
		});
		add(btnRefresh);

		comboBoxTyp = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxTyp, 35, SpringLayout.SOUTH, textFieldName);
		springLayout.putConstraint(SpringLayout.WEST, comboBoxTyp, 35, SpringLayout.EAST, lblType);
		springLayout.putConstraint(SpringLayout.EAST, comboBoxTyp, 153, SpringLayout.WEST, this);
		comboBoxTyp.setModel(
				new DefaultComboBoxModel(new String[] {"SNIADANIE", "KOLACJA", "OBIAD", "DESER", "PRZEKASKA"}));
		add(comboBoxTyp);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 112, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -6, SpringLayout.WEST, listAdded);
		springLayout.putConstraint(SpringLayout.EAST, txtrDesc, -6, SpringLayout.WEST, scrollPane);
		springLayout.putConstraint(SpringLayout.SOUTH, lblIngredients, -6, SpringLayout.NORTH, scrollPane);
		springLayout.putConstraint(SpringLayout.NORTH, txtrDesc, 2, SpringLayout.NORTH, scrollPane);
		springLayout.putConstraint(SpringLayout.SOUTH, txtrDesc, 0, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 28, SpringLayout.SOUTH, lblDesc);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -10, SpringLayout.SOUTH, this);
		add(scrollPane);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		// TODO Auto-generated constructor stub
		
		populateIngredients(sessionDB);
	}

	public TableModel getDataFromDatabase(Session psessionDB) {
		IngredientController db = new IngredientController(psessionDB);
		db.getAllIngredients();
		List<Ingredient> skladniki = db.getAllIngredients();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Nazwa");
		model.addColumn("L");
		model.addColumn("G");
		model.addColumn("M");
		model.addColumn("Kalorycznosc");
		System.out.println("Ilość składników: " + skladniki.size());
		for (Ingredient skladnik : db.getAllIngredients()) {
			System.out.println(skladnik);
			model.addRow(new Object[] { skladnik.getIngredientName(), skladnik.isLactose(), skladnik.isGluten(),
					skladnik.isMeat(), skladnik.getCalories() });
		}
		return model;
	}

	public TableModel getAddFromDatabase(Session psessionDB) {
		RecipeController db = new RecipeController(psessionDB);
		if (!psessionDB.getTransaction().isActive()) {
			psessionDB.beginTransaction();
		}
		Recipe przepis = db.getRecipe(Rec_id);
		Set<RecipeIngredient> skladniki = db.getIngredientsFromRecipe(przepis);
		DefaultTableModel model = new DefaultTableModel(0, 5);
		System.out.println("Ilość składników z przepisu: " + skladniki.size());
		for (RecipeIngredient skladnik : db.getIngredientsFromRecipe(przepis)) {
			System.out.println(skladnik);
			model.addRow(new Object[] { skladnik.getIngredient().getIngredientName(),
					skladnik.getIngredient().isLactose(), skladnik.getIngredient().isGluten(),
					skladnik.getIngredient().isMeat(), skladnik.getIngredient().getCalories() });
		}
		return model;
	}

	private void populateIngredients(Session psessionDB) {
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(getDataFromDatabase(psessionDB));
		table.repaint();
	}

	private void populateAdded(Session psessionDB) {
		listAdded.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAdded.setModel(getAddFromDatabase(psessionDB));
		listAdded.repaint();
	}
}

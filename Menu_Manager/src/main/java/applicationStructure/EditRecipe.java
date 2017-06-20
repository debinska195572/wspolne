package applicationStructure;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JScrollPane;

public class EditRecipe extends javax.swing.JFrame {

	private JFrame frame;
	private JTextField textName;
	private JTable listAdded;
	private JTable listIngredients;
	private String Rec_id;
	private JTextArea textDesc;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditRecipe(String Recipe_name, final Session sessionDB) {
		initialize();
		setSize(new Dimension(400, 600));
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);

		Rec_id = Recipe_name;

		textName = new JTextField();
		textName.setEditable(false);
		springLayout.putConstraint(SpringLayout.NORTH, textName, 31, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textName, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(textName);
		textName.setColumns(10);

		JLabel lblNazwa = new JLabel("Nazwa:");
		springLayout.putConstraint(SpringLayout.WEST, lblNazwa, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNazwa, -5, SpringLayout.NORTH, textName);
		getContentPane().add(lblNazwa);

		JLabel lblTyp = new JLabel("Typ:");
		springLayout.putConstraint(SpringLayout.NORTH, lblTyp, 6, SpringLayout.SOUTH, textName);
		springLayout.putConstraint(SpringLayout.WEST, lblTyp, 0, SpringLayout.WEST, textName);
		getContentPane().add(lblTyp);

		comboBox = new JComboBox();
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] {"SNIADANIE", "KOLACJA", "OBIAD", "DESER", "PRZEKASKA"}));
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 6, SpringLayout.SOUTH, lblTyp);
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 0, SpringLayout.WEST, textName);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, 0, SpringLayout.EAST, textName);
		getContentPane().add(comboBox);

		JLabel lblOpis = new JLabel("Opis:");
		springLayout.putConstraint(SpringLayout.NORTH, lblOpis, 6, SpringLayout.SOUTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, lblOpis, 0, SpringLayout.WEST, textName);
		getContentPane().add(lblOpis);

		textDesc = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textDesc, 6, SpringLayout.SOUTH, lblOpis);
		springLayout.putConstraint(SpringLayout.WEST, textDesc, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textDesc, 82, SpringLayout.SOUTH, lblOpis);
		springLayout.putConstraint(SpringLayout.EAST, textDesc, 246, SpringLayout.EAST, textName);
		getContentPane().add(textDesc);

		JButton btnAnuluj = new JButton("ANULUJ");
		btnAnuluj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnAnuluj, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnAnuluj, -10, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnAnuluj);

		JButton btnZapisz = new JButton("ZAPISZ");
		btnZapisz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecipeController db = new RecipeController(sessionDB);
				if (!sessionDB.getTransaction().isActive()) {
					sessionDB.beginTransaction();
				}
				Recipe przepis = db.getRecipe(Rec_id);
				if (comboBox.getSelectedItem() != null) {
					System.out.println(comboBox.getSelectedItem().toString());
				}
				try {
					if (!sessionDB.getTransaction().isActive()) {
						sessionDB.beginTransaction();
					}
					db.changeRecipe(przepis, textName.getText(), comboBox.getSelectedItem().toString(),
							textDesc.getText());
					Rec_id = textName.getText();
					JOptionPane.showMessageDialog(null, "Przepis zaktualizowany pomyślnie", "Informacja",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null, "Nie można zaktualizować przepisu. Błąd:\n" + e1.getMessage(),
							"Błąd", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnZapisz, 0, SpringLayout.NORTH, btnAnuluj);
		springLayout.putConstraint(SpringLayout.EAST, btnZapisz, -110, SpringLayout.EAST, getContentPane());
		getContentPane().add(btnZapisz);

		JLabel lblSkadniki = new JLabel("Składniki:");
		springLayout.putConstraint(SpringLayout.NORTH, lblSkadniki, 6, SpringLayout.SOUTH, textDesc);
		springLayout.putConstraint(SpringLayout.WEST, lblSkadniki, 0, SpringLayout.WEST, textName);
		getContentPane().add(lblSkadniki);

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Nazwa");
		model.addColumn("L");
		model.addColumn("G");
		model.addColumn("M");
		model.addColumn("Kalorycznosc");

		listAdded = new JTable(model);
		springLayout.putConstraint(SpringLayout.NORTH, listAdded, 6, SpringLayout.SOUTH, lblSkadniki);
		springLayout.putConstraint(SpringLayout.WEST, listAdded, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, listAdded, 89, SpringLayout.SOUTH, lblSkadniki);
		springLayout.putConstraint(SpringLayout.EAST, listAdded, 0, SpringLayout.EAST, textDesc);
		listAdded.setBackground(Color.WHITE);
		getContentPane().add(listAdded);

		JLabel lblWszystkie = new JLabel("Wszystkie:");
		springLayout.putConstraint(SpringLayout.NORTH, lblWszystkie, 324, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblWszystkie, 0, SpringLayout.WEST, textName);
		getContentPane().add(lblWszystkie);

		JButton btnUsuZPrzepisu = new JButton("USUŃ Z PRZEPISU");
		springLayout.putConstraint(SpringLayout.NORTH, btnUsuZPrzepisu, 87, SpringLayout.SOUTH, lblWszystkie);
		btnUsuZPrzepisu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] row_indexes = listAdded.getSelectedRows();
				for (int i = 0; i < row_indexes.length; i++) {
					String wartosc = listAdded.getValueAt(row_indexes[i], 0).toString();
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

						RecipeIngredient delete = new RecipeIngredient(przepis, skladnik, 1);
						if (!sessionDB.getTransaction().isActive()) {
							sessionDB.beginTransaction();
						}

						Recipe deleted = db.removeIngredientFromRecipe(przepis, delete);
						if (!sessionDB.getTransaction().isActive()) {
							sessionDB.beginTransaction();
						}

						deleted.removeRecipeIngredient(delete);
						ri.deleteRI(delete);

						if (sessionDB.getTransaction().isActive()) {
							sessionDB.getTransaction().commit();
						}
						JOptionPane.showMessageDialog(null, "Składnik usunięty", "Informacja",
								JOptionPane.INFORMATION_MESSAGE);

					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Wystąpił błąd:" + e2.getMessage(), "Błąd",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnUsuZPrzepisu, 0, SpringLayout.WEST, textName);
		getContentPane().add(btnUsuZPrzepisu);

		JButton btnAdd = new JButton("DODAJ DO PRZEPISU");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int[] row_indexes = listIngredients.getSelectedRows();
				for (int i = 0; i < row_indexes.length; i++) {
					String wartosc = listIngredients.getValueAt(row_indexes[i], 0).toString();
					System.out.println(wartosc);
					RecipeController db = new RecipeController(sessionDB);
					IngredientController dbin = new IngredientController(sessionDB);
					Ingredient skladnik = dbin.getIngredient(wartosc);
					if (!sessionDB.getTransaction().isActive()) {
						sessionDB.beginTransaction();
					}
					Recipe przepis = db.getRecipe(Rec_id);
					Set<Recipe> przepisy = new HashSet<Recipe>();

					try {
						if (!sessionDB.getTransaction().isActive()) {
							sessionDB.beginTransaction();
						}

						RecipeIngredient ri = new RecipeIngredient(przepis, skladnik, 1);
						przepis.addRecipeIngredient(ri);

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
			}

		});
		springLayout.putConstraint(SpringLayout.NORTH, btnAdd, 6, SpringLayout.SOUTH, btnUsuZPrzepisu);
		springLayout.putConstraint(SpringLayout.WEST, btnAdd, 0, SpringLayout.WEST, textName);
		getContentPane().add(btnAdd);

		JButton btnOdwie = new JButton("ODŚWIEŻ");
		springLayout.putConstraint(SpringLayout.NORTH, btnOdwie, 108, SpringLayout.SOUTH, listAdded);
		springLayout.putConstraint(SpringLayout.WEST, btnOdwie, 131, SpringLayout.EAST, btnUsuZPrzepisu);
		btnOdwie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populateAdded(sessionDB);
				populateIngredients(sessionDB);
			}
		});
		getContentPane().add(btnOdwie);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, lblWszystkie);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 69, SpringLayout.SOUTH, lblWszystkie);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, textDesc);
		getContentPane().add(scrollPane);
		
				listIngredients = new JTable(model);
				scrollPane.setViewportView(listIngredients);
				springLayout.putConstraint(SpringLayout.NORTH, listIngredients, 4, SpringLayout.NORTH, comboBox);
				springLayout.putConstraint(SpringLayout.WEST, listIngredients, 0, SpringLayout.WEST, btnZapisz);
				springLayout.putConstraint(SpringLayout.SOUTH, listIngredients, -233, SpringLayout.SOUTH, lblWszystkie);
				springLayout.putConstraint(SpringLayout.EAST, listIngredients, -81, SpringLayout.EAST, textDesc);
				listIngredients.setBackground(Color.WHITE);
		getData(sessionDB);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		DefaultTableModel model = new DefaultTableModel(0,5);
		
		System.out.println("Ilość składników z przepisu: " + skladniki.size());
		for (RecipeIngredient skladnik : db.getIngredientsFromRecipe(przepis)) {
			System.out.println(skladnik);
			model.addRow(new Object[] { skladnik.getIngredient().getIngredientName(),
					skladnik.getIngredient().isLactose(), skladnik.getIngredient().isGluten(),
					skladnik.getIngredient().isMeat(), skladnik.getIngredient().getCalories() });
		}
		return model;
	}

	private void getData(Session psessionDB) {
		RecipeController db = new RecipeController(psessionDB);

		if (!psessionDB.getTransaction().isActive()) {
			psessionDB.beginTransaction();
		}
		Recipe przepis = db.getRecipe(Rec_id);
		textName.setText(przepis.getRecipeName());
		textDesc.setText(przepis.getContent());
		populateIngredients(psessionDB);
		populateAdded(psessionDB);
		comboBox.setSelectedItem(przepis.getRecipeType());
	}

	private void populateIngredients(Session psessionDB) {
		listIngredients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listIngredients.setModel(getDataFromDatabase(psessionDB));
		listIngredients.repaint();
	}

	private void populateAdded(Session psessionDB) {
		listAdded.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAdded.setModel(getAddFromDatabase(psessionDB));
		listAdded.repaint();
	}
}

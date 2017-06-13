package applicationStructure;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JTextField;

public class CreatorWindow extends javax.swing.JPanel {
	private JTextField textFieldName;
	private JTextField textFieldType;

	public CreatorWindow() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JButton btnAdd = new JButton("DODAJ PRZEPIS");
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
		
		textFieldType = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldType, -1, SpringLayout.NORTH, lblType);
		springLayout.putConstraint(SpringLayout.EAST, textFieldType, 0, SpringLayout.EAST, textFieldName);
		add(textFieldType);
		textFieldType.setColumns(10);
		
		JLabel lblDesc = new JLabel("Opis");
		lblDesc.setFont(new Font("Calibri", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblDesc, 157, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblType, -32, SpringLayout.NORTH, lblDesc);
		springLayout.putConstraint(SpringLayout.WEST, lblDesc, 0, SpringLayout.WEST, btnAdd);
		add(lblDesc);
		
		JTextArea txtrDesc = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, txtrDesc, 22, SpringLayout.SOUTH, lblDesc);
		springLayout.putConstraint(SpringLayout.WEST, txtrDesc, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, txtrDesc, -9, SpringLayout.SOUTH, this);
		txtrDesc.setRows(10);
		txtrDesc.setText("Przepis\r\n1.\r\n2.\r\n3.\r\n4.\r\n5.\r\n6.\r\n");
		add(txtrDesc);
		
		JLabel lblIngredients = new JLabel("Składniki");
		springLayout.putConstraint(SpringLayout.NORTH, lblIngredients, 0, SpringLayout.NORTH, lblName);
		lblIngredients.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblIngredients);
		
		JList listIngredients = new JList();
		springLayout.putConstraint(SpringLayout.EAST, txtrDesc, -18, SpringLayout.WEST, listIngredients);
		springLayout.putConstraint(SpringLayout.WEST, listIngredients, 264, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, listIngredients, -9, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, listIngredients, 13, SpringLayout.SOUTH, lblIngredients);
		springLayout.putConstraint(SpringLayout.WEST, lblIngredients, 0, SpringLayout.WEST, listIngredients);
		add(listIngredients);
		
		JButton btnAddIngredient = new JButton("DODAJ");
		springLayout.putConstraint(SpringLayout.SOUTH, listIngredients, -6, SpringLayout.NORTH, btnAddIngredient);
		springLayout.putConstraint(SpringLayout.NORTH, btnAddIngredient, 223, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, btnAddIngredient, 0, SpringLayout.WEST, listIngredients);
		add(btnAddIngredient);
		
		JLabel lblAdded = new JLabel("Dodane");
		springLayout.putConstraint(SpringLayout.NORTH, lblAdded, 6, SpringLayout.SOUTH, btnAddIngredient);
		springLayout.putConstraint(SpringLayout.WEST, lblAdded, 0, SpringLayout.WEST, listIngredients);
		lblAdded.setFont(new Font("Calibri", Font.BOLD, 15));
		add(lblAdded);
		
		JList listAdded = new JList();
		springLayout.putConstraint(SpringLayout.NORTH, listAdded, 6, SpringLayout.SOUTH, lblAdded);
		springLayout.putConstraint(SpringLayout.WEST, listAdded, 0, SpringLayout.WEST, listIngredients);
		springLayout.putConstraint(SpringLayout.SOUTH, listAdded, -9, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, listAdded, 21, SpringLayout.EAST, this);
		add(listAdded);
		
		JButton btnSave = new JButton("ZAPISZ PRZEPIS");
		springLayout.putConstraint(SpringLayout.EAST, btnSave, -25, SpringLayout.EAST, this);
		btnSave.setEnabled(false);
		springLayout.putConstraint(SpringLayout.SOUTH, btnSave, 0, SpringLayout.SOUTH, btnAdd);
		add(btnSave);
		// TODO Auto-generated constructor stub
	}
}

package applicationStructure;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.SpringLayout;

public class RecipesWindow extends javax.swing.JPanel{

	public RecipesWindow() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JTextArea txtrListOfRecipes = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, txtrListOfRecipes, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtrListOfRecipes, 10, SpringLayout.WEST, this);
		txtrListOfRecipes.setRows(4);
		txtrListOfRecipes.setWrapStyleWord(true);
		txtrListOfRecipes.setText("Lista wszystkich przepisów w postaci JtextArea, \r\ntextbox lub tabeli (co wygodniej) \r\nPo wciśnieciu filtru moje przepisy- wyswietli tylko przepisy użytkownika\r\nprzepisy innych użytkowników są nieedytowalne\r\nwłasne przepisy można edytować i usuwać\r\n");
		add(txtrListOfRecipes);
		
		JCheckBox chckbxMyRecipes = new JCheckBox("Moje przepisy");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxMyRecipes, 32, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, chckbxMyRecipes, -10, SpringLayout.EAST, this);
		add(chckbxMyRecipes);
		// TODO Auto-generated constructor stub
	}

}

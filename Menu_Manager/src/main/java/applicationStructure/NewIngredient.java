package applicationStructure;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;

import org.hibernate.Session;

import databaseController.IngredientController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Checkbox;

public class NewIngredient extends javax.swing.JFrame {

	private JFrame frame;
	private JTextField textNazwa;
	JCheckBox  checkboxMies;
	JCheckBox  checkboxLak;
	JCheckBox  checkboxGlut;
	JSpinner spinnerKalorycznosc;

	/**
	 * Create the application.
	 */
	public NewIngredient(final Session sessionDB) {
		setSize(new Dimension(400, 200));
		getContentPane().setSize(new Dimension(300, 200));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initialize();
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Nazwa:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Kaloryczność:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 12, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		getContentPane().add(lblNewLabel_1);
		
		textNazwa = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textNazwa, 5, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textNazwa, 38, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, textNazwa, 222, SpringLayout.EAST, lblNewLabel);
		getContentPane().add(textNazwa);
		textNazwa.setColumns(10);
		
		JButton btnNewButton = new JButton("Zapisz");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try
				{
					if(textNazwa.getText().length()>0 && ((Integer)spinnerKalorycznosc.getValue())>0){					
						IngredientController db = new IngredientController(sessionDB);
						 if(!sessionDB.getTransaction().isActive()){
							  sessionDB.beginTransaction();
						  }
					db.addIngredient(textNazwa.getText(),checkboxLak.isSelected(), checkboxGlut.isSelected(), (Integer)spinnerKalorycznosc.getValue(), checkboxMies.isSelected());
					if(sessionDB.getTransaction().isActive()){
						  sessionDB.getTransaction().commit();
					  }
					JOptionPane.showMessageDialog(null, "Składnik dodany pomyślnie", "Informacja", JOptionPane.INFORMATION_MESSAGE);
					textNazwa.setText("");
					checkboxGlut.setSelected(false);
					checkboxMies.setSelected(false);
					checkboxLak.setSelected(false);
					spinnerKalorycznosc.setValue(0);
					}else
					{
						JOptionPane.showMessageDialog(null, "Uzupełnij dane składnika", "Błąd", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Nie można dodać składnika do bazy. Błąd:\n"+e2.getMessage(), "Błąd", JOptionPane.INFORMATION_MESSAGE);
				}		
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Anuluj");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false); 
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -6, SpringLayout.WEST, btnNewButton);
		getContentPane().add(btnNewButton_1);
		
		spinnerKalorycznosc = new JSpinner();
		springLayout.putConstraint(SpringLayout.NORTH, spinnerKalorycznosc, 5, SpringLayout.SOUTH, textNazwa);
		springLayout.putConstraint(SpringLayout.WEST, spinnerKalorycznosc, 8, SpringLayout.EAST, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.EAST, spinnerKalorycznosc, 155, SpringLayout.WEST, getContentPane());
		getContentPane().add(spinnerKalorycznosc);
		
		checkboxGlut = new JCheckBox ("Gluten");
		springLayout.putConstraint(SpringLayout.WEST, checkboxGlut, 0, SpringLayout.WEST, lblNewLabel);
		getContentPane().add(checkboxGlut);
		
		checkboxLak = new JCheckBox ("Laktoza");
		springLayout.putConstraint(SpringLayout.NORTH, checkboxLak, 6, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, checkboxLak, 0, SpringLayout.WEST, lblNewLabel);
		getContentPane().add(checkboxLak);
		
		checkboxMies = new JCheckBox ("Mięso");
		springLayout.putConstraint(SpringLayout.NORTH, checkboxGlut, 6, SpringLayout.SOUTH, checkboxMies);
		springLayout.putConstraint(SpringLayout.NORTH, checkboxMies, 6, SpringLayout.SOUTH, checkboxLak);
		springLayout.putConstraint(SpringLayout.WEST, checkboxMies, 0, SpringLayout.WEST, lblNewLabel);
		getContentPane().add(checkboxMies);
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

package applicationStructure;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;

import liquibase.change.core.CreateIndexChange;
import lombok.Getter;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.hibernate.Session;

import databaseController.AccountController;
import databaseController.IngredientController;
import databaseManager.HibernateUtil;
import databaseManager.Ingredient;
import javax.swing.JSpinner;

public class CreatorIngredient extends JFrame {

	
	private JTextField txtNazwa;
	JSpinner spinner = new JSpinner();
	Session psessionDB;

	/**
	 * Create the application.
	 */
	public CreatorIngredient(Session sessionDB) {
		initialize();
		psessionDB=sessionDB;
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtNazwa = new JTextField();
		txtNazwa.setText("Nazwa");
		txtNazwa.setColumns(10);
		
		final JCheckBox chckbxLaktoza = new JCheckBox("Laktoza");
		
		final JCheckBox chckbxGluten = new JCheckBox("Gluten");
		
		final JCheckBox chckbxMiso = new JCheckBox("Mięso");
		
		JButton btnZapisz = new JButton("ZAPISZ");
		btnZapisz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(txtNazwa.getText().length()>0){
				// INSERT
					addIngredient();
					}
				
				else System.out.println("zla dlugosc");
			}

			private void addIngredient() {
				// TODO Auto-generated method stub
				try {
					//Session sessionDB = HibernateUtil.getSessionFactory().openSession();
					IngredientController db = new IngredientController(psessionDB);
								 
					
					db.addIngredient(txtNazwa.getText(), chckbxLaktoza.isSelected(), chckbxGluten.isSelected(), (Integer) spinner.getValue(), chckbxMiso.isSelected());
				
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});
		
		//kaloryczność walidacja czy liczba
		
		JButton btnAnuluj = new JButton("ANULUJ");
		btnAnuluj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		
		
		
		JLabel lblKaloryczno = new JLabel("Kaloryczność");
		GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxGluten)
						.addComponent(chckbxLaktoza)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxMiso)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblKaloryczno)
									.addGap(18)
									.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtNazwa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnZapisz, Alignment.TRAILING)
								.addComponent(btnAnuluj, Alignment.TRAILING))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(txtNazwa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(chckbxLaktoza)
					.addGap(18)
					.addComponent(chckbxGluten)
					.addGap(18)
					.addComponent(chckbxMiso)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKaloryczno)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(41, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(160, Short.MAX_VALUE)
					.addComponent(btnZapisz)
					.addGap(18)
					.addComponent(btnAnuluj)
					.addGap(25))
		);
		this.getContentPane().setLayout(groupLayout);
	}
}

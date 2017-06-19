/**
 * 
 */
package calculations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.JList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import databaseController.IngredientController;
import databaseController.RIController;
import databaseManager.*;

/**
 * @author Marcin
 *
 */
public final class GenerateRecipe {

	private User user;
	private int forSwitch;
	private Session session;
	private Transaction tx;
	private static List<Recipe> recipes;
	private RIController riController;
	Random generator;
	//
	//
	// private IngredientController ingredientController;

	public GenerateRecipe(final User loggedUser, final Session sessionDB) {
		this.session = sessionDB;
		this.user = loggedUser;
		riController = new RIController(session);
		generator = new Random();
		//
		// ingredientController=new IngredientController(session);
	}

	public void getSniadanie(float minCalories) {
		String przepis;
		List<Ingredient> listDobra = new ArrayList<Ingredient>();
		Recipe recipe;

		List<RecipeIngredient> list = riController.getAllRecipesIngredients();
		// System.out.println(list.size());

		int i;
		int o=0;
		boolean juz=false;
		
		while (juz==false) {
			
			o++;
			i = generator.nextInt(list.size());

			recipe = list.get(i).getRecipe();

			Set<RecipeIngredient> set = recipe.getRecipesIngredients();
			
			
			List<RecipeIngredient> secik = new ArrayList<RecipeIngredient>(set);
			
						
			int z = secik.size();
			
			int pom=0;
			
			for (int y = 0; y <z; y++) {
				
				
				if (secik.get(y).getIngredient().isGluten() == user.isGlutenTolerance()
						&& secik.get(y).getIngredient().isLactose() == user.isLactoseTolerance()
						&& (secik.get(y).getIngredient().isMeat() && user.getDiet().equals("NORMALNA"))) {
					pom++;
					listDobra.add(secik.get(y).getIngredient());

				}
				else if (secik.get(y).getIngredient().isGluten() != user.isGlutenTolerance()
						&& secik.get(y).getIngredient().isLactose() == user.isLactoseTolerance()
						&& (secik.get(y).getIngredient().isMeat() && user.getDiet().equals("NORMALNA"))) {
					pom++;
					listDobra.add(secik.get(y).getIngredient());
					
				}
				else if (secik.get(y).getIngredient().isGluten() == user.isGlutenTolerance()
						&& secik.get(y).getIngredient().isLactose() != user.isLactoseTolerance()
						&& (secik.get(y).getIngredient().isMeat() && user.getDiet().equals("NORMALNA"))) {
					pom++;
					listDobra.add(secik.get(y).getIngredient());
					
				}
				else if (secik.get(y).getIngredient().isGluten() == user.isGlutenTolerance()
						&& secik.get(y).getIngredient().isLactose() == user.isLactoseTolerance()
						&& (!secik.get(y).getIngredient().isMeat() && user.getDiet().equals("NORMALNA"))) {
					pom++;
					listDobra.add(secik.get(y).getIngredient());
					
				}
				else if (secik.get(y).getIngredient().isGluten() != user.isGlutenTolerance()
						&& secik.get(y).getIngredient().isLactose() != user.isLactoseTolerance()
						&& (secik.get(y).getIngredient().isMeat() && user.getDiet().equals("NORMALNA"))) {
					pom++;
					listDobra.add(secik.get(y).getIngredient());
					
				}
				else if (secik.get(y).getIngredient().isGluten() == user.isGlutenTolerance()
						&& secik.get(y).getIngredient().isLactose() != user.isLactoseTolerance()
						&& (!secik.get(y).getIngredient().isMeat() && user.getDiet().equals("NORMALNA"))) {
					pom++;
					listDobra.add(secik.get(y).getIngredient());
					
				}
				else if (secik.get(y).getIngredient().isGluten() != user.isGlutenTolerance()
						&& secik.get(y).getIngredient().isLactose() == user.isLactoseTolerance()
						&& (!secik.get(y).getIngredient().isMeat() && user.getDiet().equals("NORMALNA"))) {
					pom++;
					listDobra.add(secik.get(y).getIngredient());
					
				}
				else if (secik.get(y).getIngredient().isGluten() != user.isGlutenTolerance()
						&& secik.get(y).getIngredient().isLactose() != user.isLactoseTolerance()
						&& (!secik.get(y).getIngredient().isMeat() && user.getDiet().equals("NORMALNA"))) {
					pom++;
					listDobra.add(secik.get(y).getIngredient());
					
				}

			}
			
			if((pom==z) || o==100)
			{
				juz=true;
			}

		}

		
		
		
		
		
		

	}

	// public GenerateRecipe(User user)
	// {
	// this.user = user;
	//
	// }
	//
	// public GenerateRecipe(){
	//
	//
	//
	//
	// session = HibernateUtil.getSessionFactory().openSession();
	// tx = null;
	// try {
	// tx = session.beginTransaction();
	//
	// tryToGetGoodRecipe();
	//
	// tx.commit();
	// }
	// catch (Exception e) {
	// if (tx!=null) tx.rollback();
	// e.printStackTrace();
	// }finally {
	// session.close();
	// }
	//
	//
	// }
	//
	// private void tryToGetGoodRecipe() {
	//
	//
	//
	//
	// }

}

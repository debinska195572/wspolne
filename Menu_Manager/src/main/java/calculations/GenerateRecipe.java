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
import databaseController.RecipeController;
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
	private RecipeController recipeController;
	Random generator;
	//
	//
	// private IngredientController ingredientController;

	public GenerateRecipe(final User loggedUser, final Session sessionDB) {
		this.session = sessionDB;
		this.user = loggedUser;
		riController = new RIController(session);
		generator = new Random();
		recipeController = new RecipeController(session);
		//
		// ingredientController=new IngredientController(session);
	}

	public String getSniadanie(float minCalories) {
		String przepis="";
		List<Ingredient> listDobra = new ArrayList<Ingredient>();
		Recipe recipe;
		
		List<Recipe> listOfRecipes = recipeController.getAllRecipes();
		
		List<RecipeIngredient> listOfIngredientsOfRecipe;
		
//		for(int i=0; i<listOfRecipes.size(); i++)
//		{
//			
//			System.out.println("Przepis nazwa: " + listOfRecipes.get(i).getRecipeName());
//			
//			listOfIngredientsOfRecipe=riController.getRecipesIngredientsByRecipe(listOfRecipes.get(i).getRecipeName());
//			
//			for(int y=0; y<listOfIngredientsOfRecipe.size(); y++)
//			{
//			
//				System.out.println("Skladnik: " + listOfIngredientsOfRecipe.get(y).getIngredient().getIngredientName());
//			}
//			
//			
//		}

		int i;
		int o=0;
		boolean juz=false;
		recipe=null;
		
		while (juz==false) {
			
			o++;
			i = generator.nextInt(listOfRecipes.size());

			recipe = listOfRecipes.get(i);
//
//			Set<RecipeIngredient> set = recipe.getRecipesIngredients();
//			
//			
//			List<RecipeIngredient> listOfIngredientsOfRecipe = new ArrayList<RecipeIngredient>(set);
			
			listOfIngredientsOfRecipe=riController.getRecipesIngredientsByRecipe(recipe.getRecipeName());
						
			int z = listOfIngredientsOfRecipe.size();
			
			int pom=0;
			
			for (int y = 0; y <z; y++) {
				
				
				if (listOfIngredientsOfRecipe.get(y).getIngredient().isGluten() == user.isGlutenTolerance()
						&& listOfIngredientsOfRecipe.get(y).getIngredient().isLactose() == user.isLactoseTolerance()
						&& (listOfIngredientsOfRecipe.get(y).getIngredient().isMeat() && user.getDiet().equals("NORMALNA"))) {
					pom++;
					listDobra.add(listOfIngredientsOfRecipe.get(y).getIngredient());

				}
				else if (listOfIngredientsOfRecipe.get(y).getIngredient().isGluten() != user.isGlutenTolerance()
						&& listOfIngredientsOfRecipe.get(y).getIngredient().isLactose() == user.isLactoseTolerance()
						&& (listOfIngredientsOfRecipe.get(y).getIngredient().isMeat() && user.getDiet().equals("NORMALNA"))) {
					pom++;
					listDobra.add(listOfIngredientsOfRecipe.get(y).getIngredient());
					
				}
				else if (listOfIngredientsOfRecipe.get(y).getIngredient().isGluten() == user.isGlutenTolerance()
						&& listOfIngredientsOfRecipe.get(y).getIngredient().isLactose() != user.isLactoseTolerance()
						&& (listOfIngredientsOfRecipe.get(y).getIngredient().isMeat() && user.getDiet().equals("NORMALNA"))) {
					pom++;
					listDobra.add(listOfIngredientsOfRecipe.get(y).getIngredient());
					
				}
				else if (listOfIngredientsOfRecipe.get(y).getIngredient().isGluten() == user.isGlutenTolerance()
						&& listOfIngredientsOfRecipe.get(y).getIngredient().isLactose() == user.isLactoseTolerance()
						&& (!listOfIngredientsOfRecipe.get(y).getIngredient().isMeat() && user.getDiet().equals("NORMALNA"))) {
					pom++;
					listDobra.add(listOfIngredientsOfRecipe.get(y).getIngredient());
					
				}
				else if (listOfIngredientsOfRecipe.get(y).getIngredient().isGluten() != user.isGlutenTolerance()
						&& listOfIngredientsOfRecipe.get(y).getIngredient().isLactose() != user.isLactoseTolerance()
						&& (listOfIngredientsOfRecipe.get(y).getIngredient().isMeat() && user.getDiet().equals("NORMALNA"))) {
					pom++;
					listDobra.add(listOfIngredientsOfRecipe.get(y).getIngredient());
					
				}
				else if (listOfIngredientsOfRecipe.get(y).getIngredient().isGluten() == user.isGlutenTolerance()
						&& listOfIngredientsOfRecipe.get(y).getIngredient().isLactose() != user.isLactoseTolerance()
						&& (!listOfIngredientsOfRecipe.get(y).getIngredient().isMeat() && user.getDiet().equals("NORMALNA"))) {
					pom++;
					listDobra.add(listOfIngredientsOfRecipe.get(y).getIngredient());
					
				}
				else if (listOfIngredientsOfRecipe.get(y).getIngredient().isGluten() != user.isGlutenTolerance()
						&& listOfIngredientsOfRecipe.get(y).getIngredient().isLactose() == user.isLactoseTolerance()
						&& (!listOfIngredientsOfRecipe.get(y).getIngredient().isMeat() && user.getDiet().equals("NORMALNA"))) {
					pom++;
					listDobra.add(listOfIngredientsOfRecipe.get(y).getIngredient());
					
				}
				else if (listOfIngredientsOfRecipe.get(y).getIngredient().isGluten() != user.isGlutenTolerance()
						&& listOfIngredientsOfRecipe.get(y).getIngredient().isLactose() != user.isLactoseTolerance()
						&& (!listOfIngredientsOfRecipe.get(y).getIngredient().isMeat() && user.getDiet().equals("NORMALNA"))) {
					pom++;
					listDobra.add(listOfIngredientsOfRecipe.get(y).getIngredient());
					
				}

			}
			
			if((pom==z) || o==100)
			{
				juz=true;
			}
			else if (o==100 && (pom!=z)) {
				recipe=null;
			}

		}

		if (recipe!=null) {
			przepis+="Przepis: " + recipe.getRecipeName() + "\n" + "Składniki: \n";
			for(int h=0; h<listDobra.size(); h++)
			{
				przepis+="-" + listDobra.get(h).getIngredientName() + "\n";
			}
			
		}
		
		return przepis;
		
		
		
		
		

	}



}

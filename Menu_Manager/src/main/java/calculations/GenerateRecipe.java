/**
 * 
 */
package calculations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.hibernate.Session;
import databaseController.RIController;
import databaseController.RecipeController;
import databaseManager.*;


public final class GenerateRecipe {

	private User user;
	private Session session;
	private RIController riController;
	private RecipeController recipeController;
	Random generator;
	float iloscKalorii;
	String przepisXml;
	
	public GenerateRecipe(final User loggedUser, final Session sessionDB) {
		this.session = sessionDB;
		this.user = loggedUser;
		riController = new RIController(session);
		generator = new Random();
		recipeController = new RecipeController(session);
		//
		// ingredientController=new IngredientController(session);
	}

	public String getRecipe(float minCalories, String recipeType) {
		String przepis = "";
		List<Ingredient> listDobra = new ArrayList<Ingredient>();
		Recipe recipe;

		List<Recipe> listOfRecipes = recipeController.getAllRecipes();

		List<RecipeIngredient> listOfIngredientsOfRecipe;


		int i;
		int o = 0;
		boolean juz = false;
		recipe = null;
		iloscKalorii = 0;

		while (juz == false) {

			o++;
			i = generator.nextInt(listOfRecipes.size());

			recipe = listOfRecipes.get(i);
			if (!recipe.getRecipeType().equals(recipeType)) {
				continue;
			}

			listOfIngredientsOfRecipe = riController.getRecipesIngredientsByRecipe(recipe.getRecipeName());

			int z = listOfIngredientsOfRecipe.size();

			int pom = 0;
			iloscKalorii = 0;

			for (int y = 0; y < z; y++) {

				if (listOfIngredientsOfRecipe.get(y).getIngredient().isGluten() == user.isGlutenTolerance()
						&& listOfIngredientsOfRecipe.get(y).getIngredient().isLactose() == user.isLactoseTolerance()
						&& (listOfIngredientsOfRecipe.get(y).getIngredient().isMeat()
								&& user.getDiet().equals("NORMALNA"))) {
					pom++;
					listDobra.add(listOfIngredientsOfRecipe.get(y).getIngredient());

				} else if (listOfIngredientsOfRecipe.get(y).getIngredient().isGluten() != user.isGlutenTolerance()
						&& listOfIngredientsOfRecipe.get(y).getIngredient().isLactose() == user.isLactoseTolerance()
						&& (listOfIngredientsOfRecipe.get(y).getIngredient().isMeat()
								&& user.getDiet().equals("NORMALNA"))) {
					pom++;
					listDobra.add(listOfIngredientsOfRecipe.get(y).getIngredient());

				} else if (listOfIngredientsOfRecipe.get(y).getIngredient().isGluten() == user.isGlutenTolerance()
						&& listOfIngredientsOfRecipe.get(y).getIngredient().isLactose() != user.isLactoseTolerance()
						&& (listOfIngredientsOfRecipe.get(y).getIngredient().isMeat()
								&& user.getDiet().equals("NORMALNA"))) {
					pom++;
					listDobra.add(listOfIngredientsOfRecipe.get(y).getIngredient());

				} else if (listOfIngredientsOfRecipe.get(y).getIngredient().isGluten() == user.isGlutenTolerance()
						&& listOfIngredientsOfRecipe.get(y).getIngredient().isLactose() == user.isLactoseTolerance()
						&& (!listOfIngredientsOfRecipe.get(y).getIngredient().isMeat()
								&& user.getDiet().equals("NORMALNA"))) {
					pom++;
					listDobra.add(listOfIngredientsOfRecipe.get(y).getIngredient());

				} else if (listOfIngredientsOfRecipe.get(y).getIngredient().isGluten() != user.isGlutenTolerance()
						&& listOfIngredientsOfRecipe.get(y).getIngredient().isLactose() != user.isLactoseTolerance()
						&& (listOfIngredientsOfRecipe.get(y).getIngredient().isMeat()
								&& user.getDiet().equals("NORMALNA"))) {
					pom++;
					listDobra.add(listOfIngredientsOfRecipe.get(y).getIngredient());

				} else if (listOfIngredientsOfRecipe.get(y).getIngredient().isGluten() == user.isGlutenTolerance()
						&& listOfIngredientsOfRecipe.get(y).getIngredient().isLactose() != user.isLactoseTolerance()
						&& (!listOfIngredientsOfRecipe.get(y).getIngredient().isMeat()
								&& user.getDiet().equals("NORMALNA"))) {
					pom++;
					listDobra.add(listOfIngredientsOfRecipe.get(y).getIngredient());

				} else if (listOfIngredientsOfRecipe.get(y).getIngredient().isGluten() != user.isGlutenTolerance()
						&& listOfIngredientsOfRecipe.get(y).getIngredient().isLactose() == user.isLactoseTolerance()
						&& (!listOfIngredientsOfRecipe.get(y).getIngredient().isMeat()
								&& user.getDiet().equals("NORMALNA"))) {
					pom++;
					listDobra.add(listOfIngredientsOfRecipe.get(y).getIngredient());

				} else if (listOfIngredientsOfRecipe.get(y).getIngredient().isGluten() != user.isGlutenTolerance()
						&& listOfIngredientsOfRecipe.get(y).getIngredient().isLactose() != user.isLactoseTolerance()
						&& (!listOfIngredientsOfRecipe.get(y).getIngredient().isMeat()
								&& user.getDiet().equals("NORMALNA"))) {
					pom++;
					listDobra.add(listOfIngredientsOfRecipe.get(y).getIngredient());

				}

			}

			

			if ((pom == z) || o == 100) {
				juz = true;
			} else if (o == 100 && (pom != z)) {
				recipe = null;
			}

		}

		przepisXml = "";

		if (recipe != null) {
			przepis += recipeType + ": " + recipe.getRecipeName() + "\n" + "Składniki: \n";
			przepisXml += "<Przepis>" + recipe.getRecipeName();

			for (int h = 0; h < listDobra.size(); h++) {
				przepis += "-" + listDobra.get(h).getIngredientName() + "\n";
				przepisXml += "<Składnik>" + listDobra.get(h).getIngredientName() + "</Składnik>";

				iloscKalorii += listDobra.get(h).getCalories();
			}
			przepis += "OPIS: " + recipe.getContent() + "\n";
			przepisXml += "<Opis>" + recipe.getContent() + "</Opis>";
			przepisXml += "</Przepis>";

		} else
			przepis = "Przykro nam, nie znaleziono żadnego " + recipeType + ", spełniającego wymagania \n";

		return przepis;

	}

	public float getObliczoneKalorie() {
		return iloscKalorii;
	}

	public String getStringXml() {
		return przepisXml;
	}

}

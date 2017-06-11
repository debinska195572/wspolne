package databaseController;

import org.hibernate.Session;

import databaseManager.RecipeIngredient;



public class RIController {
	Session sessionDB;
	public RIController(Session sessionDB) {
		this.sessionDB = sessionDB;
		
	}
	public RecipeIngredient addRecipeIngredient(int recipeNumber, String ingredientName)  {
		
		RecipeIngredient newRecipeIngredient = new RecipeIngredient(recipeNumber, ingredientName);
		sessionDB.save(newRecipeIngredient);
		return newRecipeIngredient;
	}
	// w miejscu wywołania trzeba bedzie sprawdzić, czy owner istnieje!
	public void changeRecipeIngredient(RecipeIngredient changedRecipeIngredient, int recipeNumber, String ingredientName) {
	
		changedRecipeIngredient.setRecipeNumber(recipeNumber);
		changedRecipeIngredient.setIngredientName(ingredientName);
		
		sessionDB.update(changedRecipeIngredient);
		sessionDB.getTransaction().commit();
	}

	public void deleteIngredient(RecipeIngredient deletedRecipeIngredient) {

		sessionDB.delete(deletedRecipeIngredient);
		sessionDB.getTransaction().commit();
	}

}

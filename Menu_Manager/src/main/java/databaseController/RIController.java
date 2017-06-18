package databaseController;

import org.hibernate.Session;

import databaseManager.Recipe;
import databaseManager.RecipeIngredient;



public class RIController {
	Session sessionDB;
	public RIController(Session sessionDB) {
		this.sessionDB = sessionDB;
		
	}
	public RecipeIngredient addRecipeIngredient(String recipeName, String ingredientName)  {
		
		RecipeIngredient newRecipeIngredient = new RecipeIngredient(recipeName, ingredientName);
		sessionDB.save(newRecipeIngredient);
		return newRecipeIngredient;
	}
	// w miejscu wywołania trzeba bedzie sprawdzić, czy owner istnieje!
	public RecipeIngredient changeRecipeIngredient(RecipeIngredient changedRecipeIngredient, String recipeName, String ingredientName) {
	
		changedRecipeIngredient.setRecipeName(recipeName);
		changedRecipeIngredient.setIngredientName(ingredientName);
		
		sessionDB.update(changedRecipeIngredient);
		sessionDB.getTransaction().commit();
		return changedRecipeIngredient;
	}
	public RecipeIngredient getRI(int id) {
		RecipeIngredient ri=sessionDB.get(RecipeIngredient.class, id);
		return ri;

    }
	public void deleteIngredient(RecipeIngredient deletedRecipeIngredient) {

		sessionDB.delete(deletedRecipeIngredient);
		sessionDB.getTransaction().commit();
	}

}

package databaseController;

import org.hibernate.Session;

import databaseManager.Ingredient;
import databaseManager.User;

public class IngredientController {
	Session sessionDB;

	public IngredientController(Session sessionDB) {
		this.sessionDB = sessionDB;
		
	}

	public Ingredient addIngredient(String ingredientName, boolean lactose, boolean gluten, int calories,
			boolean meat) {
		Ingredient newIngredient = new Ingredient(ingredientName, lactose, gluten, calories, meat);
		sessionDB.save(newIngredient);
		return newIngredient;
	}

	public void changeIngredient(Ingredient changedIngredient,  boolean lactose, boolean gluten,
			int calories, boolean meat) {
		changedIngredient.setCalories(calories);
		changedIngredient.setGluten(gluten);
		changedIngredient.setLactose(lactose);
		changedIngredient.setMeat(meat);
		sessionDB.update(changedIngredient);
		sessionDB.getTransaction().commit();
	}

	public void deleteIngredient(Ingredient deletedIngredient) {

		sessionDB.delete( deletedIngredient);
		sessionDB.getTransaction().commit();
	}

}

package databaseController;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import databaseManager.Ingredient;
import databaseManager.Recipe;
import databaseManager.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class IngredientController {
	Session sessionDB;

	public Ingredient addIngredient(String ingredientName, boolean lactose, boolean gluten, int calories,
			boolean meat) {
		Ingredient newIngredient = new Ingredient(ingredientName, lactose, gluten, calories, meat);
		sessionDB.save(newIngredient);
		sessionDB.getTransaction().commit();
		return newIngredient;
	}

	public Ingredient changeIngredient(Ingredient changedIngredient, boolean lactose, boolean gluten, int calories,
			boolean meat) {
		changedIngredient.setCalories(calories);
		changedIngredient.setGluten(gluten);
		changedIngredient.setLactose(lactose);
		changedIngredient.setMeat(meat);
		sessionDB.update(changedIngredient);
		sessionDB.getTransaction().commit();
		return changedIngredient;
	}

	public List<Ingredient> getAllIngredients() {
		List<Ingredient> allIngredients = sessionDB.createQuery("from Ingredient").list();
		return allIngredients;
	}

	public Ingredient getIngredient(String ingredientName) {
		Ingredient ingredient = sessionDB.get(Ingredient.class, ingredientName);
		return ingredient;

	}

	public void deleteIngredient(Ingredient deletedIngredient) {
		sessionDB.delete(deletedIngredient);
		sessionDB.getTransaction().commit();

	}

}

package databaseController;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import databaseManager.Ingredient;
import databaseManager.Recipe;
import databaseManager.RecipeIngredient;

public class RIController {
	Session sessionDB;
	
	public RIController(Session sessionDB) {
		this.sessionDB = sessionDB;
	}
	
	public RecipeIngredient addRI(Recipe recipe, Ingredient ingredient, int amount)
	{
		RecipeIngredient newRI= new RecipeIngredient(recipe, ingredient, amount);
		sessionDB.save(newRI);
		
		return newRI;
	}

	public RecipeIngredient changeAmount(RecipeIngredient ri, int amount)
	{
		ri.setAmount(amount);
		sessionDB.update( ri);
		sessionDB.getTransaction().commit();
		return ri;
	}
	
	public void deleteRI(RecipeIngredient deleted) {
		
		sessionDB.delete( deleted);
		
	}
	
	public RecipeIngredient getRI(int id)
	{
		RecipeIngredient ri= sessionDB.get(RecipeIngredient.class, id);
		//sessionDB.getTransaction().commit();
		return ri;
	}
	
	public List<RecipeIngredient> getAllRecipesIngredients() {
		Query<RecipeIngredient> query = sessionDB.createQuery("FROM RecipeIngredient ");
		//sessionDB.getTransaction().commit();
		
		 List<RecipeIngredient> allRecipesIngredients= query.list();
		return allRecipesIngredients;
	}
	
	public List<RecipeIngredient> getRecipesIngredientsByRecipe(String nazwa) {
		
		Query<RecipeIngredient> query = sessionDB.createQuery("FROM RecipeIngredient WHERE recipe.recipeName ='"+ nazwa+"'");
		
		List<RecipeIngredient> allRecipesIngredients= query.list();
		return allRecipesIngredients;
	}
		
	
}

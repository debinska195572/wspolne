package databaseController;

import java.util.List;
import java.util.Set;


import org.hibernate.Session;
import org.hibernate.query.Query;

import databaseManager.Ingredient;
import databaseManager.Recipe;
import databaseManager.RecipeIngredient;
import databaseManager.User;

public class RecipeController {
	Session sessionDB;

	public RecipeController(Session sessionDB) {
		this.sessionDB = sessionDB;
		
	}
	// w miejscu wywołania trzeba bedzie sprawdzić, czy owner istnieje!
	public Recipe addRecipe(String recipeName, String recipeType, User owner, String content)  throws DishTypeException{
		if(!recipeType.equals("SNIADANIE") && !recipeType.equals("KOLACJA") &&
				!recipeType.equals("OBIAD") && !recipeType.equals("DESER") && !recipeType.equals("PRZEKASKA") ){
			throw new DishTypeException(recipeType);
		}
		Recipe newRecipe = new Recipe(recipeName, recipeType, owner, content);
		sessionDB.save(newRecipe);
		sessionDB.getTransaction().commit();
		return newRecipe;
	}
	// zakładamy że nie da się zmienić właściciela
	public Recipe changeRecipe(Recipe changedRecipe, String recipeName, String recipeType,  String content) throws DishTypeException{
		if(!recipeType.equals("SNIADANIE") && !recipeType.equals("KOLACJA") &&
				!recipeType.equals("OBIAD") && !recipeType.equals("DESER") && !recipeType.equals("PRZEKASKA") ){
			throw new DishTypeException(recipeType);
		}
		changedRecipe.setRecipeName(recipeName);
		changedRecipe.setRecipeType(recipeType);
		changedRecipe.setContent(content);
		sessionDB.update( changedRecipe);
		sessionDB.getTransaction().commit();
		return changedRecipe;
	}
	public List<Recipe> getAllRecipes() {
		Query<Recipe> query = sessionDB.createQuery("FROM Recipe ");
	
		
		 List<Recipe> allRecipes= query.list();
		return allRecipes;
	}
	
	
	public Recipe addIngredientsToRecipe(Recipe changedRecipe, Set<RecipeIngredient> usedIngredients) {
		
		changedRecipe.setRecipesIngredients(usedIngredients);
		sessionDB.update( changedRecipe);
		sessionDB.getTransaction().commit();
		return changedRecipe;
	}
	
public Recipe addIngredientToRecipe(Recipe changedRecipe, RecipeIngredient usedIngredient) {
		
		changedRecipe.addRecipeIngredient(usedIngredient);
		sessionDB.update( changedRecipe);
		sessionDB.getTransaction().commit();
		return changedRecipe;
	}

	public Recipe removeIngredientFromRecipe(Recipe changedRecipe, RecipeIngredient deleted) {
	
		changedRecipe.removeRecipeIngredient(deleted);
		sessionDB.update( changedRecipe);
		sessionDB.getTransaction().commit();
		return changedRecipe;
	}
	
	public Set<RecipeIngredient> getIngredientsFromRecipe(Recipe choosenRecipe) {
		
		
		return choosenRecipe.getRecipesIngredients();
	}
	
	public Recipe getRecipe(String recipeName) {
		Recipe recipe=sessionDB.get(Recipe.class, recipeName);
	
		return recipe;

    }
	
	
	
	public void deleteRecipe(Recipe deletedRecipe) {

		sessionDB.delete( deletedRecipe);
		sessionDB.getTransaction().commit();
		
	}
}

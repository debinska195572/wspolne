package databaseController;

import org.hibernate.Session;


import databaseManager.Recipe;
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

	public Recipe getRecipe(String recipeName) {
		Recipe recipe=sessionDB.get(Recipe.class, recipeName);
		return recipe;

    }
	
	
	
	public void deleteIngredient(Recipe deletedRecipe) {

		sessionDB.delete( deletedRecipe);
		sessionDB.getTransaction().commit();
	}
}

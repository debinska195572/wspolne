package databaseController;

import java.util.Set;

import org.hibernate.Session;

import databaseManager.Ingredient;
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

	public Recipe addIngredient(Recipe changedRecipe, Set<Ingredient> all, Ingredient added) {
		all.add(added);
		changedRecipe.setIngredients(all);
		sessionDB.update( changedRecipe);
		sessionDB.getTransaction().commit();
		return changedRecipe;
	}
	
	public Recipe removeIngredient(Recipe changedRecipe, Set<Ingredient> all, Ingredient deleted) {
		all.remove(deleted);
		changedRecipe.setIngredients(all);
		sessionDB.update( changedRecipe);
		sessionDB.getTransaction().commit();
		return changedRecipe;
	}
	
	public Set<Ingredient> getIngredientsFromRecipe(Recipe choosenRecipe) {
		
		
		return choosenRecipe.getIngredients();
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

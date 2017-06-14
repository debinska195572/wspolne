package databaseController;

import org.hibernate.Session;


import databaseManager.Recipe;
import lombok.AllArgsConstructor;

@AllArgsConstructor

public class RecipeController {
	Session sessionDB;

/*	public RecipeController(Session sessionDB) {
		this.sessionDB = sessionDB;
		
	}*/
	
	// w miejscu wywołania trzeba bedzie sprawdzić, czy owner istnieje!
	public Recipe addRecipe(String dishName, String dishType, String owner, String content)  throws DishTypeException{
		if(!dishType.equals("SNIADANIE") && !dishType.equals("KOLACJA") &&
				!dishType.equals("OBIAD") && !dishType.equals("DESER") && !dishType.equals("PRZEKASKA") ){
			throw new DishTypeException(dishType);
		}
		Recipe newRecipe = new Recipe(dishName, dishType, owner, content);
		sessionDB.save(newRecipe);
		return newRecipe;
	}
	// w miejscu wywołania trzeba bedzie sprawdzić, czy owner istnieje!
	public void changeRecipe(Recipe changedRecipe, String dishName, String dishType, String owner, String content) throws DishTypeException{
		if(!dishType.equals("SNIADANIE") && !dishType.equals("KOLACJA") &&
				!dishType.equals("OBIAD") && !dishType.equals("DESER") && !dishType.equals("PRZEKASKA") ){
			throw new DishTypeException(dishType);
		}
		changedRecipe.setDishName(dishName);
		changedRecipe.setDishType(dishType);
		changedRecipe.setOwner(owner);
		changedRecipe.setContent(content);
		sessionDB.update( changedRecipe);
		sessionDB.getTransaction().commit();
	}

	public void deleteIngredient(Recipe deletedRecipe) {

		sessionDB.delete( deletedRecipe);
		sessionDB.getTransaction().commit();
	}
}

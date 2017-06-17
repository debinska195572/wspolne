package applicationStructure;

import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.hibernate.Session;
import org.hibernate.mapping.List;

import databaseController.AccountController;
import databaseController.DietException;
import databaseController.DishTypeException;
import databaseController.IngredientController;

import databaseController.RecipeController;
import databaseManager.HibernateUtil;
import databaseManager.Ingredient;
import databaseManager.Recipe;
import databaseManager.User;


public class Main {

	public static void main(String[] args) {
		
		
		/*
		 Session sessionDB = HibernateUtil.getSessionFactory().openSession();
		 sessionDB.beginTransaction();
		AccountController ac= new AccountController(sessionDB);
		RecipeController rc = new RecipeController(sessionDB);
		IngredientController ic = new IngredientController(sessionDB);
		*/
	/*	
		try {
			User u=ac.getUser("test");
			 Recipe r=rc.addRecipe("sałątka", "OBIAD", u, "bla");
		} catch (DishTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Ingredient i = ic.addIngredient("sól", false, false, 10, false);
		java.util.List<Ingredient> listall=ic.getAllIngredients();
		
		
		  System.out.print(listall.size());
	*/
		/*
		User u=null;
		try {
			 u = ac.createSpecificUser("test1", "test", 17, 157, 67, true, true, "NORMALNA", "M");
		} catch (DietException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Recipe r =rc.addRecipe("jajecznica", "OBIAD", u, "blabla");
		} catch (DishTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		/*
		Set<Ingredient> ingredientsUsedToCake= new HashSet<Ingredient>(); 
		
		
		//Dałam też możliwość dopisywania przepisów do składników-nie wiem czy się to przyda
		Set<Recipe> recipesContainsEggs= new HashSet<Recipe>();
		User u=ac.getUser("test");
		Recipe cake=null;
		Recipe omlet=null;
		try {
			 cake =rc.addRecipe("cake", "DESER", u, "blabla");
		} catch (DishTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			 omlet =rc.addRecipe("omlet", "KOLACJA", u, "blabla");
		} catch (DishTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Ingredient egg= ic.addIngredient("jajko", true, true, 300, false);
		Ingredient sugar = ic.addIngredient("cukier", false, false, 5, false);
		
		ingredientsUsedToCake.add(egg);
		ingredientsUsedToCake.add(sugar);
		
		recipesContainsEggs.add(omlet);
		recipesContainsEggs.add(cake);
		
		cake.setIngredients(ingredientsUsedToCake);
		egg.setRecipes(recipesContainsEggs);
		*/
		
		//OpenWindow openWindow = new OpenWindow();
		//openWindow.setVisible(true);
		
		//Bawcie sie 
	
		
	
	
/*		
		

		try {
			User user2=ac.createSpecificUser("Anna", "password", 15, 159, 180, true, true, "WEGETARIANSKA");
		} catch (DietException e) {
			
			e.printStackTrace();
		}
		
		Recipe recipe1 = null;
		try {
			recipe1 = rc.addRecipe("Jajecznica", "SNIADANIE", user1.getLogin(), "Rozbij jajka i je usmaż");
		} catch (DishTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Ingredient jajko = ic.addIngredient("jajko", false, false, 10, false);
		
		RecipeIngredient jajkoJajecznica = ric.addRecipeIngredient(recipe1.getRecipeNumber(), jajko.getIngredientName());
*/		
		

	}
}

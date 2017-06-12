package databaseManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.hibernate.Session;

import applicationStructure.OpenWindow;
import databaseController.AccountController;
import databaseController.DietException;
import databaseController.DishTypeException;
import databaseController.IngredientController;
import databaseController.RIController;
import databaseController.RecipeController;


public class Main {

	public static void main(String[] args) {
		
		Session sessionDB = HibernateUtil.getSessionFactory().openSession();
		sessionDB.beginTransaction();
		AccountController ac = new AccountController(sessionDB);
		RecipeController rc = new RecipeController(sessionDB);
		IngredientController ic = new IngredientController(sessionDB);
		RIController ric = new RIController(sessionDB);
		
		OpenWindow mainWindow = new OpenWindow();
		mainWindow.setVisible(true);
		
		//Bawcie sie 
		
/*		
		User user1=ac.createUser("admin3", "password");
		
		ac.deleteUser(user1);
	

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
		sessionDB.close();

	}
}

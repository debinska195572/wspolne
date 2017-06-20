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
import databaseController.RIController;
import databaseController.RecipeController;
import databaseManager.HibernateUtil;
import databaseManager.Ingredient;
import databaseManager.Recipe;
import databaseManager.RecipeIngredient;
import databaseManager.User;


public class Main {

	public static void main(String[] args) {
		 Session sessionDB = HibernateUtil.getSessionFactory().openSession();
sessionDB.beginTransaction();
		
		
		/*
		RIController ric = new RIController(sessionDB);
		RecipeController rc = new RecipeController(sessionDB);
		java.util.List<RecipeIngredient> l= ric.getRecipesIngredientsByRecipe("pr");
		
		for(int i=0; i<l.size(); i++)
			ric.deleteRI(l.get(i));
		
		Recipe r= rc.getRecipe("Przepis1");
		rc.deleteRecipe(r);
		
/*		
		
		
		IngredientController ic = new IngredientController(sessionDB);
		RIController ric = new RIController(sessionDB);
		

		
		
		/////////////////////////
//		User u=ac.getUser("user1");
//		Recipe r =rc.getRecipe("pizza");
//		
//		Ingredient i = ic.getIngredient("papryka");
//		
//		Ingredient i2 = ic.getIngredient("sól");
//		
//		
//		RecipeIngredient ri= ric.addRI(r, i, 2); //tworzenie osobno obiektu RecipeIngredient
//		RecipeIngredient ri2= ric.addRI(r, i2, 4);
//		Set<RecipeIngredient> set= new HashSet<RecipeIngredient>(); 
//		set.add(ri);
//		set.add(ri2);
//		r=rc.addIngredientToRecipe(r, ri); //dodawanie pojedyńczego 
//		r=rc.addIngredientsToRecipe(r, set); // dodawanie setu obiektów
//		Set<RecipeIngredient> set2=rc.getIngredientsFromRecipe(r);// -zwraca set RecipeIngredient -składników danego przepisu
//		
//		rc.removeIngredientFromRecipe(r, ri); //usuwanie najpierw z setu w Recipe
//		ric.deleteRI(ri); //usuwanie z tabeli recipeIngredient

	
	Recipe r =rc.getRecipe("przepis1");
		
	//	Ingredient i = ic.getIngredient("Jajko");
		sessionDB.getTransaction().begin();
		
	
		
	//	RecipeIngredient ri= ric.addRI(r, i, 5); //tworzenie osobno obiektu RecipeIngredient
	//	RecipeIngredient ri2= new RecipeIngredient(r, i, 5);
	//	sessionDB.save(ri2);
	//	System.out.print("moj"+ri.getIngredient().getIngredientName());
		java.util.List<RecipeIngredient> l2= ric.getRecipesIngredientsByRecipe("przepis1");
		
		java.util.List<RecipeIngredient> l= ric.getAllRecipesIngredients();
		for(int j=0; j<l2.size(); j++)
		System.out.print("Przepis:"+l2.get(j).getRecipe().getRecipeName()+"składnik "+ l2.get(j).getIngredient().getIngredientName());

		
	//	rc.deleteRecipe(r);
l2.get(2).setIngredient(null);
l2.get(2).setRecipe(null);
		ric.deleteRI(l2.get(2));
		
		java.util.List<RecipeIngredient> l3= ric.getRecipesIngredientsByRecipe("przepis1");
		
		for(int j=0; j<l2.size(); j++)
			System.out.print("Przepis:"+l2.get(j).getRecipe().getRecipeName()+"składnik "+ l2.get(j).getIngredient().getIngredientName());
			
		

		
		////////////////////////
		
		
		
		
		
		//System.out.println(ric.getAllRecipesIngredients().size());
//		User u=ac.getUser("user1");
		//Recipe r =rc.addRecipe(recipeName, recipeType, owner, content)
//		
//		Ingredient i = ic.getIngredient("papryka");
//		
//		
//		
//		
//		RecipeIngredient ri= ric.addRI(r, i, 2); //tworzenie osobno obiektu RecipeIngredient
//		r.addRecipeIngredient(ri); //osobno dodawanie tego obiektu do przepisu - do setu, żeby potem można było dostać wszystkie składniki przepisu przez:
//		//r.getRecipesIngredients() -zwraca set RecipeIngredient -składników danego przepisu
//		
//		r.removeRecipeIngredient(ri); //chyba najpierw trzeba usunąć stąd tak na logike
//		ric.deleteRI(ri);
		

		//r.addRecipeIngredient(ri); //osobno dodawanie tego obiektu do przepisu - do setu, żeby potem można było dostać wszystkie składniki przepisu przez:
		//r.getRecipesIngredients() -zwraca set RecipeIngredient -składników danego przepisu
		
		//r.removeRecipeIngredient(ri); //chyba najpierw trzeba usunąć stąd tak na logike
		//[ric.deleteRI(ri);
	*/	

		
		OpenWindow openWindow = new OpenWindow();
		openWindow.setVisible(true);
		
	/*
	
		try {
			User u=ac.getUser("user1");
			 Recipe r=rc.addRecipe("mrożonka", "OBIAD", u, "bla");
		} catch (DishTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Ingredient i = ic.addIngredient("pieprz", false, false, 10, false);
		//java.util.List<Ingredient> listall=ic.getAllIngredients();
		
		
		//  System.out.print(listall.size());
	
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

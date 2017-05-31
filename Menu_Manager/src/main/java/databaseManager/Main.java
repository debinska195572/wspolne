package databaseManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.hibernate.Session;


public class Main {

	public static void main(String[] args) {

		Session sessionDB = HibernateUtil.getSessionFactory().openSession();
		sessionDB.beginTransaction();
		
	

		Ingredient i = new Ingredient();
		i.setIngredient_Name("Pomidor");
		sessionDB.delete(i);
		sessionDB.save(i);
		
		User admin = new User();
		admin.setLogin("admin");
		admin.setPassword("12345"); // potem sie zahaszuje
		sessionDB.delete(admin);
		sessionDB.save(admin);
		
		Recipe r = new Recipe();
		r.setRecipeNumber(5);
		r.setNameOfDish("Jajecznica");
		r.setOwner("admin");
		sessionDB.delete(r);

		sessionDB.save(r);
		
		
		
		RecipeIngredient ri = new RecipeIngredient();
		ri.setId_RecipeIngredient(1);
		ri.setIngredient_name("Kalafior");
		ri.setRecipe_number(5);

		
		sessionDB.getTransaction().commit();
		sessionDB.close();

	}
}

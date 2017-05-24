package databaseManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
		
		
		Recipe r = new Recipe();
		r.setRecipeNumber(5);
		r.setNameOfDish("Jajecznica");
		r.setOwner("admin");
		sessionDB.delete(r);
		sessionDB.save(r);
		
		sessionDB.save(admin);
		
		RecipeIngredient ri = new RecipeIngredient();
		ri.setId_RecipeIngredient(1);
		ri.setIngredient_name("Kalafior");
		ri.setRecipe_number(5);

		
		sessionDB.getTransaction().commit();
		sessionDB.close();

	}
}

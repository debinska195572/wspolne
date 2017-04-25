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
    	
  
         Session sessionForRecipes = HibernateUtil.getSessionFactory().openSession();
         sessionForRecipes.beginTransaction();
         
   /*     Users admin = new Users();
         admin.setLogin("admin");
         admin.setPassword("12345"); //potem sie zahaszuje
*/       
    
//         Recipes r= new Recipes();
//         r.setRecipeNumber(5);
//         r.setNameOfDish("Jajecznica");
//         r.setOwner("Asia");
//         sessionForRecipes.save(r);
 //        sessionForRecipes.save(admin);
        
         sessionForRecipes.getTransaction().commit();
         sessionForRecipes.close();
         
  
        
   }
}

package databaseManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.List;

import org.hibernate.Session;

public class Main {
    
	
    
     public static void main(String[] args) {
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
  
        Users admin = new Users();
         admin.setLogin("admin");
         admin.setPassword("admin"); //potem sie zahaszuje
         
         Recipes r= new Recipes();
         r.setRecipeNumber(1);
        // session.save(r);
        //session.save(admin);
        
         session.getTransaction().commit();
  
         HibernateUtil.getSessionFactory().close();
   }
}

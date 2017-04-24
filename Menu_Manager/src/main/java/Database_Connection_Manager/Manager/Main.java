package Database_Connection_Manager.Manager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;

import org.hibernate.Session;

public class Main {
    
    
     public static void main(String[] args) {
    	Session session = Connection_Manager.getSessionFactory().getCurrentSession();
         session.beginTransaction();
  
        
         session.getTransaction().commit();
  
         Connection_Manager.getSessionFactory().close();
   }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseManager;



import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

//	private static SessionFactory sessionFactory = new Configuration().configure() // configures
//																					// settings
//																					// from
//																					// hibernate.cfg.xml
//			.buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		 try {
	            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
	                    .configure("hibernate.cfg.xml").build();
	            Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
	            return metadata.getSessionFactoryBuilder().build();

	        } catch (HibernateException he) {
	            System.out.println("Session Factory creation failure");
	            throw he;
	        }
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
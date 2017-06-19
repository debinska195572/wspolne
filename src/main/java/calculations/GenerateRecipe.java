/**
 * 
 */
package calculations;




import java.util.List;

import javax.swing.JList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;


import databaseManager.*;

/**
 * @author Marcin
 *
 */
public final class GenerateRecipe {
		
	private User user;
	private int forSwitch;
	private Session session;
	private Transaction tx;
	private static List<Recipe> recipes;
	
	
	public static /*JList<Recipe>*/ void  getLunch(User loggedUser, Session sessionDB)
	{
		//List<Recipe> list = (List) sessionDB.createCriteria(Recipe.class).list();
		

		// Create CriteriaBuilder
		//CriteriaBuilder builder = sessionDB.getCriteriaBuilder();
		
		//Criteria builder= (Criteria) sessionDB.createCriteria(Recipe.class).list();

		// Create CriteriaQuery
		//CriteriaQuery<Recipe> criteria = builder.createQuery(Recipe.class);
		
		recipes = sessionDB.createQuery("FROM Recipe").list();
		System.out.println("Ilość: " + recipes.size());
		
		//return null;
		
	}
	
//	public GenerateRecipe(User user)
//	{
//		this.user = user;
//	
//	}
//	
//	public GenerateRecipe(){
//		
//		
//		
//		
//		session = HibernateUtil.getSessionFactory().openSession();
//		tx = null;
//		try {
//		   tx = session.beginTransaction();
//		   
//		   tryToGetGoodRecipe();
//		   
//		   tx.commit();
//		}
//		catch (Exception e) {
//		   if (tx!=null) tx.rollback();
//		   e.printStackTrace(); 
//		}finally {
//		   session.close();
//		}
//		
//		
//	}
//
//	private void tryToGetGoodRecipe() {
//		
//		
//		
//		
//	}
	
	
}

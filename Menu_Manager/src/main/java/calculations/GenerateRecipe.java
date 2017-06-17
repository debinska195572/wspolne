/**
 * 
 */
package calculations;



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
	
	public GenerateRecipe(User user)
	{
		this.user = user;
	
	}
	
	public GenerateRecipe(){
		
		
		
		
		session = HibernateUtil.getSessionFactory().openSession();
		tx = null;
		try {
		   tx = session.beginTransaction();
		   
		   tryToGetGoodRecipe();
		   
		   tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
		
		
	}

	private void tryToGetGoodRecipe() {
		
		
		
		
	}
	
	
}

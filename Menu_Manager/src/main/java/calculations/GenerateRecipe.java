/**
 * 
 */
package calculations;

import org.hibernate.Session;

import org.hibernate.Transaction;

import databaseManager.*;
import lombok.RequiredArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.AccessLevel;

/**
 * @author Marcin
 *
 */
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public final class GenerateRecipe {

	@NonNull private User user;
	private int forSwitch;
	private Session session;
	private Transaction tx;

	/*
	 * public GenerateRecipe(User user) { this.user = user;
	 * 
	 * }
	 */

	public GenerateRecipe() {

		session = HibernateUtil.getSessionFactory().openSession();
		tx = null;
		try {
			tx = session.beginTransaction();

			tryToGetGoodRecipe();

			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	private void tryToGetGoodRecipe() {

	}

}

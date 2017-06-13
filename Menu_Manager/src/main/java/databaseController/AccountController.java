package databaseController;

import org.hibernate.Session;


import databaseManager.User;

public class AccountController {
	Session sessionDB;
	public AccountController(Session sessionDB) {
		this.sessionDB=sessionDB;
		
	}

	
	public User createUser(String login, String password ) 
	{
		User newUser = new User(login, password);
		sessionDB.save(newUser);
		sessionDB.getTransaction().commit();
		return newUser;
	}
	
	public User createSpecificUser(String login, String password, int age, int height, int weight, boolean lactoseTolerance,   boolean glutenTolerance, String diet  ) throws DietException
	{
		if(!diet.equals("NORMALNA") && !diet.equals("WEGETARIANSKA")){
			throw new DietException(diet);
		}
		User newUser = new User(login, password, age,  height, weight, lactoseTolerance,glutenTolerance,  diet);
		
		sessionDB.save(newUser);
		sessionDB.getTransaction().commit();
		return newUser;
	}
	
	
	public void updateUser(User changedUser,String password, int age, String diet, int height, int weight, boolean glutenTolerance, boolean lactoseTolerance  ) throws DietException
	{
	
		if(!diet.equals("NORMALNA") && !diet.equals("WEGETARIANSKA")){
			throw new DietException(diet);
		}
		
		//changedUser.setPassword(password); 
		changedUser.setAge(age);
		changedUser.setDiet(diet);
		changedUser.setHeight(height);
		changedUser.setWeight(weight);
		changedUser.setGlutenTolerance(glutenTolerance);
		changedUser.setLactoseTolerance(lactoseTolerance);
		sessionDB.update(changedUser);
		sessionDB.getTransaction().commit();
	}
	
	public User getUser(String userName) {
		User user=sessionDB.get(User.class, userName);
		return user;
		 
		
 
    }
	
	public void changePssword(User changedUser,  String password  )
	{
		changedUser.setPassword(password); 
		
		sessionDB.update( changedUser);
		sessionDB.getTransaction().commit();
	}
	
	public void deleteUser(User deletedUser)
	{
		sessionDB.delete( deletedUser);
		sessionDB.getTransaction().commit();
	}
}

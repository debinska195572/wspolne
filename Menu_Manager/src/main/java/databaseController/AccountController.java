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
	
	public User createSpecificUser(String login, String password, int age, int height, int weight, boolean lactoseTolerance,   boolean glutenTolerance, String diet, String gender  ) throws DietException
	{
		if(!diet.equals("NORMALNA") && !diet.equals("WEGETARIAŃSKA")){
			throw new DietException(diet);
		}
		User newUser = new User(login, password, age,  height, weight, lactoseTolerance,glutenTolerance,  diet, gender);
		
		sessionDB.save(newUser);
		sessionDB.getTransaction().commit();
		return newUser;
	}
	
	
	public User updateUser(User changedUser,String password, int age, String diet, int height, int weight, boolean glutenTolerance, boolean lactoseTolerance , String gender ) throws DietException
	{
	
		if(!diet.equals("NORMALNA") && !diet.equals("WEGETARIAŃSKA")){
			throw new DietException(diet);
		}
		
		//changedUser.setPassword(password); 
		changedUser.setAge(age);
		changedUser.setDiet(diet);
		changedUser.setHeight(height);
		changedUser.setWeight(weight);
		changedUser.setGlutenTolerance(glutenTolerance);
		changedUser.setLactoseTolerance(lactoseTolerance);
		changedUser.setGender(gender);
		sessionDB.update(changedUser);
		sessionDB.getTransaction().commit();
		return changedUser;
	}
	
	public User getUser(String userName) {
		User user=sessionDB.get(User.class, userName);
		return user;

    }
	
	public User changePssword(User changedUser,  String password  )
	{
		changedUser.setPassword(password); 
		
		sessionDB.update( changedUser);
		sessionDB.getTransaction().commit();
		
		return changedUser;
	}
	
	public void deleteUser(User deletedUser)
	{
		sessionDB.delete( deletedUser);
		sessionDB.getTransaction().commit();
	}
}

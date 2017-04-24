package Database_Connection_Manager.Manager;

public class Users {

	  private String login;
	    private String password;
	    private int age;	
	    private int height;
	    private int weight;
	    private boolean lactoseTolerance;
	    private boolean intoleranceGluten;
	    private String diet;
	    
	    
	
	public Users() {

		 
	
		 
		  
		}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public int getHeight() {
		return height;
	}



	public void setHeight(int height) {
		this.height = height;
	}



	public int getWeight() {
		return weight;
	}



	public void setWeight(int weight) {
		this.weight = weight;
	}



	public boolean isLactoseTolerance() {
		return lactoseTolerance;
	}



	public void setLactoseTolerance(boolean lactoseTolerance) {
		this.lactoseTolerance = lactoseTolerance;
	}



	public boolean isIntoleranceGluten() {
		return intoleranceGluten;
	}



	public void setIntoleranceGluten(boolean intoleranceGluten) {
		this.intoleranceGluten = intoleranceGluten;
	}



	public String getDiet() {
		return diet;
	}



	public void setDiet(String diet) {
		this.diet = diet;
	}

}

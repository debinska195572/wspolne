package databaseManager;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@Column(name = "Login")
	private String login;
	@Column(name = "Password")
	private String password;
	@Column(name = "Age")
	private int age;
	@Column(name = "Height")
	private int height;
	@Column(name = "Weight")
	private int weight;
	@Column(name = "Lactose_tolerance")
	private boolean lactoseTolerance;
	@Column(name = "Gluten_tolerance")
	private boolean glutenTolerance;
	@Column(name = "Diet")
	private String diet;
	@Column(name = "Gender")
	private String gender;
	
	@OneToMany(mappedBy="owner")
	private Set<Recipe> recipes;
	
	public User() {

	}

	public User(String login, String password) {
this.login=login;
this.password= password;
	}
	
	
	
	public User(String login, String password, int age, int height, int weight, boolean lactoseTolerance,
			boolean glutenTolerance, String diet, String gender) {
		super();
		this.login = login;
		this.password = password;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.lactoseTolerance = lactoseTolerance;
		this.glutenTolerance = glutenTolerance;
		this.diet = diet;
		this.gender= gender;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	

	public boolean isGlutenTolerance() {
		return glutenTolerance;
	}

	public void setGlutenTolerance(boolean glutenTolerance) {
		this.glutenTolerance = glutenTolerance;
	}

	public String getDiet() {
		return diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}

	public Set<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(Set<Recipe> recipes) {
		this.recipes = recipes;
	}

}

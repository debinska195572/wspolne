/*
 * 
 */
package databaseManager;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Users")

@Getter
@Setter



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
	@Column(name = "Intolerance_to_gluten")
	private boolean intoleranceGluten;
	@Column(name = "Diet")
	private String diet;

	// lombok nie tworzy konstruktorow z wybranymi polami, chyba, że by były final lub non-null i wtedy @RequiredArgsConstructor
		public User(String login, String password) {
			this.login = login;
			this.password = password;
		}

	public User(String login, String password, int age, int height, int weight, boolean lactoseTolerance,
			boolean intoleranceGluten, String diet) {
		super();
		this.login = login;
		this.password = password;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.lactoseTolerance = lactoseTolerance;
		this.intoleranceGluten = intoleranceGluten;
		this.diet = diet;
	}
	
	

	/*public User() {

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
	}*/

}

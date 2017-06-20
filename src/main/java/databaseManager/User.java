package databaseManager;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Users")
@NoArgsConstructor
@Setter
@Getter
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
	@OneToMany(mappedBy = "owner")
	private Set<Recipe> recipes;

	public User(String login, String password) {
		this.login = login;
		this.password = password;
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
		this.gender = gender;
	}
}

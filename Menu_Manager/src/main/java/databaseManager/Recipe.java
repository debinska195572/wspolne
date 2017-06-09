package databaseManager;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Recipes")
public class Recipe {

	@Id
	@Column(name = "ID_Recipe")
	private int recipeNumber;

	@Column(name = "Dish_Name")
	private String dishName;
	@Column(name = "Dish_Type")
	private String dishType;
	@Column(name = "Owner")
	private String owner;
	@Column(name = "Content")
	private String content;

	public Recipe() {
		// TODO Auto-generated constructor stub
	}

	

	public Recipe( String dishName, String dishType, String owner, String content) {
		super();
		
		this.dishName = dishName;
		this.dishType = dishType;
		this.owner = owner;
		this.content = content;
	}



	public int getRecipeNumber() {
		return recipeNumber;
	}



	public void setRecipeNumber(int recipeNumber) {
		this.recipeNumber = recipeNumber;
	}



	public String getDishName() {
		return dishName;
	}



	public void setDishName(String dishName) {
		this.dishName = dishName;
	}



	public String getDishType() {
		return dishType;
	}



	public void setDishType(String dishType) {
		this.dishType = dishType;
	}



	public String getOwner() {
		return owner;
	}



	public void setOwner(String owner) {
		this.owner = owner;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	
}

package databaseManager;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Recipes")
public class Recipe {

	@Id
	@Column(name = "Recipe_Name")
	private String recipeName;
	@Column(name = "Recipe_Type")
	private String recipeType;
	@Column(name = "Owner")
	private String owner;
	@Column(name = "Content")
	private String content;

	public Recipe() {
		// TODO Auto-generated constructor stub
	}

	

	public Recipe( String recipeName, String recipeType, String owner, String content) {
		super();
		
		this.recipeName = recipeName;
		this.recipeType = recipeType;
		this.owner = owner;
		this.content = content;
	}







	



	public String getRecipeName() {
		return recipeName;
	}



	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}



	public String getRecipeType() {
		return recipeType;
	}



	public void setRecipeType(String recipeType) {
		this.recipeType = recipeType;
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

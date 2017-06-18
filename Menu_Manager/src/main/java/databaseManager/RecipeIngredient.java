package databaseManager;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RecipesIngredients")
public class RecipeIngredient {

	@Id
	@Column(name = "ID_RecipeIngredient")
	private int riNumber;
	@Column(name = "Recipe_Name")
	private String recipeName;
	@Column(name = "Ingredient_Name")
	private String ingredientName;

	public RecipeIngredient() {

	}

	public RecipeIngredient( String recipeName, String ingredientName) {
		super();
		
		this.recipeName = recipeName;
		this.ingredientName = ingredientName;
	}

	public int getRiNumber() {
		return riNumber;
	}

	public void setRiNumber(int riNumber) {
		this.riNumber = riNumber;
	}

	
	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}



}

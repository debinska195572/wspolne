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
@Table(name = "RecipesIngredients")

@Getter
@Setter
 
@NoArgsConstructor

public class RecipeIngredient {

	@Id
	@Column(name = "ID_RecipeIngredient")
	private int riNumber;
	@Column(name = "Recipe_Number")
	private int recipeNumber;
	@Column(name = "Ingredient_Name")
	private String ingredientName;

	public RecipeIngredient(int recipeNumber, String ingredientName) {
		super();

		this.recipeNumber = recipeNumber;
		this.ingredientName = ingredientName;
	}

	/*public RecipeIngredient() {

	}

	public int getRiNumber() {
		return riNumber;
	}

	public void setRiNumber(int riNumber) {
		this.riNumber = riNumber;
	}

	public int getRecipeNumber() {
		return recipeNumber;
	}

	public void setRecipeNumber(int recipeNumber) {
		this.recipeNumber = recipeNumber;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}*/

}

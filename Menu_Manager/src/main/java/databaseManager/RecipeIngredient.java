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
	private int id_RecipeIngredient;
	@Column(name = "Recipe_Number")
	private int recipe_number;
	@Column(name = "Ingredient_Name")
	private String ingredient_name;

	public RecipeIngredient() {

	}

	public int getId_RecipeIngredient() {
		return id_RecipeIngredient;
	}

	public void setId_RecipeIngredient(int id_RecipeIngredient) {
		this.id_RecipeIngredient = id_RecipeIngredient;
	}

	public int getRecipe_number() {
		return recipe_number;
	}

	public void setRecipe_number(int recipe_number) {
		this.recipe_number = recipe_number;
	}

	public String getIngredient_name() {
		return ingredient_name;
	}

	public void setIngredient_name(String ingredient_name) {
		this.ingredient_name = ingredient_name;
	}

}

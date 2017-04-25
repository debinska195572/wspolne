package databaseManager;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RecipesIngredients")
public class RecipesIngredients {

	@Id
	@Column(name = "ID_RecipeIngredient")
	private String id_RecipeIngredient;
	@Column(name = "Recipe_Number")
	private String recipe_number;
	@Column(name = "Ingredient_Name")
	private int ingredient_name;

	public RecipesIngredients() {

	}

	public String getId_RecipeIngredient() {
		return id_RecipeIngredient;
	}

	public void setId_RecipeIngredient(String id_RecipeIngredient) {
		this.id_RecipeIngredient = id_RecipeIngredient;
	}

	public String getRecipe_number() {
		return recipe_number;
	}

	public void setRecipe_number(String recipe_number) {
		this.recipe_number = recipe_number;
	}

	public int getIngredient_name() {
		return ingredient_name;
	}

	public void setIngredient_name(int ingredient_name) {
		this.ingredient_name = ingredient_name;
	}

}

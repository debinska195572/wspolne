package databaseManager;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RecipesIngredients")
public class RecipeIngredient {
	
	private int id;
    private Recipe recipe;
    private Ingredient ingredient;
    private int amount;

	public RecipeIngredient() {
	}
	
	 public RecipeIngredient(Recipe recipe, Ingredient ingredient, int amount) {
			super();
		
			this.recipe = recipe;
			this.ingredient = ingredient;
			this.amount = amount;
		}
	 @Id
	 @GeneratedValue
	 @Column(name = "ID_RecipeIngredient")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	@ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "Recipe_Name")  
	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Ingredient_Name")
	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	 @Column(name = "Amount")
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}

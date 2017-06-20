package databaseManager;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "RecipesIngredients")

@NoArgsConstructor
@Getter
@Setter
public class RecipeIngredient {
	@Id
	@GeneratedValue
	@Column(name = "ID_RecipeIngredient")
	private int id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Recipe_Name")
	private Recipe recipe;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "Ingredient_Name")
	private Ingredient ingredient;
	@Column(name = "Amount")
	private int amount;

	public RecipeIngredient(Recipe recipe, Ingredient ingredient, int amount) {
		super();
		this.recipe = recipe;
		this.ingredient = ingredient;
		this.amount = amount;
	}

}

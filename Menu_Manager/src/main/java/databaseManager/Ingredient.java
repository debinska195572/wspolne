package databaseManager;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Ingredients")

@Getter
@Setter
@NoArgsConstructor
public class Ingredient {
	@Id
	@Column(name = "Ingredient_Name")
	private String ingredientName;
	@Column(name = "Lactose")
	private boolean lactose;
	@Column(name = "Gluten")
	private boolean gluten;
	@Column(name = "Calories")
	private int calories;
	@Column(name = "Meat")
	private boolean meat;
	@OneToMany(mappedBy = "ingredient", fetch = FetchType.LAZY)
	private Set<RecipeIngredient> ri = new HashSet<RecipeIngredient>();

	// powinien zostać, bo super()
	public Ingredient(String ingredientName, boolean lactose, boolean gluten, int calories, boolean meat) {
		super();
		this.ingredientName = ingredientName;
		this.lactose = lactose;
		this.gluten = gluten;
		this.calories = calories;
		this.meat = meat;
	}

	
	public void addRecipeIngredient(RecipeIngredient newRI) {
		this.ri.add(newRI);
	}

}

package databaseManager;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Ingredients")
public class Ingredient {

	
	private String ingredientName;
	private boolean lactose;
	private boolean gluten;
	private int calories;
	private boolean meat;
	
	private Set<RecipeIngredient> ri= new HashSet<RecipeIngredient>();

	public Ingredient() {

	}

	public Ingredient(String ingredientName, boolean lactose, boolean gluten, int calories, boolean meat) {
		super();
		this.ingredientName = ingredientName;
		this.lactose = lactose;
		this.gluten = gluten;
		this.calories = calories;
		this.meat = meat;
	}

	@Id
	@Column(name = "Ingredient_Name")
	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	@Column(name = "Lactose")
	public boolean isLactose() {
		return lactose;
	}

	public void setLactose(boolean lactose) {
		this.lactose = lactose;
	}
	@Column(name = "Gluten")
	public boolean isGluten() {
		return gluten;
	}

	public void setGluten(boolean gluten) {
		this.gluten = gluten;
	}
	@Column(name = "Calories")
	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}
	@Column(name = "Meat")
	public boolean isMeat() {
		return meat;
	}

	public void setMeat(boolean meat) {
		this.meat = meat;
	}

	 @OneToMany(mappedBy = "ingredient")
	 public Set<RecipeIngredient> getRecipesIngredients() {
	        return ri;
	    }
	 
	    public void setRecipesIngredients(Set<RecipeIngredient> newRI) {
	        this.ri = newRI;
	    }
	     
	    public void addRecipeIngredient(RecipeIngredient newRI) {
	        this.ri.add(newRI);
	    }  

}

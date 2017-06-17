package databaseManager;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Ingredients")
public class Ingredient {

	
	private String ingredientName;
	private boolean lactose;
	private boolean gluten;
	private int calories;
	private boolean meat;
	
	private Set<Recipe> recipes=new HashSet<Recipe>();  

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

	 @ManyToMany(cascade=CascadeType.ALL, mappedBy="ingredients")  
	    public Set<Recipe> getRecipes()  
	    {  
	        return recipes;  
	    }  
	    public void setRecipes(Set<Recipe> recipes)  
	    {  
	        this.recipes = recipes;  
	    }  

}

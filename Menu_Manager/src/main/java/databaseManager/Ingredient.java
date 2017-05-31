package databaseManager;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ingredients")
public class Ingredient {

	@Id
	@Column(name = "Ingredient_Name")
	private String ingredient_Name;
	@Column(name = "Lactose")
	private boolean lactose;
	@Column(name = "Gluten")
	private boolean gluten;
	@Column(name = "Calories")
	private int calories;
	@Column(name = "Meat")
	private boolean meat;

	public Ingredient() {

	}

	public String getIngredient_Name() {
		return ingredient_Name;
	}

	public void setIngredient_Name(String ingredient_Name) {
		this.ingredient_Name = ingredient_Name;
	}

	public boolean isLactose() {
		return lactose;
	}

	public void setLactose(boolean lactose) {
		this.lactose = lactose;
	}

	public boolean isGluten() {
		return gluten;
	}

	public void setGluten(boolean gluten) {
		this.gluten = gluten;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public boolean isMeat() {
		return meat;
	}

	public void setMeat(boolean meat) {
		this.meat = meat;
	}

	

}

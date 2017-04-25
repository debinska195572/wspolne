package databaseManager;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ingredients")
public class Ingredients {

	@Id
	@Column(name = "Ingredient_Name")
	private String ingredient_Name;
	@Column(name = "Lactose")
	private String lactose;
	@Column(name = "Gluten")
	private int gluten;
	@Column(name = "Calories")
	private int calories;
	@Column(name = "Meat")
	private int meat;

	public Ingredients() {

	}

	public String getIngredient_Name() {
		return ingredient_Name;
	}

	public void setIngredient_Name(String ingredient_Name) {
		this.ingredient_Name = ingredient_Name;
	}

	public String getLactose() {
		return lactose;
	}

	public void setLactose(String lactose) {
		this.lactose = lactose;
	}

	public int getGluten() {
		return gluten;
	}

	public void setGluten(int gluten) {
		this.gluten = gluten;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getMeat() {
		return meat;
	}

	public void setMeat(int meat) {
		this.meat = meat;
	}

}

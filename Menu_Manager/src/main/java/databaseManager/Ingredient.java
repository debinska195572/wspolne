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



	// bo super() i chyba musi zostać
	public Ingredient(String ingredientName, boolean lactose, boolean gluten, int calories, boolean meat) {
		super();
		this.ingredientName = ingredientName;
		this.lactose = lactose;
		this.gluten = gluten;
		this.calories = calories;
		this.meat = meat;
	}

	
/*	public Ingredient() {

	}
		
	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
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
	}*/

	

}

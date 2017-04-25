package databaseManager;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Recipes")
public class Recipes {

	@Id
    @Column(name = "ID_Recipe")
    private int recipeNumber;

  
	 @Column(name = "Dish_Name") 
	    private String nameOfDish;
	 @Column(name = "Owner")
	    private String owner;
	 @Column(name = "Content")
	    private String content;
	   
	    
	public Recipes() {
		// TODO Auto-generated constructor stub
	}


	


	public int getRecipeNumber() {
		return recipeNumber;
	}


	public void setRecipeNumber(int recipeNumber) {
		this.recipeNumber = recipeNumber;
	}


	public String getNameOfDish() {
		return nameOfDish;
	}


	public void setNameOfDish(String nameOfDish) {
		this.nameOfDish = nameOfDish;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}





	public String getOwner() {
		return owner;
	}





	public void setOwner(String owner) {
		this.owner = owner;
	}

}

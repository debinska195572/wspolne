package databaseManager;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "Recipes")
public class Recipe {

	private String recipeName;
	private String recipeType;
	private User owner;
	private String content;
	private Set<RecipeIngredient> ri= new HashSet<RecipeIngredient>();

	public Recipe() {
		// TODO Auto-generated constructor stub
	}

	

	public Recipe( String recipeName, String recipeType,User user,  String content) {
		super();
		
		this.recipeName = recipeName;
		this.recipeType = recipeType;
		this.owner=user;
		this.content = content;
	}

	@Id
	@Column(name = "Recipe_Name")
	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	
	@Column(name = "Recipe_Type")
	public String getRecipeType() {
		return recipeType;
	}

	public void setRecipeType(String recipeType) {
		this.recipeType = recipeType;
	}

	@ManyToOne
	@JoinColumn(name="Owner")
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Column(name = "Content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	  @OneToMany(mappedBy = "recipe")
	    public Set<RecipeIngredient> getRecipesIngredients() {
	        return ri;
	    }
	 
	    public void setRecipesIngredients(Set<RecipeIngredient> newRI) {
	        this.ri = newRI;
	    }
	     
	    public void addRecipeIngredient(RecipeIngredient newRI) {
	        this.ri.add(newRI);
	    }   
	
	    public void removeRecipeIngredient(RecipeIngredient deletedRI) {
	        this.ri.remove(deletedRI);
	    }   
}

package databaseManager;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Recipes")

@Getter
@Setter
@NoArgsConstructor
public class Recipe {

	@Id
	@Column(name = "Recipe_Name")
	private String recipeName;
	@Column(name = "Recipe_Type")
	private String recipeType;
	@ManyToOne
	@JoinColumn(name = "Owner")
	private User owner;
	@Column(name = "Content")
	private String content;
	@OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY)
	private Set<RecipeIngredient> ri = new HashSet<RecipeIngredient>();

	public Recipe(String recipeName, String recipeType, User user, String content) {
		super();
		this.recipeName = recipeName;
		this.recipeType = recipeType;
		this.owner = user;
		this.content = content;
	}

	public Set<RecipeIngredient> getRecipesIngredients() {
		return ri;
	}

	/*public void setRecipesIngredients(Set<RecipeIngredient> newRI) {
		this.ri = newRI;
	}*/

	public void addRecipeIngredient(RecipeIngredient newRI) {
		this.ri.add(newRI);
	}

	public void removeRecipeIngredient(RecipeIngredient deletedRI) {
		this.ri.remove(deletedRI);
	}
}

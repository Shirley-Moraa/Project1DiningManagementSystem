package com.springboot.springbootproject1dms.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recipes")
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "cost", nullable = false)
	private int cost;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "containsGluten", nullable = false)
	private boolean containsGluten;
	
	@Column(name = "containsPeanuts", nullable = false)
	private boolean containsPeanuts;
	
	@Column(name = "ingredients", nullable = false)
	private List<String> ingredients;

	public Recipe() {
		super();
	}
	public Recipe(int cost, String title, boolean containsGluten, boolean containsPeanuts, List<String> ingredients) {
		super();
		this.cost = cost;
		this.title = title;
		this.containsGluten = containsGluten;
		this.containsPeanuts = containsPeanuts;
		this.ingredients = ingredients;
	}
	
	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	public int getCost() {
		return cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public boolean isContainsGluten() {
		return containsGluten;
	}
	
	public void setContainsGluten(boolean containsGluten) {
		this.containsGluten = containsGluten;
	}
	
	public boolean isContainsPeanuts() {
		return containsPeanuts;
	}
	
	public void setContainsPeanuts(boolean containsPeanuts) {
		this.containsPeanuts = containsPeanuts;
	}
	
	public String toString() {
        return "Recipe [id=" + id + ", cost=" + cost + ", title=" + title + ", containsGluten=" + containsGluten + ", containsPeanuts=" + containsPeanuts + ", ingredients="
 +  ingredients    + "]";
	}
}

package com.springboot.springbootproject1dms.model;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Transient;

@Entity
//@Access(AccessType.PROPERTY)
@Table(name = "recipes")
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	//@Transient 
	@Column(name = "cost", nullable = false)
	private int cost;
	
	//@Transient 
	@Column(name = "title", nullable = false)
	private String title;
	
	//@Transient 
	@Column(name = "containsGluten", nullable = false)
	private boolean containsGluten;
	
	//@Transient
	@Column(name = "containsPeanut", nullable = false)
	private boolean containsPeanut;
	
	//@Transient
	@Column(name = "ingredients", nullable = false)
	private String ingredients;

	public Recipe() {
		
	}
	public Recipe(long id,int cost, String title, boolean containsGluten, boolean containsPeanut, String ingredients) {
		super();
		this.id = id;
		this.cost = cost;
		this.title = title;
		this.containsGluten = containsGluten;
		this.containsPeanut = containsPeanut;
		this.ingredients = ingredients;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
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
	
	public boolean isContainsPeanut() {
		return containsPeanut;
	}
	
	public void setContainsPeanut(boolean containsPeanut) {
		this.containsPeanut = containsPeanut;
	}
	
	public String toString() {
        return "Recipe [id=" + id + ", cost=" + cost + ", title=" + title + ", containsGluten=" + containsGluten + ", containsPeanut=" + containsPeanut + ", ingredients="
 +  ingredients + "]";
	}
}

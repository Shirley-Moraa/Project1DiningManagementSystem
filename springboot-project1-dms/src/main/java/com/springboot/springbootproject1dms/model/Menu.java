package com.springboot.springbootproject1dms.model;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menus")
public class Menu {
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "budget", nullable = false)
	private static int budget;
	
	@Column(name = "combinations", nullable = false)
	private static int combinations;
	
	@Column(name = "containsGluten", nullable = false)
	private static boolean containsGluten;
	
	@Column(name = "containsPeanut", nullable = false)
	private boolean containsPeanut;

	public Menu() {
		super();
	}

	public Menu(long id, int budget, int combinations, boolean containsGluten, boolean containsPeanut) {
		super();
		this.id = id;
		this.budget = budget;
		this.combinations = combinations;
		this.containsGluten = containsGluten;
		this.containsPeanut = containsPeanut;
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

	/**
	 * @return the budget
	 */
	public static int getBudget() {
		return budget;
	}

	/**
	 * @param budget the budget to set
	 */
	public void setBudget(int budget) {
		this.budget = budget;
	}

	/**
	 * @return the combinations
	 */
	public static int getCombinations() {
		return combinations;
	}

	/**
	 * @param combinations the combinations to set
	 */
	public void setCombinations(int combinations) {
		this.combinations = combinations;
	}

	/**
	 * @return the containsGluten
	 */
	public static boolean isContainsGluten() {
		return containsGluten;
	}

	/**
	 * @param containsGluten the containsGluten to set
	 */
	public void setContainsGluten(boolean containsGluten) {
		this.containsGluten = containsGluten;
	}

	/**
	 * @return the containsPeanut
	 */
	public boolean isContainsPeanut() {
		return containsPeanut;
	}

	/**
	 * @param containsPeanut the containsPeanut to set
	 */
	public void setContainsPeanut(boolean containsPeanut) {
		this.containsPeanut = containsPeanut;
	}
	
	public String toString() {
        return "Recipe [id=" + id + ", budget=" + budget + ", combinations =" + combinations + ", containsGluten=" + containsGluten + ", containsPeanut=" + containsPeanut + "]";
	}
	
}

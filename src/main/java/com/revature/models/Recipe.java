package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="RECIPE")
public class Recipe {

	@Id
	@Column(name="RECIPE_ID")
	@GeneratedValue(generator="RECIPE_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="RECIPE_SEQ_GEN", sequenceName="RECIPE_SEQ", allocationSize=1)
	private int id;
	
	@Column(name="RECIPE_NAME", nullable=false)
	private String recipeName;
	
	@Column(name="CALORIES_PER_SERVING")
	private int caloriesPerServing;
	
	public Recipe() { }

	public Recipe(String recipeName, int caloriesPerServing) {
		super();
		this.recipeName = recipeName;
		this.caloriesPerServing = caloriesPerServing;
	}

	public Recipe(int id, String recipeName, int caloriesPerServing) {
		super();
		this.id = id;
		this.recipeName = recipeName;
		this.caloriesPerServing = caloriesPerServing;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public int getCaloriesPerServing() {
		return caloriesPerServing;
	}

	public void setCaloriesPerServing(int caloriesPerServing) {
		this.caloriesPerServing = caloriesPerServing;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", recipeName=" + recipeName + ", caloriesPerServing=" + caloriesPerServing + "]";
	}
}

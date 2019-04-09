package com.revature.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="USER_RECIPE_HISTORY")
public class UserRecipeHistory {
	
	@Id
	@Column(name="USER_RECIPE_HISTORY_ID")
	@GeneratedValue(generator="USER_RECIPE_HISTORY_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="USER_RECIPE_HISTORY_SEQ_GEN", sequenceName="USER_RECIPE_HISTORY_SEQ", allocationSize=1)
	private int id;
	
	@OneToOne
	@Column(name="USER_ID", nullable=false)
	private User user;
	
	@OneToOne
	@Column(name="RECIPE_ID", nullable=false)
	private Recipe recipe;
	
	@OneToOne
	@Column(name="DATE", nullable=false)
	private Date date;

	public UserRecipeHistory(int id, User user, Recipe recipe, Date date) {
		super();
		this.id = id;
		this.user = user;
		this.recipe = recipe;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "UserRecipeHistory [id=" + id + ", user=" + user + ", recipe=" + recipe + ", date=" + date + "]";
	}
}

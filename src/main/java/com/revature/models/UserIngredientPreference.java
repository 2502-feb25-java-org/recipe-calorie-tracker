package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="USER_INGREDIENT_PREFERENCE")
public class UserIngredientPreference {

	@Id
	@Column(name="USER_INGREDIENT_PREFERENCE_ID")
	@GeneratedValue(generator="USER_INGREDIENT_PREFERENCE_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="USER_INGREDIENT_PREFERENCE_SEQ_GEN", sequenceName="USER_INGREDIENT_PREFERENCE_SEQ", allocationSize=1)
	private int id;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="INGREDIENT_ID", nullable=false)
	private Ingredient ingredient;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="USER_ID", nullable=false)
	private User user;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="STATUS_ID", nullable=false)
	private Status status;
	
	public UserIngredientPreference() { }

	public UserIngredientPreference(int id, Ingredient ingredient, User user, Status status) {
		super();
		this.id = id;
		this.ingredient = ingredient;
		this.user = user;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserIngredientPreference [id=" + id + ", ingredient=" + ingredient + ", user=" + user + ", status="
				+ status + "]";
	}
}

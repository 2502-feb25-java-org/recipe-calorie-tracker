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
	private int ingredientId;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="USER_ID", nullable=false)
	private int userId;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="STATUS_ID", nullable=false)
	private int statusId;
	
	public UserIngredientPreference() { }
	
	public UserIngredientPreference(int ingredientId, int userId, int statusId) {
		super();
		this.ingredientId = ingredientId;
		this.userId = userId;
		this.statusId = statusId;
	}

	public UserIngredientPreference(int id, int ingredientId, int userId, int statusId) {
		super();
		this.id = id;
		this.ingredientId = ingredientId;
		this.userId = userId;
		this.statusId = statusId;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	@Override
	public String toString() {
		return "UserIngredientPreference [id=" + id + ", ingredientId=" + ingredientId + ", userId=" + userId
				+ ", statusId=" + statusId + "]";
	}
}

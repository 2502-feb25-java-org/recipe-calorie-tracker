package com.revature.models;

import java.util.Date;

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
@Table(name="APP_MEAL")
public class MealHistory {
	
	@Id
	@Column(name="MEAL_ID")
	@GeneratedValue(generator="MEAL_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="MEAL_SEQ_GEN", sequenceName="MEAL_SEQ", allocationSize=1)
 private int id;
	@Column(name="USER_ID", nullable=false)
 private int uid;
	@Column(name="TOTAL_CALORIES", nullable=false)
 private double totalCalories;
	@Column(name="MEAL_DATE")
 private Date date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public double getTotalCalories() {
		return totalCalories;
	}
	public void setTotalCalories(double totalCalories) {
		this.totalCalories = totalCalories;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public MealHistory(int id, int uid, double totalCalories, Date date) {
		super();
		this.id = id;
		this.uid = uid;
		this.totalCalories = totalCalories;
		this.date = date;
	}
	public MealHistory(int uid, double totalCalories, Date date) {
		super();
		this.uid = uid;
		this.totalCalories = totalCalories;
		this.date = date;
	}
	public MealHistory() {
		super();
	}
	
	public MealHistory(int id, int uid, double totalCalories) {
		super();
		this.id = id;
		this.uid = uid;
		this.totalCalories = totalCalories;
	}
	@Override
	public String toString() {
		return "MealHistory [id=" + id + ", uid=" + uid + ", totalCalories=" + totalCalories + ", date=" + date + "]";
	}
 
	
	
	
}

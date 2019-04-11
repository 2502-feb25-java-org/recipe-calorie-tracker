package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Calorie {
	@Id
	private int id;
	private String name;
	private String ndbno;
	private double calories;
	public Calorie(int id, String name, double calories) {
		super();
		this.id = id;
		this.name = name;
		this.calories = calories;
	}
	public Calorie(int id, String name, String ndbno, double calories) {
		super();
		this.id = id;
		this.name = name;
		this.ndbno = ndbno;
		this.calories = calories;
	}
	public String getNdbno() {
		return ndbno;
	}
	public void setNdbno(String ndbno) {
		this.ndbno = ndbno;
	}
	public Calorie() {
		super();
	}
	public Calorie(String name, double calories) {
		super();
		this.name = name;
		this.calories = calories;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCalories() {
		return calories;
	}
	public void setCalories(double calories) {
		this.calories = calories;
	}
	

}

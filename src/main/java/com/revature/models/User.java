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
@Table(name="APP_USER")
public class User {
	
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(generator="USER_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="USER_SEQ_GEN", sequenceName="USER_SEQ", allocationSize=1)
	private int id;
	
	@Column(name="FIRST_NAME", nullable=false)
	private String firstName;
	
	@Column(name="LAST_NAME", nullable=false)
	private String lastName;
	
	@Column(name="USERNAME", nullable=false, unique=true)
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="AGE")
	private int age;
	
	@Column(name="WEIGHT")
	private int weight;
	
	@Column(name="HEIGHT")
	private String height;
	
	@Column(name="MAX_CALORIE_INTAKE")
	private int maxCalorieIntake;
	
	public User() { }
	
	public User(String firstName, String lastName, String username, String password, int maxCalorieIntake) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.maxCalorieIntake = maxCalorieIntake;
	}
	

	public User(int id) {
		super();
		this.id = id;
	}

	public User(int id, String firstName, String lastName, String username, String password, int age, int weight,
			String height, int maxCalorieIntake) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.maxCalorieIntake = maxCalorieIntake;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(String height, String password, int age, String username, String firstName, String lastName, int id,
			int maxCalorieIntake, int weight) {
		super();
		this.height = height;
		this.password = password;
		this.age = age;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.maxCalorieIntake = maxCalorieIntake;
		this.weight = weight;
	}

	public User(String height, String password, int age, String username, String firstName, String lastName,
			int maxCalorieIntake, int weight) {
		super();
		this.height = height;
		this.password = password;
		this.age = age;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.maxCalorieIntake = maxCalorieIntake;
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public int getMaxCalorieIntake() {
		return maxCalorieIntake;
	}

	public void setMaxCalorieIntake(int maxCalorieIntake) {
		this.maxCalorieIntake = maxCalorieIntake;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", age=" + age + ", weight=" + weight + ", height=" + height
				+ ", maxCalorieIntake=" + maxCalorieIntake + "]";
	}
}

package com.pratik.userservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "USER", uniqueConstraints = { @UniqueConstraint(columnNames = "email") })
public class MyUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	private String gender;

	private String lastName;

	private Long age;

	private String email;

	private String password;

	public MyUser() {
		super();
	}

	public MyUser(Long userId, String gender, String lastName, Long age, String email, String password) {
		super();
		this.userId = userId;
		this.gender = gender;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

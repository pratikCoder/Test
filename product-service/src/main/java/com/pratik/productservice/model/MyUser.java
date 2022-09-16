package com.pratik.productservice.model;

public class MyUser {

	private Long userId;

	private String gender;

	private String lastName;

	private Long age;

	private String email;

	public MyUser() {
		super();
	}

	public MyUser(Long userId, String gender, String lastName, Long age, String email) {
		super();
		this.userId = userId;
		this.gender = gender;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
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

}

package com.caps.beans;

public class Cat {
	private String name;
	private String color;
	private String gender;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Cat [name=" + name + ", color=" + color + ", gender=" + gender + "]";
	}
}
package org.example;

import org.springframework.stereotype.Component;

//@Component
public class Cat {
	private String color;

	public Cat() {
		System.out.println("Cat Object created Successfully");
	}

	public Cat(String color) {
		System.out.println(color+" colored cat successfully created");
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}

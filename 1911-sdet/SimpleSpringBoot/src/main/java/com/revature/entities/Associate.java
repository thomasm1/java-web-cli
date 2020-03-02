package com.revature.entities;

public class Associate {

	private int id;
	private String name;
	private int points;
	
	public Associate(int id, String name, int points) {
		super();
		this.id = id;
		this.name = name;
		this.points = points;
	}
	
	public Associate() {
		super();
	}
	
	public Associate(String name, int points) {
		super();
		this.name = name;
		this.points = points;
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
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	@Override
	public String toString() {
		return "Associate [id=" + id + ", name=" + name + ", points=" + points + "]";
	}
	
}

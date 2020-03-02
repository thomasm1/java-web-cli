package com.revature.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class Associate {

	@Id
	@GeneratedValue
	@Column(name = "a_id")
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

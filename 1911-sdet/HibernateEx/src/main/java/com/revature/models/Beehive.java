package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//Denotes the class as needing a table in the database.
@Entity
@Table(name="Beehive")
public class Beehive {

	@Id
	@Column(name="bh_id")
	@SequenceGenerator(sequenceName="beehive_seq", name="bh_seq")
	@GeneratedValue(generator="bh_seq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="honey")
	private int honey;
	
	public Beehive() {
		super();
	}
	
	public Beehive(int id, int honey) {
		super();
		this.id = id;
		this.honey = honey;
	}
	
	public Beehive(int honey) {
		super();
		this.honey = honey;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getHoney() {
		return honey;
	}
	
	public void setHoney(int honey) {
		this.honey = honey;
	}
	
	@Override
	public String toString() {
		return "Beehive [id=" + id + ", honey=" + honey + "]";
	}
}

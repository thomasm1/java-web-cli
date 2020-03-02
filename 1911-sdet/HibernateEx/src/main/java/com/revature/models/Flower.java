package com.revature.models;

public class Flower {
	
	private int id;
	private String species;
	private int petals;
	
	public Flower() {
		super();
	}

	public Flower(int id, String species, int petals) {
		super();
		this.id = id;
		this.species = species;
		this.petals = petals;
	}

	public Flower(String species, int petals) {
		super();
		this.species = species;
		this.petals = petals;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public int getPetals() {
		return petals;
	}

	public void setPetals(int petals) {
		this.petals = petals;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + petals;
		result = prime * result + ((species == null) ? 0 : species.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flower other = (Flower) obj;
		if (id != other.id)
			return false;
		if (petals != other.petals)
			return false;
		if (species == null) {
			if (other.species != null)
				return false;
		} else if (!species.equals(other.species))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Flower: id=" + id + ", species=" + species + ", petals=" + petals;
	}	

}

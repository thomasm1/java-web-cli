package model;

public class Pokemon {

	private int p_id;
	private String name;
	private String bio;
	
	public Pokemon() {
		super();
	}

	public Pokemon(int p_id, String name, String bio) {
		super();
		this.p_id = p_id;
		this.name = name;
		this.bio = bio;
	}

	public Pokemon(String name, String bio) {
		super();
		this.name = name;
		this.bio = bio;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public String toString() {
		return "Pokemon [p_id=" + p_id + ", name=" + name + ", bio=" + bio + "]";
	}
}

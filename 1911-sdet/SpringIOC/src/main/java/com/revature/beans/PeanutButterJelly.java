package com.revature.beans;

public class PeanutButterJelly implements Jelly {

	private String flavor;
	
	public String getFlavor() {
		return this.flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	@Override
	public String toString() {
		return "PeanutButterJelly [flavor=" + flavor + "]";
	}

}

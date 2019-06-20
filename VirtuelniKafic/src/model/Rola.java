package model;

import javax.persistence.Embeddable;

@Embeddable
public class Rola {
	
	private String uloga;
	
	public String getUloga() {
		return uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
	}
	
	
}

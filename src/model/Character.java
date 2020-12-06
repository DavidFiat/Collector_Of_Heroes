package model;

import java.io.Serializable;

public class Character implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name, url;
	private int power;

	public Character(String url, String name, int power) {
		this.url = url;
		this.name = name;
		this.power = power;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Character [name=" + name + ", power=" + power + "]";
	}
}

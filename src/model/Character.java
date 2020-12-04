package model;

import java.io.Serializable;

public class Character implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private int power;

	public Character(String name, int power) {
		this.name = name;
		this.power = power;
	}

	@Override
	public String toString() {
		return "Character [name=" + name + ", power=" + power + "]";
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
}

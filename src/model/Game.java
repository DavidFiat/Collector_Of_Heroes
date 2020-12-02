package model;

import java.util.HashMap;

public class Game {
	private Score firstPlace;
	private Score secondPlace;
	private Score thirPlace;
	
	private HashMap<String, Player> player;

	public Game() {
		setPlayer(new HashMap<>());
	}

	public HashMap<String, Player> getPlayer() {
		return player;
	}

	public void setPlayer(HashMap<String, Player> player) {
		this.player = player;
	}

	public Score getFirstPlace() {
		return firstPlace;
	}

	public void setFirstPlace(Score firstPlace) {
		this.firstPlace = firstPlace;
	}

	public Score getSecondPlace() {
		return secondPlace;
	}

	public void setSecondPlace(Score secondPlace) {
		this.secondPlace = secondPlace;
	}

	public Score getThirPlace() {
		return thirPlace;
	}

	public void setThirPlace(Score thirPlace) {
		this.thirPlace = thirPlace;
	}
}

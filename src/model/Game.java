package model;

import java.util.HashMap;

public class Game {
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
}

package model;

import java.util.HashMap;

import stack.*;

public class Player {
	private String nickname;
	private InStack<Score> scores;
	private HashMap<String, Character> characters;

	public Player(String nickname, Score score) {
		super();
		this.nickname = nickname;
		scores = new IStack<Score>();
		characters= new HashMap<>();
	}

	public HashMap<String, Character> getCharacters() {
		return characters;
	}

	public void setCharacters(HashMap<String, Character> characters) {
		this.characters = characters;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public InStack<Score> getScores() {
		return scores;
	}

	public void setScores(InStack<Score> scores) {
		this.scores = scores;
	}

}

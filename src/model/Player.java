package model;

import java.util.HashMap;

import customExceptions.AlreadyHaveCharacter;
import stack.*;

public class Player {
	private String nickname;
	private InStack<Score> scores;
	private Character[] characters;

	public Player(String nickname) {
		this.nickname = nickname;
		scores = new IStack<Score>();
		characters = new Character[Game.NUMBER_OF_CHARACTERS];
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

	public int assignCharacter(Character c) throws AlreadyHaveCharacter {
		int i = c.getName().hashCode() % Game.NUMBER_OF_CHARACTERS;
		Character character = characters[i];
		if (character == null) {
			character = c;
			characters[i] = character;
		} else {
			throw new AlreadyHaveCharacter(nickname, c.getName());
		}
		return i;
	}
}

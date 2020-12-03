package model;

import java.io.Serializable;

import customExceptions.*;
import hashTable.*;
import stack.*;

public class Player implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nickname;
	private InStack<Score> scores;
	private IHashTable<String, Character> characters;

	public Player(String nickname) {
		this.nickname = nickname;
		scores = new IStack<Score>();
		characters = new HashTable<String, Character>();
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

	public void assignCharacter(Character c) throws AlreadyHaveCharacter {
		try {
			characters.add(c.getName(), c);
		} catch (RepeatedElementException e) {
			throw new AlreadyHaveCharacter(nickname, c.getName());
		}
	}

	public IHashTable<String, Character> getCharacters() {
		return characters;
	}

	public void setCharacters(IHashTable<String, Character> characters) {
		this.characters = characters;
	}
}

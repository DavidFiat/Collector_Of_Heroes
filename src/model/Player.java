package model;

import java.io.Serializable;
import customExceptions.AlreadyHaveCharacter;
import customExceptions.RepeatedElementException;
import hashTable.HashTable;
import hashTable.IHashTable;

public class Player implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nickname;
	private int score;
	private IHashTable<String, Character> characters;

	public Player(String nickname) {
		this.nickname = nickname;
		characters = new HashTable<String, Character>();
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void assignCharacter(Character c) throws AlreadyHaveCharacter {
		try{
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}

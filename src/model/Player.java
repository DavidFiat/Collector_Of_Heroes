package model;

import stack.*;

public class Player {
	private String nickname;
	private InStack<Score> scores;

	public Player(String nickname, Score score) {
		super();
		this.nickname = nickname;
		scores = new IStack<Score>();
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

package model;

public class Player{
	private String nickname;
	private Score score;
	
	public Player(String nickname, Score score) {
		super();
		this.nickname = nickname;
		this.score = score;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}
	
	
}

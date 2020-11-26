package model;

import stack.IStack;

public class Score {
	private IStack<Integer> scores;

	public Score() {
	}
	
	public IStack<Integer> getScores() {
		return scores;
	}

	public void setScores(IStack<Integer> scores) {
		this.scores = scores;
	}
	
	
}

package model;

import java.time.LocalDate;

public class Score {
	private int total;
	private LocalDate date;
	
	public Score(int total, LocalDate date) {
		this.total = total;
		this.date = date;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}

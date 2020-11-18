package model;

import java.util.ArrayList;

import thread.AbstractThread;
import thread.MoveThread;

public class Game {
	private Player player;
	private boolean paused;
	private ArrayList<AbstractThread> processes;
	public Game() {
		player= new Player(this);
		processes= new ArrayList<AbstractThread>();
		addProcesses();
	}
	
	public void addProcesses() {
		processes.add(new MoveThread(this));
	}
	
	public void startProcesses() {
		for (int i = 0; i < processes.size(); i++) {
			processes.get(i).start();
		}
	}

	public ArrayList<AbstractThread> getProcesses() {
		return processes;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public boolean isPaused() {
		return paused;
	}
	
	public void setPaused(boolean paused) {
		this.paused = paused;
	}
}

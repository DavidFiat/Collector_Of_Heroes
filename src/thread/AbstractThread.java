package thread;

import model.Game;

public class AbstractThread extends Thread {

	private Game game;

	public AbstractThread(Game game) {
		this.game = game;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public synchronized void resumeThread() {
		notify();
	}

	public void pause() {
		try {
			synchronized (this) {
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
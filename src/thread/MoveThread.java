package thread;

import model.Game;

public class MoveThread extends AbstractThread{

	public MoveThread(Game game) {
		super(game);
		setDaemon(true);
	}

	@Override
	public void run() {
		//getGame().getPlayer().getAnimation().runAnimation();
		while(true) {
			try {
				sleep(40);
				if(!getGame().getPlayer().getAnimation().isPause()) {
				getGame().getPlayer().move();	
				getGame().getPlayer().getAnimation().runAnimation();
				
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

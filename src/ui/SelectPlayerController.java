package ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Player;

public class SelectPlayerController implements KeyListener{
	private Main main;

	@Override
	public void keyPressed(KeyEvent e) {
		int key= e.getExtendedKeyCode();
		Player player= main.getGame().getPlayer();
		if(key== KeyEvent.VK_DOWN) {
			player.getAnimation().setPause(false);
			player.setAnimation(player.getAnimation1());
			player.setSpeedY(1);
		}
		if(key== KeyEvent.VK_UP) {
			player.getAnimation().setPause(false);
			player.setAnimation(player.getAnimation2());
			player.setSpeedY(-1);
		}
		if(key== KeyEvent.VK_RIGHT) {
			player.getAnimation().setPause(false);
			player.setAnimation(player.getAnimation3());
			player.setSpeedX(1);
		}
		if(key== KeyEvent.VK_LEFT) {
			player.getAnimation().setPause(false);
			player.setAnimation(player.getAnimation4());
			player.setSpeedX(-1);
		}
		if(key== KeyEvent.VK_J) {
			player.getAnimation().setPause(false);
			player.setAnimation(player.getAnimation5());
		}
		if(key== KeyEvent.VK_P) {
			player.getAnimation().setPause(false);
			player.setAnimation(player.getAnimation6());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key= e.getExtendedKeyCode();
		Player player= main.getGame().getPlayer();
		if(key== KeyEvent.VK_DOWN) {
			player.getAnimation().setPause(true);
			player.setSpeedY(0);
		}
		if(key== KeyEvent.VK_UP) {
			player.getAnimation().setPause(true);
			player.setSpeedY(0);
		}

		if(key== KeyEvent.VK_RIGHT) {
			player.getAnimation().setPause(true);
			player.setSpeedX(0);
		}

		if(key== KeyEvent.VK_LEFT) {
			player.getAnimation().setPause(true);
			player.setSpeedX(0);
		}

		if(key== KeyEvent.VK_J) {
			player.getAnimation().setPause(true);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

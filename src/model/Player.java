package model;

import java.awt.Graphics;

import animation.Animation;

public class Player extends GameObject{
	public Player(Game game, int x, int y) {
		super(game, x, y);
		// TODO Auto-generated constructor stub
	}

	private Animation animation;

	public Animation getAnimation() {
		return animation;
	}

	public void setAnimation(Animation animation) {
		this.animation = animation;
	}

	@Override
	public void move() {
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void action() {
		// TODO Auto-generated method stub

	}
}

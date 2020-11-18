package model;

import java.awt.Graphics;

import animation.Animation;
import util.GameLoader;
import ui.Main;

public class Player extends GameObject{
	public static final int WIDTH = 80;
	public static final int HEIGHT = 80;
	public static final int SPEED = 2;
	public static final int WIDTH_GAME = Main.WIDTH;
	public static final int HEIGHT_GAME = Main.HEIGHT;
	public static final int SPAWN_X = WIDTH_GAME / 2 - WIDTH / 2;
	public static final int SPAWN_Y = HEIGHT_GAME;
	public static final int X_LIMIT_LEFT = 0;
	public static final int X_LIMIT_RIGHT = Main.WIDTH;
	private Animation animation;
	private Animation animation1;
	private Animation animation2;
	private Animation animation3;
	private Animation animation4;
	private Animation animation5;
	private Animation animation6;
	private boolean isAlive;
	
	public Player(Game game) {
		super(game, 100, 100, 0, 0, WIDTH, HEIGHT, GameLoader.sprites.get("SANS"));
		animation1= new Animation(GameLoader.sprites.get("SANS"), 4, 1, 4, 1);
		animation2= new Animation(GameLoader.sprites.get("SANS ARRIBA"), 4, 1, 4, 1);
		animation3= new Animation(GameLoader.sprites.get("SANS DERECHA"), 4, 1, 4, 1);
		animation4= new Animation(GameLoader.sprites.get("SANS IZQUIERDA"), 4, 1, 4, 1);
		animation5= new Animation(GameLoader.sprites.get("SANS BROMA"), 3, 1, 3, 1);
		animation6= new Animation(GameLoader.sprites.get("SANS PEINE"), 3, 1, 3, 1);
		animation= animation1;
		isAlive=true;
	}

	public Player(Game game, int x, int y) {
		super(game, x, y);
		setSkin(GameLoader.images.get("SANS"));
		setWidth(WIDTH);
		setHeight(HEIGHT);
	}

	@Override
	public void move() {
		if(isAlive) {
			if(getX()<=0) {
				setX(0);
			}
			if(getX() >= WIDTH_GAME-WIDTH) {
				setX(WIDTH_GAME-WIDTH);
			}
			setX(getX()+getSpeedX());
			setY(getY()+getSpeedY());
		}
	}

	@Override
	public void render(Graphics g) {
		animation.drawAnimation(g, getX(), getY(), 0);
	}

	@Override
	public void action() {
	}

	@Override
	public void run() {

		while (animation.isAlive()) {
			try {
				if (!getGame().isPaused()) {
					sleep(6);
					animation.runAnimation();
				}else {
					pause();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public Animation getAnimation() {
		return animation;
	}

	public void setAnimation(Animation animation) {
		this.animation = animation;
	}

	public Animation getAnimation1() {
		return animation1;
	}

	public void setAnimation1(Animation animation1) {
		this.animation1 = animation1;
	}

	public Animation getAnimation2() {
		return animation2;
	}

	public void setAnimation2(Animation animation2) {
		this.animation2 = animation2;
	}

	public Animation getAnimation3() {
		return animation3;
	}

	public void setAnimation3(Animation animation3) {
		this.animation3 = animation3;
	}

	public Animation getAnimation4() {
		return animation4;
	}

	public void setAnimation4(Animation animation4) {
		this.animation4 = animation4;
	}

	public Animation getAnimation5() {
		return animation5;
	}

	public void setAnimation5(Animation animation5) {
		this.animation5 = animation5;
	}

	public Animation getAnimation6() {
		return animation6;
	}

	public void setAnimation6(Animation animation6) {
		this.animation6 = animation6;
	}
}

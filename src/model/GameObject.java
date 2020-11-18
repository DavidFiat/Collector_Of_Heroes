package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import thread.AbstractThread;

public abstract class GameObject extends AbstractThread {
	private int x;
	private int y;
	private int speedX;
	private int speedY;
	private int width;
	private int height;
	private Image skin;

	public GameObject(Game game, int x, int y, int speedX, int speedY, int width, int height, Image skin) {
		super(game);
		this.x = x;
		this.y = y;
		this.speedX = speedX;
		this.speedY = speedY;
		this.width = width;
		this.height = height;
		this.skin = skin;
	}

	public GameObject(Game game, int x, int y) {
		super(game);
		this.x = x;
		this.y = y;
	}

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getSkin() {
		return skin;
	}

	public void setSkin(Image skin) {
		this.skin = skin;
	}

	public abstract void move();

	public abstract void render(Graphics g);

	public abstract void action();

	public Rectangle getBounds() {
		return new Rectangle(getX() + getWidth() / 8, getY() + getHeight() / 8, getWidth() - getWidth() / 4, getHeight() - getHeight() / 4);
	}
}

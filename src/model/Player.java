package model;

import java.awt.Rectangle;

public class Player {
	
	private int x;
	private int y;
	private final int maxX;
	private final int maxY;
	private int height;
	private int width;
	private int health = 300;
	private int energy = 300;
	private int displaceSpeed = 5;
	
	private Rectangle player;
	
	public Player(int x, int y, int height, int width, int maxX, int maxY) {
		this.maxX = maxX;
		this.maxY = maxY;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		initsPlayer();
	}
	
	public void initsPlayer() {
		player = new Rectangle(x, y, width, height);
	}
	
	public Rectangle getPlayer() {
		return player;
	}
	
	public void displaceUpPlayer() {
		if (y > 0) {
			y-= displaceSpeed;
			player.setFrame(x, y, width, height);
		}
	}
	public void displaceDownPlayer() {
		if (y+height+26< maxY) {			
			y+= displaceSpeed;
			player.setFrame(x, y, width, height);
		}
	}
	
	public void displaceRigthPlayer() {
		if (x+width<maxX) {
			x+= displaceSpeed;
			player.setFrame(x, y, width, height);
		}
	}
	public void displaceLeftPlayer() {
		if (x > 0) {
			x-= displaceSpeed;
			player.setFrame(x, y, width, height);
		}
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean isLifeless() {
		return health==0;
	}
	public int reduceLife() {
		health--;
		return health;
	}
	
	public int reduceEnergy() {
		energy--;
		return energy;
	}
	
	public int consumeCapsule() {
		energy = 300;
		return energy;
	}
	
	public boolean isWithoutPower() {
		return energy==0;
	}
}


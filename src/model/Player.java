package model;

public class Player {
	
	private int x;
	private int y;
	private int height;
	private int width;
	public Player(int x, int y, int height, int width) {
		super();
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
		
	public void displacePlayer(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
}


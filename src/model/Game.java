package model;

import java.awt.Point;

public class Game {
	public static final int PLAYER_WIDTH= 50;
	public static final int PLAYER_HEIGHT = 50;
	
	
	private Player player;
	private boolean isInsideTheScreen;
	
	public Game(int xScreen, int yScreen) {
		player = new Player(xScreen/2 - PLAYER_WIDTH/2, PLAYER_HEIGHT + 43, PLAYER_HEIGHT,PLAYER_WIDTH);
		isInsideTheScreen = true;
	}
	
	public void displacePlayer(int x, int y) {
		if (x > PLAYER_WIDTH && y > PLAYER_HEIGHT+24) {
			player.displacePlayer(x-PLAYER_WIDTH, y-PLAYER_HEIGHT-22);
		}
	}
	
	public int getPlayerX() {
		return player.getX(); 
	}
	
	public int getPlayerY() {
		return player.getY();
	}
	
	public int getPlayerHeight() {
		return player.getHeight();
	}
	public int getPlayerWidth() {
		return player.getWidth();
	}
	
	public void setInsideTheScreen(boolean isInsideTheScreen) {
		this.isInsideTheScreen = isInsideTheScreen;
	}
	public boolean isInsideTheScreen() {
		return isInsideTheScreen;
	}
}

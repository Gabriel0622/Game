package model;

import java.awt.Point;
import java.awt.Rectangle;

import constant.GameMachine;

public class Game {
	public static final int PLAYER_WIDTH= 50;
	public static final int PLAYER_HEIGHT = 50;
	
	private final int maxX;
	private final int maxY;
	
	private Player player;
	private Iceberg iceberg1;
	
	private EnergyCapsule energyCapsule;
	
	
	private String playerMove;
	private boolean playerPower;
	private String score;

	public Game(int xScreen, int yScreen) {
		maxX = xScreen;
		maxY = yScreen;
		playerMove = GameMachine.MOVE_NONE;
		playerPower = false;
		player = new Player(xScreen/2 - PLAYER_WIDTH/2, PLAYER_HEIGHT + 43, PLAYER_HEIGHT,PLAYER_WIDTH,xScreen, yScreen);
		iceberg1 = new Iceberg(xScreen, yScreen);
		energyCapsule = new EnergyCapsule(yScreen, xScreen);
	}
	
	public void displaceUpPlayer() {
		player.displaceUpPlayer();
	}
	public void displaceDownPlayer() {
		player.displaceDownPlayer();
	
	}
	public void displaceRigthPlayer() {
		player.displaceRigthPlayer();
	}
	public void displaceLeftPlayer() {
		player.displaceLeftPlayer();
	}
	
	
	public void displaceIcberg() {
		iceberg1.displaceIceberg();
	}
	
	public void displacedEnergyCapsule() {
		energyCapsule.displaceEnergyCapsule();
	}
	
	public Rectangle getPlayer() {
		return player.getPlayer();
	}
	
	public void setPlayerMove(String playerMove) {
		this.playerMove = playerMove;
	}
	
	public String getPlayerMove() {
		return playerMove;
	}
	
	public boolean getPlayerPower() {
		return playerPower;
	}
	
	public void setPlayerPower(boolean playerPower) {
		this.playerPower = playerPower;
	}
	
	public boolean isColisionIceberg() {
		return player.getPlayer().intersects(iceberg1.getRectangle());
	}
	
	public boolean isColisionEnergyCapsule() {
		return player.getPlayer().intersects(energyCapsule.getRectangle());
	}
	
	public boolean isMoveUp() {
		return playerMove.equals(GameMachine.MOVE_UP);
	}
	public boolean isMoveDown() {
		return playerMove.equals(GameMachine.MOVE_DOWN);
	}
	public boolean isMoveLeft() {
		return playerMove.equals(GameMachine.MOVE_LEFT);
	}
	public boolean isMoveRigth() {
		return playerMove.equals(GameMachine.MOVE_RIGTH);
	}

	public Rectangle getIceberg() {
		return iceberg1.getRectangle();
	}
	
	public Rectangle getEnergyCapsule() {
		return energyCapsule.getRectangle();
	}
	
	public String getScore() {
		return String.valueOf(iceberg1.getIcebergCounter());
	}
	
	public boolean isLifeless() {
		return player.isLifeless();
	}
	
	public boolean isWithoutPower() {
		return player.isWithoutPower();
	}
	
	public boolean isSecondMove() {
		return !playerMove.equals(GameMachine.MOVE_NONE);
	}
	
	public int reduceHealth() {
		return player.reduceLife();
	}

	public int reduceEnergy() {
		return player.reduceEnergy();
	}
	
	
	public int getPlayerX() {
		return player.getX();
	}

	public int getPlayerY() {
		return player.getY();
	}	
	public int consumeCapsule() {
		energyCapsule.consumeCapsule();
		return player.consumeCapsule();
	}
	
}

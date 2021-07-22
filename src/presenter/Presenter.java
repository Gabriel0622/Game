package presenter;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowListener;

import javax.swing.ButtonModel;
import javax.swing.Timer;

import constant.GameMachine;
import model.Game;
import view.MainFrame;

public class Presenter implements ActionListener{
	
	private MainFrame view;
	private Game game;
	private Timer newGame;
	
	public Presenter() {
		view = new MainFrame(this);
		game = new Game(view.SCREEN_SIZE.width, view.SCREEN_SIZE.height);
		addKeyListener();
		startGame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Defualt":
			
			break;

		default:
			break;
		}
		
	}
	
	public void startGame() {
		view.startGame(game.getPlayer(),game.getIceberg(), game.getEnergyCapsule());
		newGame = new Timer(5, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.displaceIcberg();
				view.displaceIceberg(game.getIceberg().y);
				game.displacedEnergyCapsule();
				view.displaceEnergyCapsule(game.getEnergyCapsule().y);
				view.setScore(game.getScore());
				boolean playerPower = game.getPlayerPower();
				if (game.isWithoutPower()) {
					playerPower = false;
				}
				if (playerPower) {
					view.activePower();
					view.setEnergy(game.reduceEnergy());;
				}else {
					view.desactiePower();					
				}
				if (game.isColisionIceberg()) {
					if (!playerPower) {
						view.setHealth(game.reduceHealth());	
					}
				}
				if (game.isColisionEnergyCapsule()) {
					view.setEnergy(game.consumeCapsule());;
				}
				if (game.isLifeless()) {
					newGame.stop();
				}
				switch (game.getPlayerMove()) {
				case GameMachine.MOVE_UP:
					game.displaceUpPlayer();;
					view.displacePlayer(game.getPlayerX(),game.getPlayerY());
					break;
				case GameMachine.MOVE_DOWN:
					game.displaceDownPlayer();
					view.displacePlayer(game.getPlayerX(),game.getPlayerY());
					break;
				case GameMachine.MOVE_RIGTH:
					game.displaceRigthPlayer();
					view.displacePlayer(game.getPlayerX(),game.getPlayerY());
					break;
				case GameMachine.MOVE_LEFT:
					game.displaceLeftPlayer();
					view.displacePlayer(game.getPlayerX(),game.getPlayerY());
					break;
				case GameMachine.MOVE_DIAG_LEFT_UP:
					game.displaceLeftPlayer();
					game.displaceUpPlayer();
					view.displacePlayer(game.getPlayerX(),game.getPlayerY());
					break;
				case GameMachine.MOVE_DIAG_LEFT_DOWN:
					game.displaceLeftPlayer();
					game.displaceDownPlayer();
					view.displacePlayer(game.getPlayerX(),game.getPlayerY());
					break;
				case GameMachine.MOVE_DIAG_RIGTH_UP:
					game.displaceRigthPlayer();
					game.displaceUpPlayer();
					view.displacePlayer(game.getPlayerX(),game.getPlayerY());
					break;
				case GameMachine.MOVE_DIAG_RIGTH_DOWN:
					game.displaceRigthPlayer();
					game.displaceDownPlayer();
					view.displacePlayer(game.getPlayerX(),game.getPlayerY());
					break;
				default:
					break;
				}
			}
		});
		newGame.start();
	}
	
	public void addKeyListener() {
		view.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				 int code = e.getExtendedKeyCode();
				 switch (code) {
				case KeyEvent.VK_LEFT:
					game.setPlayerMove(GameMachine.MOVE_NONE);
					break;
				case KeyEvent.VK_RIGHT:
					game.setPlayerMove(GameMachine.MOVE_NONE);
					break;
				case KeyEvent.VK_UP:
					game.setPlayerMove(GameMachine.MOVE_NONE);
					break;
				case KeyEvent.VK_DOWN:
					game.setPlayerMove(GameMachine.MOVE_NONE);
					break;
				case KeyEvent.VK_E:
					game.setPlayerPower(false);
					break;
				default:
					break;
				 }
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				 int code = e.getExtendedKeyCode();
				 switch (code) {
				case KeyEvent.VK_LEFT:
					if (game.isSecondMove()) {
						diagonLeft();
					}else {
						game.setPlayerMove(GameMachine.MOVE_LEFT);
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (game.isSecondMove()) {
						diagonRigth();
					}else {
						game.setPlayerMove(GameMachine.MOVE_RIGTH);
					}
					break;
				case KeyEvent.VK_UP:
					if (game.isSecondMove()) {
						diagonUp();
					}else {
						game.setPlayerMove(GameMachine.MOVE_UP);
					}
					break;
				case KeyEvent.VK_DOWN:
					if (game.isSecondMove()) {
						diagonDown();
					}else {
						game.setPlayerMove(GameMachine.MOVE_DOWN);
					}
					break;
				case KeyEvent.VK_E:
					game.setPlayerPower(true);
					break;
				default:
					break;
				}
				
			}
		});
	}
	private void diagonLeft() {
		if (game.isMoveUp()) {
			game.setPlayerMove(GameMachine.MOVE_DIAG_LEFT_UP);
		}
		if (game.isMoveDown()) {
			game.setPlayerMove(GameMachine.MOVE_DIAG_LEFT_DOWN);
		}
	}
	
	private void diagonRigth() {
		if (game.isMoveUp()) {
			game.setPlayerMove(GameMachine.MOVE_DIAG_RIGTH_UP);
		}
		if (game.isMoveDown()) {
			game.setPlayerMove(GameMachine.MOVE_DIAG_RIGTH_DOWN);
		}
	}
	private void diagonUp() {
		if (game.isMoveLeft()) {
			game.setPlayerMove(GameMachine.MOVE_DIAG_LEFT_UP);
		}
		if (game.isMoveRigth()) {
			game.setPlayerMove(GameMachine.MOVE_DIAG_RIGTH_UP);
		}
	}
	private void diagonDown() {
		if (game.isMoveLeft()) {
			game.setPlayerMove(GameMachine.MOVE_DIAG_LEFT_DOWN);
		}
		if (game.isMoveRigth()) {
			game.setPlayerMove(GameMachine.MOVE_DIAG_RIGTH_DOWN);
		}
	}
}

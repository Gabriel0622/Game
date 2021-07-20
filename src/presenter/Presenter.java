package presenter;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowListener;

import javax.swing.ButtonModel;
import javax.swing.Timer;

import model.Game;
import view.MainFrame;

public class Presenter implements ActionListener{
	
	private MainFrame view;
	private Game game;
	
	public Presenter() {
		view = new MainFrame(this);
		game = new Game(view.SCREEN_SIZE.width, view.SCREEN_SIZE.height);
		addMouseMotionListener();
		//startGame();
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
	
//	public void startGame() {
//		view.startGame(game.getPlayerX(), game.getPlayerY(),game.getPlayerHeight(), game.getPlayerWidth());
//		Timer newGame = new Timer(5, new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				Point punto=MouseInfo.getPointerInfo().getLocation();
//				game.displacePlayer(punto.x ,punto.y);
//				view.displacePlayer(game.getPlayerX(),game.getPlayerY());
//				view.playerClicl();
//			}
//		});
//		newGame.start();
//	}
	
	public void addMouseMotionListener() {
		view.startGame(game.getPlayerX(), game.getPlayerY(),game.getPlayerHeight(), game.getPlayerWidth());
		view.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				game.displacePlayer(e.getX() ,e.getY());
				view.displacePlayer(game.getPlayerX(),game.getPlayerY());
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				game.displacePlayer(e.getX() ,e.getY());
				view.displacePlayer(game.getPlayerX(),game.getPlayerY());
				view.playerClick();
				
			}
		});
	}

}

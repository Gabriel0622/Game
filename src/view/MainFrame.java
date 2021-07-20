package view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import constant.ComponentText;
import constant.Path;
import view.panels.PanelGame;

public class MainFrame extends JFrame{
	private PanelGame pnGame;
	public final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();;
	
	public MainFrame(ActionListener listener) {
		super(ComponentText.TITLE_MAIN_FRAME);
		//this.setSize(1200,700);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon(getClass().getResource(Path.DATA_IMAGES_APP_ICON_PNG)).getImage());
		initsCompontents(listener);
		this.setVisible(true);
	}
	
	private void initsCompontents(ActionListener listener) {
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
		cursorImg, new Point(0, 0), "blank cursor");
		this.getContentPane().setCursor(blankCursor);
	}
	public void startGame(int initialX, int initialY, int playerHeight, int playerWidth) {
		pnGame = new PanelGame(initialX, initialY, playerHeight, playerWidth);
		this.add(pnGame);
	}
	public void displacePlayer(int x, int y) {
		pnGame.setPlayerPosition(x, y);
	}
	public void playerClick() {
		pnGame.pressClick();
		
	}
}

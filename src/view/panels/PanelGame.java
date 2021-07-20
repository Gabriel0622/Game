package view.panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelGame extends JPanel	{
	private Graphics2D g2d;
	
	private int playerX;
	private int playerY;
	private final int playerHeight;
	private final int playerWidth;
	private ArrayList<Point> points;
	
	public PanelGame(int initialX, int initialY, int playerHeight, int playerWidth) {
		this.setOpaque(false);
		points = new ArrayList<Point>();
		this.playerX = initialX;
		this.playerY = initialY;
		this.playerHeight = playerHeight;
		this.playerWidth = playerWidth;
	}
	
	@Override
	public void paint(Graphics g) {
		g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		paintBackground();
		paintShadow();
		paintPlayer();
		super.paint(g);
	}
	
	private void paintBackground() {
		g2d.setColor(new Color(0x7ACFDF));
		g2d.fillRect(0, 0, getWidth(), getHeight());
	}
	
	private void paintPlayer() {
		g2d.setColor(new Color(0xF47645));
		g2d.fillRect(playerX,playerY,playerWidth, playerHeight);
	}
	
	private void paintShadow() {
		g2d.setColor(Color.WHITE);
		for (Point point : points) {
			g2d.fillOval(point.x-25, point.y-25, playerWidth+50, playerHeight+50);
		}
	}
	
	public void setPlayerPosition(int playerX,int playerY) {
		this.playerX = playerX;
		this.playerY = playerY;
		this.repaint();
	}
	
	public void pressClick() {
		int pointsSize = points.size();
		if (pointsSize>= 20) {
			points.add(new Point(playerX, playerY));
			points.remove(0);
		}else {
			points.add(new Point(playerX, playerY));			
		}
		this.repaint();
	}
	
}

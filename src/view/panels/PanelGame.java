package view.panels;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
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
	private int playerHeight;
	private int playerWidth;
	private Rectangle iceberg;
	private Rectangle energyCapsule;
	public static final int MAX_HEALTH = 300;
	public static final int MAX_ENERGY = 300;
	private int health;
	private int energy;
	private String score;
	
	private boolean isActivePower;
	
	public PanelGame(Rectangle player, Rectangle iceberg, Rectangle energyCapsule) {
		this.setOpaque(false);
		this.isActivePower = false;
		this.score = "0";
		this.playerX = player.x;
		this.health = MAX_HEALTH;
		this.energy = MAX_ENERGY;
		this.playerY = player.y;
		this.playerHeight = player.height;
		this.playerWidth = player.height;
		this.iceberg = iceberg;
		this.energyCapsule = energyCapsule;
	}
	
	@Override
	public void paint(Graphics g) {
		g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		paintBackground();
		paintIceberg();
		if (isActivePower) {
			paintPower();
		}
		paintCapsuleEnergy();
		paintPlayer();
		paintHealthEnergyScore();
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

	private void paintIceberg() {
		g2d.setColor(Color.WHITE);
		g2d.fillRect(iceberg.x, iceberg.y, iceberg.width, iceberg.height);
	}
	private void paintCapsuleEnergy() {
		g2d.setColor(Color.BLUE);
		g2d.fillRect(energyCapsule.x, energyCapsule.y, energyCapsule.width, energyCapsule.height);
	}
	
	private void paintHealthEnergyScore() {
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.6f));
		g2d.setColor(Color.WHITE);
		g2d.fillRoundRect(40, 40, MAX_HEALTH+6, 60, 20, 20);
		g2d.setColor(Color.GREEN);
		g2d.fillRoundRect(43, 43, health, 54, 20, 20);
		g2d.setColor(Color.YELLOW);
		g2d.fillRoundRect(43, 100, energy, 34, 20, 20);
		g2d.setFont(new Font("Impact",Font.PLAIN , 96));
		g2d.setColor(Color.BLACK);
		g2d.drawString(score, getWidth()-300, 130);
	
	}
	private void paintPower() {
		g2d.setColor(Color.YELLOW);
		g2d.fillRoundRect(playerX-25,playerY-25, playerWidth+50, playerWidth+50, 20, 20);	
	}
	
	public void setHealth(int health) {
		this.health = health;
		this.repaint();
	}
	public void setEnergy(int energy) {
		this.energy = energy;
		this.repaint();
	}
	
	public void setPlayerPosition(int playerX,int playerY) {
		this.playerX = playerX;
		this.playerY = playerY;
		this.repaint();
	}
	
	public void setIcebergPosition(int yPosition) {
		iceberg.setLocation(iceberg.x, yPosition);
		this.repaint();
	}
	
	public void setEnergyCapsulePosition(int yPosition) {
		energyCapsule.setLocation(energyCapsule.x, yPosition);
		this.repaint();
	}
	
	public void setScore(String score) {
		this.score = score;
	}
	
	public void activePower() {
		isActivePower = true;
		this.repaint();
	}
	
	public void desactivePower() {
		isActivePower = false;
		this.repaint();
	}
	
}

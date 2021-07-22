package model;

import java.awt.Rectangle;
import java.util.Random;

public class EnergyCapsule {
	public static final int HEIGTH =  20; 
	public static final int WIDTH =  20; 
	public static final int ITERATOR =  2; 
	
	private int yPosition;
	private int xPosition;
	private int maxY;
	private int maxX;
	
	
	
	private Random random;
	private Rectangle energyCapsule;
	
	public EnergyCapsule(int maxY, int maxX) {
		this.maxY = maxY;
		this.maxX = maxX;
		initsRectangle();
	}
	private void initsRectangle() {
		random = new Random();
		this.yPosition = random.nextInt(maxY)+ 300;
		this.xPosition = random.nextInt(maxX);
		energyCapsule = new Rectangle(0, yPosition, WIDTH, HEIGTH);
	}
	
	public void displaceEnergyCapsule() {
		if (yPosition <= -500) {
			yPosition = maxY;
			xPosition = random.nextInt(maxX);
			energyCapsule.setLocation(xPosition, yPosition);
			energyCapsule.setSize(WIDTH, HEIGTH);
		}else {
			yPosition -= ITERATOR;
			energyCapsule.setLocation(xPosition, yPosition);
		}
	}
	public Rectangle getRectangle() {
		return energyCapsule;
	}
	
	public void consumeCapsule() {
		energyCapsule.setSize(0, 0);
	}
	
	public void restoreCapsule() {
		energyCapsule.setSize(WIDTH, HEIGTH);
	}
}

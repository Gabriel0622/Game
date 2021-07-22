package model;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Iceberg {
	
	public static final int HEIGTH =  500; 
	public static final int ITERATOR =  2; 
	
	private int width;
	private int yPosition;
	private int maxYPosition;
	private int icebergCounter;
	
	private Rectangle iceberg;
	
	public Iceberg(int width,int yPosition) {
		this.width = width;
		this.yPosition = yPosition;
		this.maxYPosition = yPosition;
		initsRectangle();
	}
	private void initsRectangle() {
		iceberg = new Rectangle(0, yPosition, width, HEIGTH);
	}
	
	public void displaceIceberg() {
		if (yPosition == -500) {
			yPosition = maxYPosition;
			icebergCounter++;
			iceberg.setLocation(0, yPosition);
		}else {
			yPosition -= ITERATOR;
			iceberg.setLocation(0, yPosition);
		}
	}
	
	public int getIcebergCounter() {
		return icebergCounter;
	}
	
	public Rectangle getRectangle() {
		return iceberg;
	}
}

package model;

import java.awt.Color;

/**
 * Defines the Brick objet.
 * 
 * @author Antoine Fonfria - 14 129 748
 * @author Baptiste Jaeckert 14 129 775
 * @author Jonathan Diaz-Muy 13 041 479
 * @author Adrien Burel 14 126 607
 * @author Landry Modeste Goutondji  14 000 626
 * @author J�r�my Collard 14 129 766
 * @author Mentor Bajraktari 14 129 757
 * @author Olivier Scheffler 12 179 288
 * @author Elliot G�mus-Pr�vost 13 111 198
 * @author Samuel Arseneault 13 161 801
 * @author Djenebou Monique Dembele 10 103 210
 * @author Florent Gargot 14 129 784
 */

public class Brick {

	private int x, y;
	private boolean alive;
	private int brickPointValue;
	private Color color;
	
	public Brick() {
		this.x = 4; // Initial position in the middle
		this.y = 4;
		this.alive = true;
		this.setColor();
	}

	public Brick(int x, int y, int newPointValue) {
		this.x = x;
		this.y = y;
		this.brickPointValue = newPointValue;
		this.alive = true;
		this.setColor();
	}
	
	public void setColor(){
		Color[] colorList = {new Color(245,129,71), new Color(29,124,188), new Color(90,213,193),
				new Color(152,213, 90), new Color(243, 243, 85), new Color(245, 187, 71), new Color(29,124,188) };
		setColor(colorList[(getY()) % 6]);
	}
	
	public void setColor(Color c){
		this.color = c;
	}

	public Color getColor(){
		return this.color;
	}

	/**
	 * Setters
	 */
	public void setX(int newX) {
		if (newX  >= 0) {
			x = newX;
		}

	}

	public void setY(int newY) {
		if (newY >= 0) {
			y = newY;
		}
	}
	
	public void setBrickPointValue(int newPointValue) {
		this.brickPointValue = newPointValue;
	}


	public void kill(){
		this.alive = false;
	}
	
	public void revive(){
		this.alive = true;
	}
	

	/**
	 * Getters
	 */
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getBrickPointValue() {
		return brickPointValue;
	}
	
	public boolean isDead() {
		return !alive;
	}


}

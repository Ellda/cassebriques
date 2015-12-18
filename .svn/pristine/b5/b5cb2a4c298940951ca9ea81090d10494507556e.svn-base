package model;

/**
 * Defines the Brick objet.
 * 
 * @author Antoine Fonfria - 14 129 748
 * @author Baptiste Jaeckert 14 129 775
 * @author Jonathan Diaz-Muy 13 041 479
 * @author Adrien Burel 14 126 607
 * @author Landry Modeste Goutondji  14 000 626
 * @author Jérémy Collard 14 129 766
 * @author Mentor Bajraktari 14 129 757
 * @author Olivier Scheffler 12 179 288
 * @author Elliot Gémus-Prévost 13 111 198
 * @author Samuel Arseneault 13 161 801
 * @author Djenebou Monique Dembele 10 103 210
 * @author Florent Gargot 14 129 784
 */

public class Brick {

	private int x, y;
	private boolean alive;
	private int brickPointValue;

	public Brick() {
		this.x = 4; // Initial position in the middle
		this.y = 4;
		this.alive = true;
	}

	public Brick(int x, int y, int newPointValue) {
		this.x = x;
		this.y = y;
		this.brickPointValue = newPointValue;
		this.alive = true;
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

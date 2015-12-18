package model;

import java.awt.Color;

/**
 * The extended model of a brick that is also a bonus.
 * 
 * @author Antoine Fonfria
 */

public class Brick_bonus extends Brick {

	private int type;
	
	public Brick_bonus(int x, int y, int newPointValue) {
		super(x, y, newPointValue);
		generateRandomType();
	}

	public Brick_bonus(int x, int y, int newPointValue, int type) {
		super(x, y, newPointValue);
		setType(type);
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}


	/*public Color getColor(){
		return new Color(0, 0, 0);
	}*/
	
	@Override
	public void kill() {
		// TODO Auto-generated method stub
		// TODO Call a specific method
		super.kill();
	}


	private void generateRandomType() {
		int type = (int) Math.floor(Math.random() * 5);
		setType(type);
	}
	
	
}

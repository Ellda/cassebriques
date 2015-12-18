package controller;

import java.awt.Color;

import model.Brick;

public class Brick_strong extends Brick {

	private int resistance;

	public Brick_strong() {
		super();
		setResistance(3);
	}

	public Brick_strong(int x, int y, int newPointValue) {
		super(x, y, newPointValue);
		setResistance(3);
	}
	
	public Brick_strong(int x, int y, int newPointValue, int resistance) {
		super(x, y, newPointValue);
		setResistance(resistance);
		setColor();
	}

	@Override
	public void setColor() {
		setColor(new Color(Math.min(0 + getResistance() * 30, 200), Math.min(0 + getResistance() * 30, 200), Math.min(0 + getResistance() * 30, 200)));
	}

	@Override
	public void kill() {
		if(getResistance() > 0){
			setResistance(getResistance() - 1);
			setColor();
		}else{
			super.kill();
		}
	}
	
	public int getResistance() {
		return resistance;
	}

	public void setResistance(int resistance) {
		this.resistance = resistance;
	}
	
}

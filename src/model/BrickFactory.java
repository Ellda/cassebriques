package model;

//import java.awt.Color;

public class BrickFactory {

	private Game game;
	private int bonusRate;
	private int strongRate;
	private int strongMaxResistance;
	
	public BrickFactory(Game game) {
		this(game, 10, 20, 3);
	}

	public BrickFactory(Game game, int bonusRate, int strongRate, int strongMaxResistance) {
		//setColor(colorList[(getY()) % 6]);
		this.game = game;
		this.bonusRate = bonusRate;
		this.strongRate = strongRate;
		this.strongMaxResistance = strongMaxResistance;
	}
	
	/**
	 * Creates a particular brick
	 * @param i (int) : Position X of the brick
	 * @param j (int) : Position Y of the brick
	 * @return an instance of a Brick, Brick_bonus or Brick_strong.
	 */
	public Brick makeBrick(int i, int j){
		int type = (int) Math.floor(Math.random() * 100);
		if(type < getBonusRate())
			return new Brick_bonus(i, j, 20, game);
		else if(type < getBonusRate() + getStrongRate())
			return new Brick_strong(i, j, 30, getStrongMaxResistance());
		else
			return new Brick(i, j, 10);
	}

	/**
	 * Setters
	 */

	public void setBonusRate(int bonusRate) {
		if(bonusRate >= 0 && bonusRate <= 100)
			this.bonusRate = bonusRate;
	}

	public void setStrongRate(int strongRate) {
		if(strongRate >= 0 && strongRate <= 100)
			this.strongRate = strongRate;
	}

	public void setStrongMaxResistance(int strongMaxResistance) {
		if(strongMaxResistance >= 1)
			this.strongMaxResistance = strongMaxResistance;
	}
	/**
	 * Getters
	 */
	public int getBonusRate() {
		return bonusRate;
	}
	public int getStrongRate() {
		return strongRate;
	}
	public int getStrongMaxResistance() {
		return strongMaxResistance;
	}
}

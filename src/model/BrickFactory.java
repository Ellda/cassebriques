package model;

//import java.awt.Color;

public class BrickFactory {

	private Game game;
	private int bonusRate;
	private int strongRate;
	private int strongMaxResistance;
	/*private Color[] simpleBrickColorList = {
			new Color(245,129,71), new Color(29,124,188), new Color(90,213,193),
			new Color(152,213, 90), new Color(243, 243, 85), new Color(245, 187, 71), new Color(29,124,188)
	};
	private Color bonusBrickColor = new Color(255,255,255);*/
	
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
	
	public Brick makeBrick(int i, int j){
		int type = (int) Math.floor(Math.random() * 100);
		if(type <= getBonusRate())
			return new Brick_bonus(i, j, 20, game);
		else if(type <= getBonusRate() + getStrongRate())
			return new Brick_strong(i, j, 30, getStrongMaxResistance());
		else
			return new Brick(i, j, 10);
	}

	/**
	 * Setters
	 */

	public void setBonusRate(int bonusRate) {
		this.bonusRate = bonusRate;
	}

	public void setStrongRate(int strongRate) {
		this.strongRate = strongRate;
	}

	public void setStrongMaxResistance(int strongMaxResistance) {
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

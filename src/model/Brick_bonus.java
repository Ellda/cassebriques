package model;

import java.awt.Color;

/**
 * The extended model of a brick that is also a bonus.
 * 
 * @author Antoine Fonfria
 */

public class Brick_bonus extends Brick {

	private Game game;
	private int type;
	
	public Brick_bonus(int x, int y, int newPointValue, Game game) {
		super(x, y, newPointValue);
		this.game = game;
		generateRandomType();
		setColor(Color.WHITE);
	}

	public Brick_bonus(int x, int y, int newPointValue, Game game, int type) {
		super(x, y, newPointValue);
		this.game = game;
		setType(type);
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public void setColor(){
		setColor(new Color(255, 255, 255));
	}
	
	@Override
	public void kill() {
		// TODO Call a specific method
		Grid g = Grid.getInstance();
		game.getBonusObjectController().createBonusObject(getType(),
				g.getXLeftFromBrick(this) + g.getBrickWidth() / 2,
				g.getYTopFromBrick(this) + g.getBrickHeight() / 2);
		super.kill();
	}


	private void generateRandomType() {
		int type = (int) Math.floor(Math.random() * 4);
		setType(type);
	}
	
	
}

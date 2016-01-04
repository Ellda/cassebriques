package model;

public class Bonus_life extends Bonus{
	
	public Bonus_life(Game game) {
		super(game);
	}
		
	@Override
	public void launchBonus()
	{
		game.setLife(game.getLife()+1);
	}
}

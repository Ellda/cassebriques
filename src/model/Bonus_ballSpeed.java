package model;

public class Bonus_ballSpeed extends Bonus{

	private double coeff;
	
	public Bonus_ballSpeed(Game game) {
		super(game);
		coeff = 2;
	}
		
	@Override
	public void launchBonus()
	{
		game.getBall().setSpeed(game.getBall().getSpeed() / coeff);
		super.launchBonus();
	}
	
	@Override
	protected void stopBonus()
	{
		game.getBall().setSpeed(game.getBall().getSpeed() * coeff);
	}
}

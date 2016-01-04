package model;

public class Bonus_size extends Bonus{

	private int addValue;
	
	public Bonus_size(Game game) {
		super(game);
		addValue = 50;
	}
		
	@Override
	public void launchBonus()
	{
		game.getBar().setWidth(game.getBar().getWidth() + addValue);
		super.launchBonus();
	}
	
	@Override
	protected void stopBonus()
	{
		game.getBar().setWidth(game.getBar().getWidth() - addValue);
	}
}

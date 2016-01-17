package model;

public class Bonus_points extends Bonus{

	private double coeff;
	private int previousScore;
	
	public double getCoeff() {
		return coeff;
	}

	public void setCoeff(double coeff) {
		this.coeff = coeff;
	}

	public int getPreviousScore() {
		return previousScore;
	}

	public Bonus_points(Game game) {
		super(game);
		coeff = 2;
	}
		
	@Override
	public void launchBonus()
	{
		previousScore = game.getBrickController().getScore();
		super.launchBonus();
	}
	
	@Override
	protected void stopBonus()
	{
		int newScore = (int) (previousScore + (game.getBrickController().getScore() - previousScore)*coeff);
		game.getBrickController().setScore(newScore);
	}
}

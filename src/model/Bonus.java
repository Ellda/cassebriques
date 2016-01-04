package model;

public class Bonus {
	
	protected Game game;
	protected int delay;

	public Bonus(Game game) {
		super();
		this.game = game;
		delay = 10000;
	}		
	
	public void launchBonus()
	{
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		                stopBonus();
		            }
		        }, 
		        delay 
		);
	}
	
	protected void stopBonus()
	{
		
	}
}

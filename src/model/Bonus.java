package model;

import java.util.Timer;
import java.util.TimerTask;

public class Bonus {
	
	protected Game game;
	protected int delay;
	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	private Timer timer;

	public Bonus(Game game) {
		super();
		this.game = game;
		delay = 10000;
	}		
	
	public void launchBonus()
	{
		timer = new Timer();
		timer.schedule( 
		        new TimerTask() {
		            @Override
		            public void run() {
		                stopBonus();
		            }
		        }, 
		        delay 
		);
	}
	
	public void cancelBonus()
	{
		if(timer != null)
		{
			stopBonus();
			timer.cancel();
			timer.purge();
			timer = null;
		}
	}
	
	protected void stopBonus()
	{
		
	}
}

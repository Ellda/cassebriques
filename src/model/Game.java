package model;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/*import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;*/

import controller.BallController;
import controller.BarController;
import controller.BrickController;

/**
 * This class is the main model of the entire game.
 * GameController.java control this instance and the entire game.
 * 
 * @author Antoine Fonfria - 14 129 748
 * @author Baptiste Jaeckert 14 129 775
 * @author Jonathan Diaz-Muy 13 041 479
 * @author Adrien Burel 14 126 607
 * @author Landry Modeste Goutondji  14 000 626
 * @author J�r�my Collard 14 129 766
 * @author Mentor Bajraktari 14 129 757
 * @author Olivier Scheffler 12 179 288
 * @author Elliot G�mus-Pr�vost 13 111 198
 * @author Samuel Arseneault 13 161 801
 * @author Djenebou Monique Dembele 10 103 210
 * @author Florent Gargot 14 129 784
 */

public class Game {
	
	// Models and Controllers
	private Bar bar;
	private Ball ball;
	private BarController barController;
	private BallController ballController;
	private BrickController brickController;
	
	// Game properties
	private int life;
	private static int maxLife;
	
	
	

	

	public Game(int initLife){
		
		maxLife = initLife;
		life = initLife;
		
	}
	
	public int getMaxLife() {
		return maxLife;
	}

	public void setBar(Bar bar){
		this.bar = bar;
	}
	
	public void setBall(Ball ball){
		this.ball = ball;
	}
	
	
	
	public void setBarController(BarController barController){
		this.barController = barController;
	}
	
	public void setBallController(BallController ballController){
		this.ballController = ballController;
	}
	
	public void setBrickController(BrickController brickController){
		this.brickController = brickController;
	}
	
	public void setLife(int newLife){
		
		if(newLife >= -1)this.life = newLife;
	}
	
	

	public int getLife() {
		return life;
	}

	public Bar getBar(){
		return this.bar;
	}
	
	public Ball getBall(){
		return this.ball;
	}
	
	
	
	public BarController getBarController(){
		return this.barController;
	}
	
	public BallController getBallController(){
		return this.ballController;
	}
	
	public BrickController getBrickController(){
		return this.brickController;
	}
	
	/**
	 * Bonus method that plays a sound
	 * @param soundName
	 */
	public static void playSound(String soundName){
		Configuration cfg = new Configuration();
		if(cfg.isSon()){
			try {
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/"+soundName).getAbsoluteFile());
				Clip clip;
				try {
					clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

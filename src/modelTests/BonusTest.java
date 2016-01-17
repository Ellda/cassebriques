package modelTests;

import static org.junit.Assert.*;

import model.Ball;
import model.Bar;
import model.Bonus;
import model.Bonus_ballSpeed;
import model.Bonus_life;
import model.Bonus_points;
import model.Bonus_size;
import model.Game;
import view.MainFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.BrickController;

/**
 * The jUnit test case for Bonus.java, Bonus_ballSpeed.java, Bonus_points.java,
 * Bonus_life.java and Bonus_size.java
 * 
 * @author Nicolas Heldmaier
 */

public class BonusTest {


	private Ball ball;
	private Bar bar;
	private Game jeu;
	private BrickController brickController;
	
	MainFrame view;

	@Before
	public void setUp() throws Exception {
		ball = new Ball(30,40);
		bar = new Bar();	
		view  = new MainFrame();
		jeu = new Game(10);
		brickController = new BrickController(jeu, view);

		jeu.setBar(bar);
		jeu.setBall(ball);
		jeu.setBrickController(brickController);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBonus_life() {
		assertTrue(jeu.getLife() == 10);
		Bonus bonus = new Bonus_life(jeu);	
		bonus.launchBonus();
		assertTrue(jeu.getLife() == 11);
		bonus.launchBonus();
		assertTrue(jeu.getLife() == 12);		
	}

	@Test
	public void testBonus_ballSpeed() throws InterruptedException {
		double coef = jeu.getBall().getCoef();		
		Bonus_ballSpeed bonus = new Bonus_ballSpeed(jeu);
		double coeff = bonus.getCoeff();
		bonus.setDelay(100);
		bonus.launchBonus();
		assertTrue(jeu.getBall().getCoef() == coef/coeff);	
		Thread.sleep(200);
		assertTrue(jeu.getBall().getCoef() == coef);			
	}

	@Test
	public void testBonus_size() throws InterruptedException {
		double width = jeu.getBar().getWidth();		
		Bonus_size bonus = new Bonus_size(jeu);
		int addV = bonus.getAddValue();
		bonus.setDelay(100);
		bonus.launchBonus();
		assertTrue(jeu.getBar().getWidth() == width + addV);	
		Thread.sleep(200);
		assertTrue(jeu.getBar().getWidth() == width);			
	}

	@Test
	public void testBonus_points() throws InterruptedException {
		int lastPoints = jeu.getBrickController().getScore();		
		Bonus_points bonus = new Bonus_points(jeu);
		double coeff = bonus.getCoeff();
		bonus.setDelay(100);
		bonus.launchBonus();
		jeu.getBrickController().setScore(lastPoints + 1000);
		assertTrue(jeu.getBrickController().getScore() == lastPoints + 1000);	
		Thread.sleep(200);
		assertTrue(jeu.getBrickController().getScore() == lastPoints + coeff*1000);			
	}



}

package modelTests;
import model.Ball;
import model.Bar;
import model.Game;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.BallController;
import controller.BarController;
import controller.BrickController;
import controller.GameController;
import view.MainFrame;

/**
 * Unit Tests of Game
 * 
 * @author Antoine Fonfria - 14 129 748
 * @author Baptiste Jaeckert 14 129 775
 * @author Jonathan Diaz-Muy 13 041 479
 * @author Adrien Burel 14 126 607
 * @author Landry Modeste Goutondji  14 000 626
 * @author Jérémy Collard 14 129 766
 * @author Mentor Bajraktari 14 129 757
 * @author Olivier Scheffler 12 179 288
 * @author Elliot Gémus-Prévost 13 111 198
 * @author Samuel Arseneault 13 161 801
 * @author Djenebou Monique Dembele 10 103 210
 * @author Florent Gargot 14 129 784
 */

public class GameTest {

	private Ball ball;
	private Bar bar;
	private Game jeu;
	private BarController barController;
	private BallController ballController;
	private BrickController brickController;

	 GameController gm;
	 MainFrame view;
	@Before
	public void setUp() throws Exception {
		ball = new Ball(30,40);
		bar = new Bar();
		
		view  = new MainFrame();
		jeu = new Game(2);
		gm = new GameController(jeu, view);
		barController =new BarController(bar, view);
	 ballController = new BallController(ball, view);
		brickController = new BrickController(view);
	}

	@After
	public void tearDown() throws Exception {
		ball = null;
		bar = null;
		jeu = null;
	}
	
	@Test
	public void testGetLife(){
		 assertEquals(2, jeu.getLife());
	}
	
	@Test
	public void testGetMaxLife(){
		 assertEquals(2, jeu.getMaxLife());
	}

	@Test
	public void testGetBall(){
		 assertEquals(null, jeu.getBall());
	}

	@Test
	public void testGetBar(){
		 assertEquals(null, jeu.getBar());
	}

	@Test
	public void testChangeLife() {
		 
		 jeu.setLife(5);
		 
		 assertEquals(5, jeu.getLife());
		 
		 gm.decLife();
		
		 assertEquals(4, jeu.getLife()); 
		 
		 gm.incLife();
		 
		 assertEquals(5, jeu.getLife()); 
		 
		 // le nombre de vie ne peu pas dÃ©crementer nÃ©gativement.
		 for(int i = 0;i < 20;i++)gm.decLife();
		 
		 assertEquals(-1, jeu.getLife()); 
		 
		 jeu.setLife(-23);
		 
		 assertEquals(-1, jeu.getLife()); 
	}

	@Test
	public void testSetBar(){
		jeu.setBar(bar);
		assertTrue(jeu.getBar() != null);
	}
	
	@Test
	public void testSetBall(){
		jeu.setBall(ball);
		assertTrue(jeu.getBall() != null);
	}
	

	@Test
	public void testSetBarController(){
		jeu.setBarController(barController);
		assertTrue(jeu.getBarController() != null);
	}

	@Test
	public void testSetBallController(){
		jeu.setBallController(ballController);
		assertTrue(jeu.getBallController() != null);
	}

	@Test
	public void testSetBrickController(){
		jeu.setBrickController(brickController);
		assertTrue(jeu.getBrickController() != null);
	}
}

package controllerTests;

import static org.junit.Assert.*;
import model.Ball;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import view.MainFrame;
import controller.BallController;
import controller.Collision;

/**
 * Unit Tests of BallController.
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

public class BallControllerTest {

	private BallController ballController;
	private Ball ball;
	private MainFrame frame;
	@Before
	public void setUp() throws Exception {
		ball = new Ball();
		frame = new MainFrame();
		ballController = new BallController(ball, frame);
		new Collision(frame);

		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBallControler() throws Exception {
		setUp();
		testMoveX();
		testMoveY();
		tearDown();
	}
	
	@Test
	public void testMoveX(){
		ball.setX(50);
		ball.setSpeed(10);
		ball.setRadius(5);
		ball.setxDir(1);
		ballController.moveX();
		//X calculé selon les informations à la main
		double tempX = 57.071067811865476;
		assertEquals(tempX, ball.getX(), 3);
		
		ball.setxDir(-1);
		ballController.moveX();
		assertTrue(ball.getX() == 50 );
		
		ball.setX(6);
		ballController.moveX();
		assertTrue(ball.getxDir() == 1);
		//X calculé selon les informations à la main
		tempX = 0.9289321881345245;
		
		assertEquals(tempX, ball.getX(), 3);
		
		ball.setX(792);
		ball.setxDir(1);
		ballController.moveX();
		//X calculé selon les informations à la main
		tempX = 778.9289321881345;
		
		assertEquals(tempX, ball.getX(), 3);
	}
	
	@Test
	public void testMoveY(){
		ball.setY(50);
		ball.setAngle(30);
		ball.setSpeed(10);
		ball.setRadius(10);
		ball.setyDir(1);

		
		ballController.moveY();
		//Y calculé selon les informations à la main
		double tempY = 55;
		
		assertEquals(tempY, ball.getY(), 3);
		
		ball.setyDir(-1);
		ballController.moveY();
		assertTrue(ball.getY() == 50 );
		
		ball.setY(11);
		ballController.moveY();
		//Y calculé selon les informations à la main
		tempY = 9.464466094067262;
		
		assertEquals(tempY, ball.getY(), 3);
		
		ball.setY(587);
		ball.setyDir(1);
		ballController.moveY();
		//Y calculé selon les informations à la main
		tempY = 577.4644660940672;
		
		assertEquals(tempY, ball.getY(), 3);
	}
}

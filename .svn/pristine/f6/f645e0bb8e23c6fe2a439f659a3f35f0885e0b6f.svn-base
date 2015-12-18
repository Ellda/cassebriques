package modelTests;

import static org.junit.Assert.*;
import model.Ball;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit Tests of Ball
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

public class BallTest {

	private Ball ball;
	
	@Before
	public void setUp() throws Exception {
		ball = new Ball(30,40);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBallModel() throws Exception {
		
		// Test of setRadius() & getRadius()
		ball.setRadius(10);
		assertTrue(ball.getRadius() == 10);
		// Test of getX () & getY()
		assertTrue(ball.getX() == 30);
		assertTrue(ball.getY() == 40);
		
		// Test of setX()
		ball.setX(80);
		assertTrue(ball.getX() == 80);
		ball.setX(-18);
		assertTrue(ball.getX() == 80);
		ball.setX(900);
		assertTrue(ball.getX() == 80);
		ball.setX(801 - ball.getRadius());
		assertTrue(ball.getX() == 80 );
		
		// Test of setY()
		ball.setY(80);
		assertTrue(ball.getY() == 80);
		ball.setY(-18);
		assertTrue(ball.getY() == 80);
		ball.setY(900);
		assertTrue(ball.getY() == 80);
		
		// Test of setSpeed() & getSpeed()
		ball.setSpeed(80);
		assertTrue(ball.getSpeed() == 80);

		// Test of setxDir() & getxDir()
		ball.setxDir(1);
		assertTrue(ball.getxDir() == 1);
		ball.setxDir(-1);
		assertTrue(ball.getxDir() == -1);
		ball.setxDir(30);
		assertTrue(ball.getxDir() == -1);
		
		// Test of setyDir() & getyDir()
		ball.setyDir(1);
		assertTrue(ball.getyDir() == 1);
		ball.setyDir(-1);
		assertTrue(ball.getyDir() == -1);
		ball.setyDir(0);
		assertTrue(ball.getyDir() == -1);
		
	}
	
	@Test
	public void test_BallAlive(){
		assertTrue(ball.getAlive());
		ball.killBall();
		assertFalse(ball.getAlive());
	}

	@Test
	public void test_getCordinates(){
		assertTrue(Math.abs(ball.getyBottom() - (ball.getY() + ball.getRadius())) < 0.000001);
		assertTrue(Math.abs(ball.getxRight() - (ball.getX() + ball.getRadius())) < 0.000001);
		assertTrue(Math.abs(ball.getyTop() - (ball.getY() - ball.getRadius())) < 0.000001);
		assertTrue(Math.abs(ball.getxLeft() - (ball.getX() - ball.getRadius())) < 0.000001);
		assertTrue(ball.getXInt() == (int)ball.getX());
		assertTrue(ball.getYInt() == (int)ball.getY());
	}

	@Test
	public void test_changeAngleFromPercentage(){
		ball.changeAngleFromPercentage(100);
		assertTrue( ball.getAngle()== Math.toRadians(30));
	}
	
	@Test
	public void test_calcFutureX(){
		ball.setX(100);
		ball.setAngle(60);
		
		assertTrue(ball.calcFutureX()==103.5);
	}
	
	@Test
	public void test_calcFutureY(){
		ball.setY(100);
		ball.setAngle(30);
		
		assertTrue(ball.calcFutureY()==96.5);
	}
	
}

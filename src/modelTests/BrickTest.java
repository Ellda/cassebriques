package modelTests;

import static org.junit.Assert.*;
import model.Brick;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit Tests of Brick
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

public class BrickTest {

	private Brick brick;
	
	
	@Before
	public void setUp() throws Exception {
		brick = new Brick();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBallModel() throws Exception {
		
		
		
	}
	
	@Test
	public void test_SetX(){
		brick.setX(50);
		assertTrue(brick.getX() == 50);
	}

	@Test
	public void test_SetY(){
		brick.setY(50);
		assertTrue(brick.getY() == 50);
	}

	@Test
	public void testSetBrickPointValue(){
		brick.setBrickPointValue(20);
		assertTrue(brick.getBrickPointValue() == 20);
	}

	@Test
	public void testBrickState(){
		brick.kill();
		assertTrue(brick.isDead());
		brick.revive();
		assertFalse(brick.isDead());
	}
}

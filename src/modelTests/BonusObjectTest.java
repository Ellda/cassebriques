package modelTests;

import model.BonusObject;
//import model.Game;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BonusObjectTest
{
	private static final double EPSILON = 1e-5;

	@Before
	public void setUp() throws Exception {
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testConstructors() {
		BonusObject bo = new BonusObject(1,2,3,4,5,6);
		assertEquals(bo.getType(), 1, EPSILON);
		assertEquals(bo.getX(), 2, EPSILON);
		assertEquals(bo.getY(), 3, EPSILON);
		assertEquals(bo.getSpeed(), 4, EPSILON);
		assertEquals(bo.getDir(), 5, EPSILON);
		assertEquals(bo.getSize(), 6, EPSILON);
		
		// Default size: 16
		bo = new BonusObject(1,2,3,4,5);
		assertEquals(bo.getType(), 1, EPSILON);
		assertEquals(bo.getX(), 2, EPSILON);
		assertEquals(bo.getY(), 3, EPSILON);
		assertEquals(bo.getSpeed(), 4, EPSILON);
		assertEquals(bo.getDir(), 5, EPSILON);
		assertEquals(bo.getSize(), 16, EPSILON);

		// Default direction: PI/2 (bottom)
		bo = new BonusObject(1,2,3,4);
		assertEquals(bo.getType(), 1, EPSILON);
		assertEquals(bo.getX(), 2, EPSILON);
		assertEquals(bo.getY(), 3, EPSILON);
		assertEquals(bo.getSpeed(), 4, EPSILON);
		assertEquals(bo.getDir(), Math.PI / 2, EPSILON);
		assertEquals(bo.getSize(), 16, EPSILON);

		// Default speed: 3
		bo = new BonusObject(1,2,3);
		assertEquals(bo.getType(), 1, EPSILON);
		assertEquals(bo.getX(), 2, EPSILON);
		assertEquals(bo.getY(), 3, EPSILON);
		assertEquals(bo.getSpeed(), 3, EPSILON);
		assertEquals(bo.getDir(), Math.PI / 2, EPSILON);
		assertEquals(bo.getSize(), 16, EPSILON);
	}

	@Test
	public void testSetters() {
		BonusObject bo = new BonusObject(1,2,3,4,5,6);
		bo.setX(10);
		assertEquals(bo.getX(), 10, EPSILON);
		bo.setY(11);
		assertEquals(bo.getY(), 11, EPSILON);
		bo.setSpeed(12);
		assertEquals(bo.getSpeed(), 12, EPSILON);
		bo.setDir(13);
		assertEquals(bo.getDir(), 13, EPSILON);
		bo.setSize(14);
		assertEquals(bo.getSize(), 14, EPSILON);
	}
}

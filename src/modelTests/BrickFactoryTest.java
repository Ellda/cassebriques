package modelTests;

import static org.junit.Assert.*;
import model.BrickFactory;
import model.Game;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The jUnit test case for BrickFactory.java
 * 
 * @author Antoine Fonfria
 */

public class BrickFactoryTest {
	
	private Game gameTest;

	@Before
	public void setUp() throws Exception {
		// Necessary game instance
		this.gameTest = new Game(10);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBrickFactoryGame() {
		BrickFactory defBF = new BrickFactory(gameTest);
		
		assertTrue(defBF.getBonusRate() == 10);
		assertTrue(defBF.getStrongRate() == 20);
		assertTrue(defBF.getStrongMaxResistance() == 3);
	}

	@Test
	public void testBrickFactoryGameIntIntInt() {
		BrickFactory manBF = new BrickFactory(gameTest, 12, 24, 32);
		
		assertTrue(manBF.getBonusRate() == 12);
		assertTrue(manBF.getStrongRate() == 24);
		assertTrue(manBF.getStrongMaxResistance() == 32);
	}

	@Test
	public void testMakeBrick() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetBonusRate() {
		BrickFactory BF = new BrickFactory(gameTest);
		
		// Normal value
		BF.setBonusRate(52);
		assertTrue(BF.getBonusRate() == 52);
		
		// Forbidden value (>100)
		BF.setBonusRate(103);
		assertFalse(BF.getBonusRate() == 103);
		
		// Forbidden value (<0)
		BF.setBonusRate(-5);
		assertFalse(BF.getBonusRate() == -5);
	}

	@Test
	public void testSetStrongRate() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetStrongMaxResistance() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetBonusRate() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetStrongRate() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetStrongMaxResistance() {
		//fail("Not yet implemented");
	}

}

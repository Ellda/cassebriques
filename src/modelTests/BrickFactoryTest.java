package modelTests;

import static org.junit.Assert.*;
import model.Brick;
import model.BrickFactory;
import model.Brick_bonus;
import model.Brick_strong;
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
		// This test will measure a random return based on percentages.
		// It will then be run n times and the result tested will be statistics
		// Those statistics are the proportions of type of returns expected according to the proportions gave in the declaration of the BrickFactory.
		
		// Number of occurences
		int n = 10000;
		
		// Test 1 : Identical proportions
		BrickFactory BF1 = new BrickFactory(gameTest, 33, 33, 10);
		int[] bCounter1 = {0, 0, 0};
		for(int t = 0; t < n; t++){
			Brick b = BF1.makeBrick(1, 1);
			if(b instanceof Brick_bonus)
				bCounter1[0]++;
			else if(b instanceof Brick_strong)
				bCounter1[1]++;
			else
				bCounter1[2]++;
		}
		// On autorise une erreur statistique de 6%
		assertTrue(bCounter1[0] >= n * 0.30 && bCounter1[0] <= n * 0.36);
		assertTrue(bCounter1[1] >= n * 0.30 && bCounter1[1] <= n * 0.36);
		assertTrue(bCounter1[2] >= n * 0.30 && bCounter1[2] <= n * 0.36);
		
		
		// Test 2 : Proportions limites : nulles
		BrickFactory BF2 = new BrickFactory(gameTest, 0, 0, 10);
		int[] bCounter2 = {0, 0, 0};
		for(int t = 0; t < n; t++){
			Brick b = BF2.makeBrick(1, 1);
			if(b instanceof Brick_bonus)
				bCounter2[0]++;
			else if(b instanceof Brick_strong)
				bCounter2[1]++;
			else
				bCounter2[2]++;
		}
		assertTrue(bCounter2[0] == 0);
		assertTrue(bCounter2[1] == 0);
		assertTrue(bCounter2[2] == n);
		
		
		// Test 3 : Proportions limites : 100, 0
		BrickFactory BF3 = new BrickFactory(gameTest, 100, 0, 10);
		int[] bCounter3 = {0, 0, 0};
		for(int t = 0; t < n; t++){
			Brick b = BF3.makeBrick(1, 1);
			if(b instanceof Brick_bonus)
				bCounter3[0]++;
			else if(b instanceof Brick_strong)
				bCounter3[1]++;
			else
				bCounter3[2]++;
		}
		assertTrue(bCounter3[0] == n);
		assertTrue(bCounter3[1] == 0);
		assertTrue(bCounter3[2] == 0);
		

		// Test 3 : Proportions normales
		BrickFactory BF4 = new BrickFactory(gameTest, 12, 25, 10);
		int[] bCounter4 = {0, 0, 0};
		for(int t = 0; t < n; t++){
			Brick b = BF4.makeBrick(1, 1);
			if(b instanceof Brick_bonus)
				bCounter4[0]++;
			else if(b instanceof Brick_strong)
				bCounter4[1]++;
			else
				bCounter4[2]++;
		}
		// On autorise une erreur statistique de 6%
		assertTrue(bCounter4[0] >= n * 0.09 && bCounter4[0] <= n * 0.15);
		assertTrue(bCounter4[1] >= n * 0.22 && bCounter4[1] <= n * 0.28);
		assertTrue(bCounter4[2] >= n * 0.60 && bCounter4[2] <= n * 0.66);
	}

	@Test
	public void testSetGetBonusRate() {
		BrickFactory BF = new BrickFactory(gameTest);
		
		// Normal value
		BF.setBonusRate(52);
		assertTrue(BF.getBonusRate() == 52);

		// Limit values (0, 100)
		BF.setBonusRate(0);
		assertTrue(BF.getBonusRate() == 0);
		BF.setBonusRate(100);
		assertTrue(BF.getBonusRate() == 100);
		
		// Forbidden value (>100)
		BF.setBonusRate(103);
		assertFalse(BF.getBonusRate() == 103);
		
		// Forbidden value (<0)
		BF.setBonusRate(-5);
		assertFalse(BF.getBonusRate() == -5);
	}

	@Test
	public void testSetGetStrongRate() {
		BrickFactory BF = new BrickFactory(gameTest);
		
		// Normal value
		BF.setStrongRate(10);
		assertTrue(BF.getStrongRate() == 10);
		
		// Limit values (0, 100)
		BF.setStrongRate(0);
		assertTrue(BF.getStrongRate() == 0);
		BF.setStrongRate(100);
		assertTrue(BF.getStrongRate() == 100);
		
		// Forbidden value (>100)
		BF.setStrongRate(210);
		assertFalse(BF.getStrongRate() == 210);
		
		// Forbidden value (<0)
		BF.setStrongRate(-26);
		assertFalse(BF.getStrongRate() == -26);
	}

	@Test
	public void testSetGetStrongMaxResistance() {
		BrickFactory BF = new BrickFactory(gameTest);
		
		// Normal values
		BF.setStrongMaxResistance(7);
		assertTrue(BF.getStrongMaxResistance() == 7);
		BF.setStrongMaxResistance(59856);
		assertTrue(BF.getStrongMaxResistance() == 59856);
		
		// Limit value (1)
		BF.setStrongMaxResistance(1);
		assertTrue(BF.getStrongMaxResistance() == 1);
		
		// Forbidden values (<=0)
		BF.setStrongMaxResistance(0);
		assertFalse(BF.getStrongMaxResistance() == 0);
		BF.setStrongMaxResistance(-58);
		assertTrue(BF.getStrongMaxResistance() != 58);
		
	}

}

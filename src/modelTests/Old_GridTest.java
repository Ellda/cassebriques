package modelTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import model.Brick;
import model.Grid;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit Tests of Grid
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

public class Old_GridTest {

	private Grid grid ;
	private Brick brick ;
	
	@Before
	public void setUp() throws Exception {
		grid = Grid.getInstance() ;
		brick = new Brick(1, 1, 10) ;
	}

	@After
	public void tearDown() throws Exception {
		grid = null ;
		
	}

	@Test
	public void testBrickControler() {		
		grid.setNbCasesX(8) ;
		assertTrue(grid.getNbCasesX() == 8) ;
		grid.setNbCasesY(2) ;
		assertTrue(grid.getNbCasesY() == 2) ;
		
		grid.setNbCasesX(-2);
		assertFalse(grid.getNbCasesY() == -2) ;
		grid.setNbCasesY(-8);
		assertFalse(grid.getNbCasesY() == -8) ;
		
		grid.setNbCasesX(0);
		assertFalse(grid.getNbCasesY() == 0) ;
		grid.setNbCasesY(0);
		assertFalse(grid.getNbCasesY() == 0) ;
		
		grid.setNbCasesX(2);
		grid.setNbCasesY(2);
		assertTrue(grid.getXLeftFromBrick(brick) == 400);
		assertTrue(grid.getYTopFromBrick(brick) == 200);
	}
	
	@Test
	public void testGetInstance()
	{
		Grid instance = Grid.getInstance();
		assertTrue(grid == instance);
	}
	
	@Test
	public void testGetYBottomFromBrick()
	{
		assertTrue(grid.getYBottomFromBrick(brick) == 80);
	}
	
	@Test
	public void testGetXRightFromBrick()
	{
		assertTrue(grid.getXRightFromBrick(brick) == 160);
	}

	@Test
	public void testIsWithinRangeX()
	{
		grid.setNbCasesX(10);
		assertTrue(grid.isWithinRangeX(brick, 100, 140));
		assertFalse(grid.isWithinRangeX(brick, 170, 200));
		assertFalse(grid.isWithinRangeX(brick, 20, 70));
		assertFalse(grid.isWithinRangeX(brick, 200, 50));
	}

	@Test
	public void testIsWithinRangeY()
	{
		grid.setNbCasesY(10);
		assertTrue(grid.isWithinRangeY(brick, 50, 70));
		assertFalse(grid.isWithinRangeY(brick, 85, 100));
		assertFalse(grid.isWithinRangeY(brick, 10, 35));
		assertFalse(grid.isWithinRangeY(brick, 100, 25));
	}
}

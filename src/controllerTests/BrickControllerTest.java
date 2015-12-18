package controllerTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Brick;
import model.Grid;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import view.MainFrame;
import controller.BrickController;

/**
 * Unit Tests of BrickController
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

public class BrickControllerTest {
	private BrickController brickController ;
	private MainFrame mainFrame ;
	private ArrayList<Brick> listOfBrick;
	
	private ArrayList<Brick> listOfBricks;
	private Grid grid ;
	
	@Before
	public void setUp() throws Exception {
		mainFrame = new MainFrame() ;
		grid = Grid.getInstance() ;
		brickController = new BrickController(mainFrame);
	}

	@After
	public void tearDown() throws Exception {
		mainFrame = null ;
		brickController = null ;
	}

	@Test
	public void testDeBrickControler() {
		brickController.setBricksSquare();
		listOfBrick = brickController.getlistOfBricks_alive();
		assertFalse(listOfBrick.get(0) == null);
		assertTrue(listOfBrick.size() == ((grid.getNbCasesX()- 2)*(grid.getNbCasesY() - 4))) ;
		assertTrue(listOfBrick.get(listOfBrick.size() - 1).getX() == grid.getNbCasesX() - 2) ;
		assertTrue(listOfBrick.get(listOfBrick.size() - 1).getY() == grid.getNbCasesY() - 4) ;
		
	}
	
	@Test
	public void testDestructionReconstruction(){
		
		Brick brique = new Brick();
		listOfBricks = new ArrayList<Brick>();
		listOfBricks.add(brique);
		assertEquals(1, listOfBricks.size());
	
		brickController.setBricksSquare();
		listOfBricks = brickController.getlistOfBricks_alive();
		assertEquals(((grid.getNbCasesX()- 2)*(grid.getNbCasesY() - 4)), listOfBricks.size());
		
		brickController.removeAllBricks();
		assertTrue(listOfBricks.size() == 0) ;
		
		brickController.setBricksSquare();	
		assertEquals(((grid.getNbCasesX()- 2)*(grid.getNbCasesY() - 4)), listOfBricks.size());	
	}


}

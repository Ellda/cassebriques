package controllerTests;

import static org.junit.Assert.*;

import java.util.List;

import model.BonusObject;
import model.Game;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import view.MainFrame;
import controller.BonusObjectController;

public class BonusObjectControllerTest
{
	private static final double EPSILON = 1e-5;
	private Game game;
	private MainFrame mainFrame;
	private BonusObjectController boc;
	
	@Before
	public void setUp() throws Exception {
		game = new Game(10);
		mainFrame = new MainFrame() ;
		boc = new BonusObjectController(game, mainFrame);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testBonusObjectManagement() {
		List<BonusObject> bol = mainFrame.getBonusObjectsList();
		boc.clearBonusObjects();
		boc.createBonusObject(5, 20, 30);
		BonusObject bo = new BonusObject(3, 10, 10);
		boc.addBonusObject(bo);
		assertEquals(bol.size(), 2);
		assertTrue(bol.indexOf(bo) > -1);
		boc.removeBonusObject(bo);
		assertEquals(bol.size(), 1);
		boc.clearBonusObjects();
		assertEquals(bol.size(), 0);
	}
	
	@Test
	public void testRefresh() {
		List<BonusObject> bol = mainFrame.getBonusObjectsList();
		boc.clearBonusObjects();
		BonusObject bo1 = new BonusObject(2, 5, 5);
		BonusObject bo2 = new BonusObject(3, 10, 10, 5, 0);
		BonusObject bo3 = new BonusObject(3, 1, 15, 12, Math.PI, 10);
		boc.addBonusObject(bo1);
		boc.addBonusObject(bo2);
		boc.addBonusObject(bo3);
		boc.refresh();
		// bo3 se retrouve en dehors de la fenêtre
		assertTrue(bol.indexOf(bo3) == -1);
		// bo2 : direction 0 = déplacement vers la droite de 5px par rafraichissement
		assertEquals(bo2.getY(), 10, EPSILON);
		assertEquals(bo2.getX(), 15, EPSILON);
		// bo1 : Vitesse par défaut : 3, vers le bas
		assertEquals(bo1.getY(), 8, EPSILON);
		assertEquals(bo1.getX(), 5, EPSILON);
	}
}

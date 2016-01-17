package modelTests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.Configuration;

public class ConfigurationTest {
	private Configuration config;
	private Configuration configSav;

	
	@Before
	public void setUp() throws Exception {
		config = new Configuration();
		configSav = new Configuration(config); // backup de la config actuelle
	}

	@After
	public void tearDown() throws Exception {
		configSav.save();
	}

	@Test
	public void testImportFileDefault() {	
		config.defaultConfig();
		assertEquals(37, config.getGauche());
		assertEquals(39, config.getDroite());
		assertEquals(27, config.getQuitter());
		assertTrue(config.isSon());
	}
	
	@Test
	public void testSetGetGauche() {		
		
		config.setGauche(1);
		assertEquals(1, config.getGauche());
	}
	
	@Test
	public void testSetGetDroite() {		
		config.setDroite(2);
		assertEquals(2, config.getDroite());
	}

	@Test
	public void testSetGetQuitter() {		
		config.setQuitter(3);
		assertEquals(3, config.getQuitter());
	}
	
	@Test
	public void testSetGetNegatif() {		
		config.setGauche(124);
		assertEquals(124, config.getGauche());
		config.setGauche(-3);
		assertEquals(124, config.getGauche());

	}
	
	@Test
	public void testSetGetSon() {		
		config.setSon(true);
		assertTrue(config.isSon());
		config.setSon(false);
		assertFalse(config.isSon());
	}
	
	@Test
	public void testSave() {
		config.setGauche(1);
		config.setDroite(2);
		config.setQuitter(3);
		config.setSon(true);
		try {
			config.save();
		} catch (IOException | URISyntaxException e) {
			fail("sauvegarde impossible");
		}
		
		Configuration  cfgNew = new Configuration();
		assertEquals(1, cfgNew.getGauche());

		assertEquals(2, cfgNew.getDroite());
		assertEquals(3, cfgNew.getQuitter());
		assertTrue(cfgNew.isSon());
		
		cfgNew.setGauche(4);
		cfgNew.setDroite(5);
		cfgNew.setQuitter(6);
		cfgNew.setSon(false);
		try {
			cfgNew.save();
		} catch (IOException | URISyntaxException e) {
			fail("sauvegarde impossible");
		}
		
		Configuration  cfgNewNew = new Configuration();
		assertEquals(4, cfgNewNew.getGauche());

		assertEquals(5, cfgNewNew.getDroite());
		assertEquals(6, cfgNewNew.getQuitter());
		assertFalse(cfgNewNew.isSon());
		

		
	}
		
}

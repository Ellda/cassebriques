package controllerTests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.FichierCSV;

public class FichierCSVTest {

	private FichierCSV fichier;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWriteAndReplaceAndRead() {
		fichier = new FichierCSV("test/test.csv");
		List<String> liste = new ArrayList<>();
		List<String> liste2 = null;
		liste.add(Long.toHexString(Double.doubleToLongBits(Math.random())));
		liste.add(Long.toHexString(Double.doubleToLongBits(Math.random())));
		liste.add(Long.toHexString(Double.doubleToLongBits(Math.random())));
		try {
			fichier.writeAndReplace(liste);
		} catch (IOException | URISyntaxException e) {
			fail("sauvegarde impossible");
		}
		try {
			 liste2 = fichier.readAll();
		} catch (IOException | URISyntaxException e) {
			fail("lecture impossible");
		}
		assertEquals(liste.get(0), liste2.get(0));
		assertEquals(liste.get(1), liste2.get(1));
		assertEquals(liste.get(2), liste2.get(2));
		
	}

	@Test(expected=IOException.class)
	public void testReadFail() throws IOException, URISyntaxException {
		fichier = new FichierCSV("inexistant.csv");
		fichier.readAll();
		
		fail("lecture théoriquement impossible");
	}

}

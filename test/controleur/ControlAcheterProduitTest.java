package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private Chef abraracourcix;
	@BeforeEach
	public void initSitu() {
		System.out.println("Initialisation");
		village = new Village("le village des irréductibles",10,5);
		abraracourcix = new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
		Gaulois julie = new Gaulois("Julie",10);
		village.ajouterHabitant(julie);
		village.installerVendeur(julie, "fleurs", 10);
	}
	@Test
	void testAcheterProduit() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur,village);
		assertEquals(5,controlAcheterProduit.acheterProduit("Julie", 5, "fleurs"));
		assertEquals(-1,controlAcheterProduit.acheterProduit("Julie", 5, "bonbon"));
		assertEquals(-1,controlAcheterProduit.acheterProduit("random", 5, "fleurs"));
	}
	@Test
	void testVendeurProd() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur,village);
		assertNotNull(controlAcheterProduit.vendeurProd("fleurs"));
	}
	@Test
	void testEstPresent() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur,village);
		assertTrue(controlAcheterProduit.estPresent("fleurs"));
		assertFalse(controlAcheterProduit.estPresent("bonbon"));
	}
	@Test
	void testQttVendProd() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur,village);
		assertEquals(10,controlAcheterProduit.qttVendProd("Julie"));
	}
}

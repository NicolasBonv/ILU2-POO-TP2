package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private ControlVerifierIdentite controlVerifierIdentite;
	private Village village;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initSitu() {
		System.out.println("Initialisation");
		village = new Village("le village des irréductibles",10,5);
		abraracourcix = new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
	}
	@Test
	void testResteEtals() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
		assertTrue(controlPrendreEtal.resteEtals());
		controlPrendreEtal.prendreEtal("1", null, 0);
		controlPrendreEtal.prendreEtal("2", null, 0);
		controlPrendreEtal.prendreEtal("3", null, 0);
		controlPrendreEtal.prendreEtal("4", null, 0);
		controlPrendreEtal.prendreEtal("5", null, 0);
		assertFalse(controlPrendreEtal.resteEtals());
	}
	@Test
	void testPrendreEtal() {
		Gaulois julie = new Gaulois("Julie",10);
		village.ajouterHabitant(julie);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
		assertEquals(0,controlPrendreEtal.prendreEtal("Julie", null, 0));
	}
	@Test
	void testVerifierIdentite() {
		Gaulois julie = new Gaulois("Julie",10);
		village.ajouterHabitant(julie);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
		assertTrue(controlPrendreEtal.verifierIdentite("Julie"));
		assertFalse(controlPrendreEtal.verifierIdentite("random"));
	}

}

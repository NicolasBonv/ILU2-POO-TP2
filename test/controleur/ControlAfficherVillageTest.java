package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
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
		village.installerVendeur(julie, null, 0);
	}
	
	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		String[] nomVillageois = controlAfficherVillage.donnerNomsVillageois();
		assertEquals("Abraracourcix",nomVillageois[0]);
		assertEquals("Julie",nomVillageois[1]);
	}
	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals("le village des irréductibles",controlAfficherVillage.donnerNomVillage());
		assertNotEquals(null,controlAfficherVillage.donnerNomVillage());
	}
	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals(5,controlAfficherVillage.donnerNbEtals());
	}

}

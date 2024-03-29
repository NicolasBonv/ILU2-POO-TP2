package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
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
	void testTrouverEtalVendeur() {
		Gaulois julie = new Gaulois("Julie",10);
		village.ajouterHabitant(julie);
		village.installerVendeur(julie, null, 0);
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur("Julie"));
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("random"));
	}

}

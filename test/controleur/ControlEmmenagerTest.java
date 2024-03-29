package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initSitu() {
		System.out.println("Initialisation");
		village = new Village("le village des irr�ductibles",10,5);
		abraracourcix = new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
	}
	@Test
	void testControlEmmenager() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		assertNotNull(controlEmmenager,"Contruscteur ne renvoie pas null");
	}
	
	@Test
	void testIsHabitant() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
		assertFalse(controlEmmenager.isHabitant("tki"));
		
		
	}
	
}
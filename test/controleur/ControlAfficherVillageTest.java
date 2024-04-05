package controleur;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ResourceBundle.Control;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {

	private Village village;
	private Chef abraracourcix;
	private Gaulois villageois;
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		villageois = new Gaulois("hab", 10);
	}
	
	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage,"constructeur ne renvois pas null");
	}
	
	@Test
	void donerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("hab", 10);
		assertEquals("[Abraracourcix, hab]", Arrays.toString(controlAfficherVillage.donnerNomsVillageois()));
		assertNotEquals(" ", controlAfficherVillage.donnerNomsVillageois());
	}
	
	@Test
	void donnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals("le village des irréductibles", controlAfficherVillage.donnerNomVillage());
		assertNotEquals("random",controlAfficherVillage.donnerNomVillage());
	}

	@Test
	void donnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals(5, controlAfficherVillage.donnerNbEtals());
		assertNotEquals(4, controlAfficherVillage.donnerNbEtals());
	}
	
}

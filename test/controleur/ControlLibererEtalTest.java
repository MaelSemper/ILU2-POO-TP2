package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {

	private Village village;
	private Chef abraracourcix;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private Gaulois vendeur;
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		vendeur = new Gaulois("vendeur",10);
		village.setChef(abraracourcix);
		controlTrouverEtalVendeur  = new ControlTrouverEtalVendeur(village);
	}
	
	@Test
	void testControlLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(controlLibererEtal, "constructeur ne renvoie pas null");
	}
	 
	@Test
	void testIsVendeur() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite , village);
		
		controlEmmenager.ajouterGaulois("vendeur", 10);
		controlPrendreEtal.prendreEtal("vendeur", "pommes", 10);
 
		assertTrue(controlLibererEtal.isVendeur(vendeur.getNom())); 
		assertFalse(controlLibererEtal.isVendeur("personne"));
	}

	@Test
	void LibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite , village);
		
		controlEmmenager.ajouterGaulois("vendeur", 10);
		controlPrendreEtal.prendreEtal("vendeur", "pommes", 10);
 
		assertNotNull(controlLibererEtal.libererEtal("vendeur"));
		assertNull(controlLibererEtal.libererEtal("personne"));
	}
}

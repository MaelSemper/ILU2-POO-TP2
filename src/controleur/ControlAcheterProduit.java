package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	//TODO a completer
	public Gaulois[] rechercherProduit(String nomProduit) {
		return village.rechercherVendeursProduit(nomProduit);
	}
	
	public Gaulois rechercherVendeur(String nomAcheteur) {
		return village.trouverHabitant(nomAcheteur);
	}
	
	private Etal rechercherEtal(Gaulois vendeur) {
		return village.rechercherEtal(vendeur);
	}
	
	public void acheterPrduit(Gaulois vendeur, int qt) {
		rechercherEtal(vendeur).acheterProduit(qt);
	}
	
}

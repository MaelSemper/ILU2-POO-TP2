package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (controlPrendreEtal.verifierIdentite(nomVendeur)) {
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolée " + nomVendeur + "je n'ai plus d'étal qui ne soit pas occupé.");
			} else {
				installerVendeur(nomVendeur);
			}
		}
		else {
			System.out.println("Je suis désolé "+nomVendeur+" mais il faut être un habitant de notre village pour commercer ici");
		}

	}

	private void installerVendeur(String nomVendeur) {
		System.out.println(
				"C'est parfait il me reste un étal pour vous !\nIl me faudrait quelques renseignement :\n Quel produit souhaiteriez-vous vendre ?");
		String produit = scan.next();
		System.out.println("Combien souhaitez-vous en vendre ?");
		int nProduit = scan.nextInt();
		int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nProduit);
		if (numEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + numEtal);
		}
	}
}

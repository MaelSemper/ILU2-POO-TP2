package frontiere;

import java.util.Scanner;
import controleur.ControlAcheterProduit;
import controleur.ControlVerifierIdentite;
import personnages.Gaulois;
import villagegaulois.Village;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;
	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		System.out.println("Quel produit voulez-vous acheter ?\n");
		String produit = scan.next();

		Gaulois[] marchand = controlAcheterProduit.trouverMarchand(produit);

		if (marchand == null) {
			System.out.println("D�sol�, personne ne vend ce produit au march�.\n");
		} else {
			System.out.println("Chez quel commer�ant voulez-vous acheter des " + produit + " ?\n");

			StringBuilder afficheMarchand = new StringBuilder();
			StringBuilder messageAcheteur = new StringBuilder();

			for (int i = 1; i <= marchand.length; i++) {
				afficheMarchand.append(i + " - ");
				afficheMarchand.append(marchand[i - 1].getNom() + "\n");
			}
			int nbVendeur = 0;

			do {
				nbVendeur = Clavier.entrerEntier(afficheMarchand.toString());
			} while (nbVendeur < 1 || nbVendeur > (marchand.length));
			String nomVendeur = marchand[nbVendeur - 1].getNom();

			messageAcheteur.append("Panoramix se d�place jusqu'� l'�tal du vendeur ");
			messageAcheteur.append(nomVendeur + "\n");
			messageAcheteur.append("Bonjour " + nomAcheteur + "\n");
			messageAcheteur.append("Combien de ");
			messageAcheteur.append(produit);
			messageAcheteur.append(" voulez-vous acheter ?");

			int quantite = Clavier.entrerEntier(messageAcheteur.toString());
			int produitVendu = controlAcheterProduit.acheterProduit(nomVendeur, quantite);
			if(produitVendu == -1) {
				System.out.println("je suis desole, seul les habitants du Village peuvent vendere sur le march�");
			}
			else if (produitVendu == quantite) {
				System.out.println(nomAcheteur + " ach�te " + quantite + " " + produit + " � " + nomVendeur);
			} else if (produitVendu == 0) {
				System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit
						+ ", malheureusement il n'y en a plus !\n");
			} else {
				System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheureusement "
						+ nomVendeur + " n�en a plus que " + produitVendu + ". " + nomAcheteur
						+ " ach�te tout le stock de " + nomVendeur + ".\n");
			}
		}
	}
}
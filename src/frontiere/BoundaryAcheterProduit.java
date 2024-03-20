package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	
	public void acheterProduit(String nomAcheteur) {
		// TODO Ã  completer
		StringBuilder outPut = new StringBuilder();

		outPut.append("Quel produit voulez-vous achetez ?");
		String input = scan.nextLine();
		if(controlAcheterProduit.rechercherProduit(input)==null) {
			outPut.append("Aucune etal ne vend ce produit");
			return;
		}
		
		outPut.append("Chez quel commerçant voulez-vous acheter des ");
		outPut.append(input);
		input = scan.nextLine();
		Gaulois vendeur = controlAcheterProduit.rechercherVendeur(input);
		if(vendeur == null) {
			outPut.append(vendeur);
			outPut.append(" ne fait pas partis du village et ne peut donc pas vendre sur le marché");
			return;
		}
			
	//si le vendeur vend le produit demander quantité
		
	}
}

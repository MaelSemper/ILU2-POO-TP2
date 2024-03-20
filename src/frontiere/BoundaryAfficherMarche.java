package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] data = controlAfficherMarche.donnerInfosMarche();
		if (data.length == 0) {
			System.out.println("Le marché est vide, reveez plus tard");
		} else {
			System.out.println(nomAcheteur + " vous trouverez au marché :\n");
			StringBuilder outPut = new StringBuilder();
			for (int i = 0; i < data.length; i += 3) {

				outPut.append("-");
				outPut.append(data[i]);
				outPut.append(" qui vend ");
				outPut.append(data[i + 1]);
				outPut.append(" ");
				outPut.append(data[i + 2]);
				outPut.append(".\n");

			}
			outPut.toString();
		}
	}
}

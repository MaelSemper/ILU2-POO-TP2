package frontiere;

import controleur.ControlLibererEtal;
import villagegaulois.Etal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		//TODO a completer
		if(controlLibererEtal.isVendeur(nomVendeur)) {
			
			String[] etal = controlLibererEtal.libererEtal(nomVendeur);
			
			StringBuilder outPut = new StringBuilder();
			outPut.append("Vous avez vendu ");
			outPut.append(etal[4]);
			outPut.append(" sur ");
			outPut.append(etal[3]);
			outPut.append(" ");
			outPut.append(etal[2]);
			outPut.append(".\n");
			outPut.toString();
		}
		else {System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui");}
	}

}

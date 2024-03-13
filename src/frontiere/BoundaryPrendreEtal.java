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
		if(!(controlPrendreEtal.verifierIdentite(nomVendeur)))
			System.out.println("Je suis désolé "+nomVendeur+" mais il faut être habitant de notre village");
		else {
			System.out.println("Bonjour "+nomVendeur+" je sais regarder si je peux vous trouver un etal");
			if(!(controlPrendreEtal.resteEtals()))
				System.out.println("Désolé "+nomVendeur+" je n'ai plus d'etal qui ne soit pas déjà occupé");
			else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait il me reste un etal");
		System.out.println("Il me faudrait quelques renseignements");
		System.out.println("Quel produit souhtaiez-vous vendre ?");
		String prod = scan.next();
		int nbProd =  Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
		int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, prod, nbProd);
		if (numEtal != -1 )
			System.out.println("Le vendeur "+nomVendeur+" s'est bien installé à l'étal n "+numEtal);
	}
}

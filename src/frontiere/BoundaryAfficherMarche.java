package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] marche = controlAfficherMarche.donnerInfosMarche();
		if(marche.length == 0)
			System.out.println("Le marché est vide comeback later");
		else {
			System.out.println(nomAcheteur+" vous trouverez au marché : ");
			int i=0;
			while (marche[i] != null) {
				System.out.println(" - "+marche[i++]+" qui vend "+marche[i++]+" "+marche[i]);
			}
		}
	}
}

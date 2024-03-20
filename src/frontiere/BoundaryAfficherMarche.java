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
			StringBuilder affM = new StringBuilder();
			while ((i< (marche.length-1))&&(marche[i] != null)) {
				affM.append(" - "+marche[i++]+" ");
				affM.append("qui vend "+marche[i++]);
				affM.append(" "+marche[i++]+"\n");
				System.out.println(affM.toString()); 
			}
		}
	}
}

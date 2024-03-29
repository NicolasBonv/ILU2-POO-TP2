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

	public int acheterProduit(String nomVendeur,int qtt,String prod) {
		if(controlVerifierIdentite.verifierIdentite(nomVendeur)){
			Etal etalVendeur = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
			if(etalVendeur.contientProduit(prod)) 
				return etalVendeur.acheterProduit(qtt);
			else 
				System.out.println("Désolé, personne ne vend ce produit "+prod+" au marché");
		}else 
			System.out.println("Je suis désolé "+nomVendeur+" mais il faut être un habitant de notre village pour vendre");
		return -1;		
	}
	public String[] vendeurProd(String prod) {
		Gaulois[] tabVendeurG = village.rechercherVendeursProduit(prod);
		String[] vendeurProd = new String[tabVendeurG.length];
		for (int i=0;i<tabVendeurG.length;i++) {
			vendeurProd[i] = tabVendeurG[i].getNom();
		}
		return vendeurProd;
	}
	public boolean estPresent(String prod) {
		return village.rechercherVendeursProduit(prod) != null;
	}
	public int qttVendProd(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).getQuantite();
	}
}

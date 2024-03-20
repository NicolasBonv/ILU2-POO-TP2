package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		System.out.println("Quel produit voulez-vous acheter ?\n");
		String prod = scan.next();
		if(!controlAcheterProduit.isHere(prod))
			System.out.println("D�sol�, personne ne vend ce produit au march�");
		else {
			System.out.println("Chez quel commer�ant voulez-vous acheter des "+prod+" ?\n");
			StringBuilder vendeurProd = new StringBuilder();
			String[] vendeurProduit = controlAcheterProduit.vendeurProd(prod);
			for (int i=0;i<vendeurProduit.length;i++) {
				System.out.println(i+" - "+ vendeurProduit[i]+"\n");
			}
			int nbVendeur = scan.nextInt();
			System.out.println(nomAcheteur+" se d�place jusqu'� l'�tal du vendeur "+vendeurProduit[nbVendeur]+"\n");
			System.out.println("Combien de fleurs voulez-vous acheter ?\n");
			int qtt = scan.nextInt();
			int qttVend = controlAcheterProduit.qttVendProd(vendeurProduit[nbVendeur]);
			if (qttVend<qtt) {
				System.out.println(nomAcheteur+" veut acheter "+qtt+" "+prod+", malheureusement "+vendeurProduit[nbVendeur]+
						" n'en a plus que "+ qttVend+"."+nomAcheteur+" achete tout le stock");
				controlAcheterProduit.acheterProduit(vendeurProduit[nbVendeur], qtt, prod);
				}
			else
				System.out.println(nomAcheteur+" ach�te "+controlAcheterProduit.acheterProduit(vendeurProduit[nbVendeur], qtt, prod)+" "+prod+" � "+vendeurProduit[nbVendeur]);
		}
	}
}

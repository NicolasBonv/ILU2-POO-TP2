package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue druide " + nomVisiteur);
		int forceDruide = -1;
		forceDruide = Clavier.entrerEntier("Quelle est votre force ?");
		int effetPotMin = -1;
		int effetPotMax = -2;
		while (effetPotMin > effetPotMax) {
			effetPotMin = Clavier.entrerEntier("Quelle est la force de potion la plus faible ?");
			effetPotMax = Clavier.entrerEntier("Quelle est la force de potion la plus force ?");
			if (effetPotMax < effetPotMin)
				System.out.println("Attention Druide, vous vous �tes tromp� entre le min et le max");
		}
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotMin, effetPotMax);
	}
	private void emmenagerGaulois(String nomVisiteur) {
		System.out.println("Bienvenue gaulois" + nomVisiteur);
		int forceGaulois = -1;
		forceGaulois = Clavier.entrerEntier("Quelle est votre force ?");
		controlEmmenager.ajouterGaulois(nomVisiteur, forceGaulois);
	}
}

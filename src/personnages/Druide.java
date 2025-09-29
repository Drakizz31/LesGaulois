package personnages;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	// Ajout d'un chaudron pour que le druide puisse interagir avec lui
	private Chaudron chaudron;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
	}

	// Pour que le Druide puisse utiliser le chaudron qu'il a fabriqué
	public void setChaudron(Chaudron chaudron) {
		this.chaudron = chaudron;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "«" + texte + "»");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public Chaudron fabriquerPotion(int quantitePotion, int forcePotion) {
		Chaudron nouveauChaudron = new Chaudron(quantitePotion, forcePotion);
		remplirChaudron(nouveauChaudron);
		this.chaudron = nouveauChaudron;
		return nouveauChaudron;
	}

	private void remplirChaudron(Chaudron chaudron) {
		parler("J'ai concocté " + chaudron.getQuantitePotion() + " dose(s) de potion magique. Elle a une force de "
				+ chaudron.getForcePotion() + ".");
	}

	public void boosterGaulois(Gaulois gaulois) {
		if (!chaudron.resterPotion()) {
			String nomGaulois = gaulois.getNom();

			if (nomGaulois.equals("Obélix")) {
				parler("Non ! " + nomGaulois + ". Et tu le sais très bien !");
			} else {
				prendreLouche(gaulois);
			}
		} else {
			parler("Désolé, " + gaulois.getNom() + ". Il n'y a plus une seule goutte de potion.");
		}
	}

	private void prendreLouche(Gaulois gaulois) {
		int forcePotion = chaudron.contenuPotion();

		if (forcePotion > 0) {
			chaudron.boirePotion();
			gaulois.setEffetPotion(forcePotion);
			parler("Tiens, " + gaulois.getNom() + ", bois cette potion. Elle te donnera une force de " + forcePotion
					+ ".");
		}
	}
}
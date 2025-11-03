package personnages;

import histoire.Musee;
import objets.Equipement;

public class Gaulois {
	private String nom;
//	private int force;
	private int effetPotion = 1;
	private Village village;
	private int force;
	private int nb_trophees;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this(nom, force, null);
	}

	public Gaulois(String nom, int force, Village village) {
		this.nom = nom;
		this.force = force;
		this.village = village;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "«" + texte + "»");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//	private String prendreParole() {
//		if (village != null && this.equals(village.getChef())) {
//			return "Le chef " + nom + " du village " + village.getNom() + " : ";
//		} else if (village != null) {
//			return "Le gaulois " + nom + " du village " + village.getNom() + " : ";
//		}
//		return "Le gaulois " + nom + " : ";
//	}

	public void setEffetPotion(int effetPotion) {
		this.effetPotion = effetPotion;
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup((force * effetPotion) / 3);
//
//		if (effetPotion > 1) {
//			effetPotion--;
//		}
//	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nb_trophees++) {
			this.trophees[nb_trophees] = trophees[i];
		}
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	/**
	 * Affiche une présentation du Gaulois en fonction de son statut (chef, simple
	 * habitant, ou sans village).
	 */
	public void sePresenter() {
		String message;

		if (village == null) {
			// Cas : s'il s'agit d'un habitant sans village
			message = "Bonjour, je m'appelle " + nom + ". Je suis voyage de villages en villages.";
		} else if (this.equals(village.getChef())) {
			// Cas : s'il s'agit du chef du village
			message = "Bonjour, je m'appelle " + nom + ". Je suis le chef du village " + village.getNom() + ".";
		} else {
			// Cas : s'il s'agit d'un habitant du village
			message = "Bonjour, je m'appelle " + nom + ". J'habite le village " + village.getNom() + ".";
		}

		System.out.println("Le Gaulois " + nom + " : «" + message + "»");
	}

	
	
	public void faireUneDonnation(Musee musee) {
	    if (nb_trophees == 0) {
	        
	        System.out.println(prendreParole() + "Je n'ai aucun trophée à donner.");
	    } else {
	       
	        System.out.println(prendreParole() + "« Je donne au musée tous mes trophées :");
	        for (int i = 0; i < nb_trophees; i++) {
	            System.out.println("- " + trophees[i].getNom()); 
	            musee.donnerTrophees(this, trophees[i]); 
	        }
	        
	        System.out.println("»");
	    }
	}


	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
	}
}
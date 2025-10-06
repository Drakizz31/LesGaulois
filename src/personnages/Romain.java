package personnages;

public class Romain {
	private String nom;
	private int force;
	private boolean invariantVerifie() {
		return force >= 0;
	}

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert invariantVerifie(): "Invariant violé après création : force négative";
		}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		//postcondition: stocker la force avant le coup pour la vérification
		int forceAvantCoup = force;
		//précondition 
		assert forcecoup > 0 : "Précondition violé : la force du coup reçu doit être positive.";
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne !");
		}
		//Postcondition
		assert force < forceAvantCoup : "Postcondition violée : La force du Romain n'a pas diminué.";
		//Invariant
		assert invariantVerifie(): "Invariant violé après création : force négative";
	}
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.parler(" Je suis prêt à combattre !");
	}
}

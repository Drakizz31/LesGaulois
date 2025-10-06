package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private boolean invariantVerifie() {
		return force >= 0;
	}
	
	public void sEquiper(Equipement equipement) {
	    String nomRomain = this.getNom();
	    
	    switch (nbEquipement) {
	        case 2:
	            // Cas 1 : Le soldat est déjà protégé (tableau plein)
	            System.out.println("Le soldat " + nomRomain + " est déjà bien protégé !");
	            break;

	        case 1:
	            // Cas 2 : Un équipement est déjà là, vérifier si c'est le même
	            if (equipements[0] == equipement) {
	                System.out.println("Le soldat " + nomRomain + " possède déjà un " + equipement.toString() + " !");
	            } else {
	                // Cas 3 : Ajouter le nouvel équipement
	                equipements[1] = equipement;
	                nbEquipement++;
	                System.out.println("Le soldat " + nomRomain + " s'équipe avec un " + equipement.toString() + ".");
	            }
	            break;

	        case 0:
	            // Cas 4 : Ajouter le premier équipement
	            equipements[0] = equipement;
	            nbEquipement++;
	            System.out.println("Le soldat " + nomRomain + " s'équipe avec un " + equipement.toString() + ".");
	            break;
	            
	        default:
	            // Cas de sécurité (ne devrait pas arriver)
	            System.out.println("Erreur d'état d'équipement pour " + nomRomain);
	            break;
	    }
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
		assert forceCoup > 0 : "Précondition violé : la force du coup reçu doit être positive.";
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
		 // Tester la méthode dans le main sur Minus
        System.out.println("\n--- Tests d'équipement sur Minus ---");
        
        // 1. Ajout du premier CASQUE (nbEquipement = 1)
        minus.sEquiper(Equipement.CASQUE); 
        
        // 2. Ajout du deuxième CASQUE (Test : possède déjà l'équipement)
        minus.sEquiper(Equipement.CASQUE); 
        
        // 3. Ajout du BOUCLIER (nbEquipement = 2, tableau plein)
        minus.sEquiper(Equipement.BOUCLIER);   
        
        // 4. Ajout d'un CASQUE (Test : déjà bien protégé)
        minus.sEquiper(Equipement.CASQUE); 
	}
}

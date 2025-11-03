package objets;

public enum Equipement {
    // Modifications b. : ajout du nom en paramètre du constructeur
    CASQUE("casque"), 
    BOUCLIER("bouclier");

    // Modification b. : attribut nom
    private String nom;

    // Modification b. : constructeur prenant la chaîne en paramètre
    private Equipement(String nom) {
        this.nom = nom;
    }
    
    // Modification b. : méthode toString
    @Override
    public String toString() {
        return nom; // Affiche le nom de l'équipement (ex: "casque")
    }

    public static void main(String[] args) {
        // Test de l'énumération (Étape a.)
        System.out.println(CASQUE);
        System.out.println(BOUCLIER);
        
        // Affichage des noms des énumérés
        System.out.println(Equipement.CASQUE.nom);
        System.out.println(Equipement.BOUCLIER.nom);
    }

	public String getNom() {
		return nom;
	}
}
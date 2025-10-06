package personnages;

public class Village {
    private String nom;
    private Gaulois chef;
    private int nbVillageois;
    private Gaulois[] villageois;
    private int nbVillageoisActuel = 0;

    public Village(String nom, int nbVillageois) {
        this.nom = nom;
        this.nbVillageois = nbVillageois;
        this.villageois = new Gaulois[nbVillageois];
    }

    public String getNom() {
        return nom;
    }

    public Gaulois getChef() {
        return chef;
    }

    public void setChef(Gaulois chef) {
        this.chef = chef;
    }

    public void ajouterVillageois(Gaulois villageois) {
        if (nbVillageoisActuel < nbVillageois) {
            this.villageois[nbVillageoisActuel] = villageois;
            nbVillageoisActuel++;
        }
    }

    public Gaulois trouverVillageois(int numVillageois) {
        if (numVillageois >= 0 && numVillageois < nbVillageoisActuel) {
            return villageois[numVillageois];
        }
        return null;
    }

    public void afficherVillage() {
        System.out.println("Le village de " + nom + " est dirigé par le chef " + chef.getNom() + ".");
        System.out.println("Il y a " + nbVillageoisActuel + " gaulois dans le village :");
        for (int i = 0; i < nbVillageoisActuel; i++) {
            System.out.println(villageois[i].getNom());
        }
    }
   
    public static void main(String[] args) {
        
        // Créer le village
        Village village = new Village("Village des Irréductibles", 30);
        
        // Créer Abraracourcix et l'ajouter comme chef
        Gaulois abraracourcix = new Gaulois("Abraracourcix", 6, village);
        village.setChef(abraracourcix);
        
        // Créer Astérix et l'ajouter au village
        Gaulois asterix = new Gaulois("Astérix", 8, village);
        village.ajouterVillageois(asterix);
        
        // Créer Obélix
        Gaulois obelix = new Gaulois("Obélix", 16, village);
        village.ajouterVillageois(obelix);
        
        // Créer DoublePolémix (sans village initialement)
        Gaulois doublePolemix = new Gaulois("DoublePolémix", 4); 
        // Note: Le constructeur Gaulois(nom, force) assigne village = null
        
        // Vérification des habitants (comme demandé dans l'énoncé)
        Gaulois gaulois1 = village.trouverVillageois(1);
        Gaulois gaulois2 = village.trouverVillageois(99); 
        
        // Affichage des résultats
        System.out.println("Gaulois trouvé à l'indice 1 : " + gaulois1.getNom());
        System.out.println("Gaulois trouvé à l'indice 99 (doit être null) : " + gaulois2);
        
        // Affichage du village (Étape e)
        village.afficherVillage();
        
     // Appeler la méthode sePresenter sur les objets (Étape g.c)
        System.out.println("\n--- Présentation des Gaulois ---");
        abraracourcix.sePresenter();
        asterix.sePresenter();
        doublePolemix.sePresenter();
    }
}
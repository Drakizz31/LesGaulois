package test_fonctionnel;

import personnages.Chaudron;
import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class TestGaulois {
	

	public static void main(String[] args) {
		Romain brutus = new Romain("Brutus", 14);
	    Druide panoramix = new Druide("Panoramix", 2, 8);
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 16);
		Romain minus = new Romain("minus", 6);
		
		// exercice 3.3
		/*	
		    asterix.parler("Bonjour Obélix");
			obelix.parler("Bonjour Astérix. Bonjour Astérix. Ca te dirais d'aller chasser des sangliers ?");
			asterix.parler("Oui  très bonne idée.");
			System.out.println("Dans la forêt" + asterix.getNom() + "et" + obelix.getNom() + "tombent nez à nez sur le romain" + minus.getNom() + ".");
			asterix.frapper(minus);
			asterix.frapper(minus);
			asterix.frapper(minus);
		*/
		
		 // Le druide prépare 8 doses de potion de force 3
        int quantite = 8;
        int force = 3;
        Chaudron chaudron = panoramix.fabriquerPotion(quantite, force);
        
        // Le druide booste Obélix (qui refuse)
        panoramix.boosterGaulois(obelix);
        
        // Le druide booste Astérix
        panoramix.boosterGaulois(asterix);
        
        // Astérix frappe Brutus 3 fois
        for (int i = 0; i < 3; i++) {
            asterix.frapper(brutus);
        }
	}
}

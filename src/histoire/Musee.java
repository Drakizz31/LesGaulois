package histoire;

import objets.Equipement;
import personnages.Gaulois;
import personnages.Romain;

import java.util.ArrayList;
import java.util.List;

public class Musee {
    private List<Trophee> trophees;

    public Musee() {
        trophees = new ArrayList<>();
    }

    public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
        Trophee trophee = new Trophee(gaulois, equipement);
        trophees.add(trophee);
    }

    public void afficherTrophees() {
        System.out.println("Trophées dans le musée :");
        for (Trophee trophee : trophees) {
            System.out.println("- " + trophee.getEquipement().getNom());
        }
    }

    public String extraireInstructionsOCaml() {
        StringBuilder sb = new StringBuilder();
        sb.append("let musee = [\n");

        for (int i = 0; i < trophees.size(); i++) {
            Trophee trophee = trophees.get(i);
            sb.append(trophee.toString());

            if (i < trophees.size() - 1) {
                sb.append(";\n");
            }
        }

        sb.append("\n]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Musee musee = new Musee();
        Gaulois asterix = new Gaulois("Astérix", 8);
        Equipement bouclier = Equipement.BOUCLIER; // Utilisation de l'énumération
        Equipement casque = Equipement.CASQUE;

        asterix.frapper(new Romain("Romain", 0));
        musee.donnerTrophees(asterix, bouclier);
        musee.donnerTrophees(asterix, casque);

        System.out.println(musee.extraireInstructionsOCaml());
    }
}

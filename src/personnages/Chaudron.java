package personnages;

public class Chaudron {
    private int quantitePotion = 0;
    private int forcePotion = 0;

    public Chaudron(int quantitePotion, int forcePotion) {
        this.quantitePotion = quantitePotion;
        this.forcePotion = forcePotion;
    }

    public int getQuantitePotion() {
        return quantitePotion;
    }

    public int getForcePotion() {
        return forcePotion;
    }
    
    public boolean resterPotion() {
        return quantitePotion == 0;
    }
    
    public int contenuPotion() {
        return forcePotion;
    }
    
    public void boirePotion() {
        quantitePotion--;
        forcePotion = 0;
    }
}
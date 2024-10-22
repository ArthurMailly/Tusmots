public class Partie {
    private Grille grille;
    private int nbrEssai;
    private int numeroDeLEssai;

    public Partie(String motCible, int nbrEssai) {
        this.grille = new Grille(motCible, nbrEssai);
        this.nbrEssai = nbrEssai;
        this.numeroDeLEssai = 0;
    }

    public boolean testerMot(String mot) {
        if (mot.length() == grille.mot.length() && grille.TestMotLigne(numeroDeLEssai, mot)) {
            numeroDeLEssai++;
            return true;
        } else {
            return false;
        }
    }

    public boolean estPartieTerminee() {
        if(grille.MotTrouve(numeroDeLEssai-1) || numeroDeLEssai >= nbrEssai ) {
            return true;
        }
        else {
            return false;
        }
    }

    public Grille getGrille() {
        return grille;
    }

    public int getNumeroDeLEssai() {
        return numeroDeLEssai;
    }

    public int getNbrEssai() {
        return nbrEssai;
    }
}

public class Partie {
    private Grille grille;
    private int nbrEssai;
    private int numeroDeLEssai;

    public Partie(String motCible, int nbrEssai) {
        this.grille = new Grille(motCible, nbrEssai);
        this.nbrEssai = nbrEssai;
        this.numeroDeLEssai = 0;
    }

    public boolean testentre(String mot){//Vérifie si le mot est composé uniquement de lettres
        return mot.matches("[a-zA-Z]+");
    }
    public boolean testExistence(String mot) { //Appelle l'insatnce de Lexique pour vérifier si le mot existe, Thibaud avait codé la méthode motExiste dans Lexique.java, donc cette méthode relie le code de Thibaud avec le mien
        return Lexique.motExiste(new Mot(mot));
    }

    public boolean testerMot(String mot) {// Renvoie le même message d'erreur pour les 3 erreurs(nb essais dépassé,mot pas composé de lettres, mot qui n'est pas dans la DB), on pourrais peut etre changer ?
        if (grille.TestMotLigne(numeroDeLEssai, mot) && testentre(mot) && testExistence(mot)) {
            numeroDeLEssai++;
            
            return true;
        } else {
            return false;
        }
    }

    public int estPartieTerminee() {
        // Voir cahier de labo pour explication du -1 ci-dessous
        // 1 pour victoire, 2 pour défaite, 0 partie pas terminée
        if(grille.MotTrouve(numeroDeLEssai-1) ) {
            return 1;
        }
        else {
            if (numeroDeLEssai >= nbrEssai){
                return 2;
            }
            else {
                return 0;
            }
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

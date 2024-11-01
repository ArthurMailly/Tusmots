import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //Il faut installer sql lite pour faire tourner la DB, je suis sur VS code donc pour cet IDE la :
        // lien : https://repo1.maven.org/maven2/org/xerial/sqlite-jdbc/3.47.0.0/sqlite-jdbc-3.47.0.0.jar
        // Ensuite il faut aller dans les paramètres de l'IDE et ajouter le fichier jar dans les librairies

        //J'ai ajouté l'affichage du mot qu'on cherche sinon c'est hardcore de deviner
        new menu();

        

        
        // Scanner lectureClavier = new Scanner(System.in);
        // int nbrEssai = 6;

        // Grille grille = new Grille("TAMANOIR", nbrEssai);
        // grille.AfficherGrille();
        // grille.AfficherEtats();

        // System.out.print("\n");

        // int NumeroDeLEssai = 0;

        // while (NumeroDeLEssai < nbrEssai)
        // {
        //     System.out.println("Quel mot voulez-vous essayer ?");
        //     String mot;

        //     mot = lectureClavier.next();

        //     if (grille.TestMotLigne(NumeroDeLEssai, mot))
        //     {
        //         grille.AfficherGrille();
        //         grille.AfficherEtats();
        //         NumeroDeLEssai++;
        //     }

        // }

    }
}
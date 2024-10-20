import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner lectureClavier = new Scanner(System.in);
        int nbrEssai = 6;

        Grille grille = new Grille("TAMANOIR", nbrEssai);
        grille.AfficherGrille();
        grille.AfficherEtats();

        System.out.print("\n");

        int NumeroDeLEssai = 0;

        while (NumeroDeLEssai < nbrEssai)
        {
            System.out.println("Quel mot voulez-vous essayer ?");
            String mot;

            mot = lectureClavier.next();

            if (grille.TestMotLigne(NumeroDeLEssai, mot))
            {
                grille.AfficherGrille();
                grille.AfficherEtats();
                NumeroDeLEssai++;
            }

        }

    }
}
public class Main
{
    public static void main(String[] args)
    {
     Grille grille = new Grille("TAMANOIR", 6);
     grille.AfficherGrille();
     grille.AfficherEtats();

     System.out.print("\n");

     grille.TestMotLigne(0, "TAMANOIR");
     grille.AfficherGrille();
     grille.AfficherEtats();


    }
}
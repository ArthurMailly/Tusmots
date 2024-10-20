public class Grille
{
    private int nbrEssai;
    private int tailleMot;
    private Mot grilleMots[];
    private String mot;

    public Grille(String mot, int nbrEssai)
    {
        this.mot = mot;
        this.tailleMot = this.mot.length();
        this.nbrEssai = nbrEssai;
        this.grilleMots = new Mot[this.nbrEssai];

        for (int i = 0; i < this.nbrEssai; i++)
        {
            this.grilleMots[i] = new Mot(this.mot);
        }
    }

    public boolean TestMotLigne(int i, String MotTest)
    {
        return this.grilleMots[i].TesterMot(MotTest);
    }

    public void AfficherGrille()
    {
        for (int i = 0; i < this.nbrEssai; i++)
        {
            this.grilleMots[i].AfficherMot();

            System.out.println(" ");
        }
    }

    public void AfficherEtats()
    {
        for (int i = 0; i < this.nbrEssai; i++)
        {
            this.grilleMots[i].EtatDesCases();

            System.out.println(" ");
        }
    }
}

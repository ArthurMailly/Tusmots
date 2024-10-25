import java.awt.Color;

public class Case
{
    private Color couleur;
    private char lettre;
    private int EtatCase; // 1 = bonne lettre; 2 = lettre mal placée; 3 = mauvaise lettre; 4 = lettre pas vérifiée

    public Case(char l, int etat)
    {
        this.lettre = l;
        this.EtatCase = etat;
        MajCouleur();
    }

    public Case(char l)
    {
        this.lettre = l;
        this.EtatCase = 3;
        MajCouleur();
    }

    public void BonneLettre(char l)
    {
        if ( l == this.lettre)
        {
            this.couleur = Color.green;
            this.EtatCase = 1;
        }
    }

    public boolean EstCachee()
    {
        if (this.EtatCase == 1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public char getLettre() {return this.lettre;}

    public void MajCouleur()
    {
        switch (EtatCase)
        {
            case 0, 3, 4 -> couleur = Color.black;
            case 1 -> couleur = Color.green;
            case 2 -> couleur = Color.yellow;
        }

    }

    public void setEtatCase(int etatCase) {
        EtatCase = etatCase;
        MajCouleur();
    }

    public int getEtatCase()
    {
        return this.EtatCase;
    }

}

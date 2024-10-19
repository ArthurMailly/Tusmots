public class Mot
{
    private int nbr_lettres;
    private String mot;
    private Case mot_case[];

    public Mot(String mot)
    {
        this.mot = mot;
        this.nbr_lettres = this.mot.length();
        this.mot_case = new Case[this.nbr_lettres];

        mot_case[0] = new Case(mot.charAt(0), 1);

        for (int i = 1; i < this.nbr_lettres; i++)
        {
            mot_case[i] = new Case(mot.charAt(i));
        }

    }

    public void AfficherMot()
    {
        for (int i = 0; i < this.mot.length(); i++)
        {
            if (!mot_case[i].EstCachee())
            {
                System.out.print(mot_case[i].getLettre());
            }
            else
            {
                System.out.print("_");
            }
        }
    }

    public Case getCasePlace(int i) {return this.mot_case[i];}

    public char getLettrePlace(int i){return this.mot_case[i].getLettre();}

    public int NbrLettreDansMot(char lettre)
    {
        int lettredansmot = 0;
        for (int i = 0; i < this.mot.length(); i++)
        {
            if (this.mot.charAt(i) == lettre)
            {
                lettredansmot ++;
            }
        }
        return lettredansmot;
    }

    public String getMot() {
        return mot;
    }

    public void EtatDesCases()
    {
        for (int i = 0; i < this.mot.length(); i++)
        {
            System.out.print(this.mot_case[i].getEtatCase());
        }
    }

    public void TesterMot(String MotTest)
    {
        for (int i = 0; i < MotTest.length(); i++) { // Regarde les lettres qui sont bonnes
            char lettre = MotTest.charAt(i);
            this.mot_case[i].BonneLettre(lettre);
        }
        

        /*

        for (int i = 0; i < MotTest.length(); i++) {
            char lettre = MotTest.charAt(i);
            if (NbrLettreDansMot(lettre) == 0)
            {
                this.mot_case[i].setEtatCase(3);
            }
            else if (this.mot_case[i].getEtatCase() != 1)
            {
                int LettreApparru = 0;
                for (int j = 0; j < MotTest.length(); j++)
                {
                    if (lettre == MotTest.charAt(j) && this.mot_case[j].getEtatCase() != 1 && this.mot_case[j].getEtatCase() != 3)
                    {
                        LettreApparru ++;
                    }
                }

                if (LettreApparru < NbrLettreDansMot(lettre))
                {
                    this.mot_case[i].setEtatCase(2);
                }
            }
        }

         */

    }
}

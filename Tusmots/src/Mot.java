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
            mot_case[i] = new Case(mot.charAt(i), 4);
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

    public int CompteLettreEtat(String mot, char lettre, int etat)
    {
        int nbr = 0;
        for (int i = 0; i < this.nbr_lettres; i++)
        {
            if ((mot.charAt(i) == lettre) && (this.mot_case[i].getEtatCase() == etat))
            {
                nbr++;
            }
        }
        return nbr;
    }

    public boolean TesterMot(String MotTest)
    {
        if (MotTest.length() != this.nbr_lettres)
        {
            return false;
        }
        for (int i = 0; i < MotTest.length(); i++) { // Regarde les lettres qui sont bonnes
            char lettre = MotTest.charAt(i);
            this.mot_case[i].BonneLettre(lettre);
        }


        for (int i = 0; i < MotTest.length(); i++) {
            if (this.mot_case[i].getEtatCase() == 4)
            {
                char lettre = MotTest.charAt(i);
                int LettreDansMot = 0;
                for (int j = 0; j < MotTest.length(); j++)
                {
                    if  (lettre == MotTest.charAt(j))
                    {
                        LettreDansMot++;
                    }
                }

                if ((LettreDansMot <= NbrLettreDansMot(lettre)) && (LettreDansMot != 0))
                {
                    this.mot_case[i].setEtatCase(2);
                }
            }

            if (this.mot_case[i].getEtatCase() == 4)
            {
                this.mot_case[i].setEtatCase(3);
            }
        }

        for (int i = 0; i < MotTest.length(); i++)
        {
            if (this.mot_case[i].getEtatCase() == 3)
            {
                char lettre = MotTest.charAt(i);
                int nbrLettreEtat3 = CompteLettreEtat(MotTest, lettre, 3);
                int nbrLettreEtat2 = CompteLettreEtat(MotTest, lettre, 2);
                int nbrLettreEtat1 = CompteLettreEtat(MotTest, lettre, 1);
                int nbrLettreMot = NbrLettreDansMot(lettre);

                System.out.println(lettre);

                System.out.println("Nbr Etat 1 = " + nbrLettreEtat1);
                System.out.println("Nbr Etat 2 = " + nbrLettreEtat2);
                System.out.println("Nbr Etat 3 = " + nbrLettreEtat3);
                System.out.println("NbrLettreDansMot(lettre) = " + NbrLettreDansMot(lettre));
                System.out.println(" ");

                if (nbrLettreEtat1 + nbrLettreEtat2 < nbrLettreMot)
                {
                    this.mot_case[i].setEtatCase(2);
                }
            }
        }

        return true;
    }
}

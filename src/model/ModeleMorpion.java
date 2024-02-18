package model;

import utils.Joueur;
import utils.Marqueur;

public class ModeleMorpion extends ModeleGrille{
	private static int tailledegrille = 3;
    private Marqueur[][] grille;
	
    public ModeleMorpion(Joueur j1, Joueur j2) {
        super(j1,j2);
        this.grille=new Marqueur[tailledegrille][tailledegrille];
        for (int i = 0; i < tailledegrille; i++) {
            for (int j = 0; j < tailledegrille; j++) {
                this.grille[i][j] = Marqueur.VIDE;
            }
        }
    }

    @Override
    public Marqueur[][] getGrille() {
        return this.grille;
    }

    public boolean gagnantLigne() {
        for(int i=0;i<tailledegrille;i++) {
            if ((this.grille[i][0]==this.grille[i][1]) &&
                    (this.grille[i][1]==this.grille[i][2]) && (this.grille[i][0]!= Marqueur.VIDE)) {
                return true;
            }
        }
        return false;
    }
    public boolean gagnantColonne() {
        for(int i=0;i<tailledegrille;i++) {
            if ((this.grille[0][i]==this.grille[1][i]) &&
                    (this.grille[1][i]==this.grille[2][i]) && (this.grille[0][i]!= Marqueur.VIDE)) {
                return true;
            }
        }
        return false;
    }
    public boolean gagnantDiagonale() {
        return ((this.grille[0][0] == this.grille[1][1]) && (this.grille[1][1] == this.grille[2][2]) && (this.grille[1][1] != Marqueur.VIDE)) ||
                ((this.grille[2][0] == this.grille[1][1]) && (this.grille[1][1] == this.grille[0][2]) && (this.grille[1][1] != Marqueur.VIDE));
    }

    @Override
    public void jouerCaseValide(Integer x, Integer y) {
        Marqueur nouvelleCase;
        if (this.actueljoueur.equals(Joueur.JOUEUR1))
            nouvelleCase = Marqueur.CROIX;
        else
            nouvelleCase = Marqueur.CERCLE;
        this.grille[x][y] = nouvelleCase;

        this.notifierObservateur();
    }

    @Override
    public boolean coupValide(Integer x, Integer y) {

        return x<tailledegrille && x>= 0 && y <tailledegrille && y>=0 && (this.grille[x][y] == Marqueur.VIDE) ;
    }

    public boolean gagnant() {
        return (gagnantDiagonale() || gagnantColonne() || gagnantLigne());
    }

    @Override
    public boolean partieFinie() {
        if (this.gagnant())
            return true;
        for (int i = 0; i < tailledegrille; i++) {
            for (int j = 0; j < tailledegrille; j++) {
                if(this.grille[i][j] == Marqueur.VIDE)
                    return false;
            }
        }
        return true;
    }

}

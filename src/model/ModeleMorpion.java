package model;

import utils.Joueur;
import utils.Marqueur;

public class ModeleMorpion extends ModeleGrille{
    public ModeleMorpion(Joueur j1, Joueur j2) {
        super(j1,j2);
        this.grille=new Marqueur[3][3];
    }

    public boolean gagnantLigne() {
        for(int i=0;i<3;i++) {
            if ((this.grille[i][0]==this.grille[i][1]) &&
                    (this.grille[i][1]==this.grille[i][2])) {
                return true;
            }
        }
        return false;
    }
    public boolean gagnantColonne() {
        for(int i=0;i<3;i++) {
            if ((this.grille[0][i]==this.grille[1][i]) &&
                    (this.grille[1][i]==this.grille[2][i])) {
                return true;
            }
        }
        return false;
    }
    public boolean gagnantDiagonale() {
        for(int i=0;i<3;i++) {
            if (((this.grille[0][0]==this.grille[1][1]) &&(this.grille[1][1]==this.grille[2][2])) ||
                    ((this.grille[2][0]==this.grille[1][1]) &&
                            (this.grille[1][1]==this.grille[2][0]))) {
                return true;
            }
        }
        return false;
    }

    public Integer gagnant() {
        if
        ((this.grille[0][0]==this.grille[1][1]) &&
                (this.grille[1][1]==this.grille[2][2])) ||
        ((this.grille[2][0]==this.grille[1][1]) &&
                (this.grille[1][1]==this.grille[2][0]))
    }
}

package model;

import utils.Joueur;
import utils.Marqueur;

public class ModelePuissanceQuatre extends ModeleGrille {
    private static int tailledegrilleLigne = 7;
    private static int tailledegrilleColonne = 6;
    private Marqueur[][] grille;

    public ModelePuissanceQuatre(Joueur j1, Joueur j2) {
        super(j1,j2);
        this.grille=new Marqueur[tailledegrilleLigne][tailledegrilleColonne];
        for (int i = 0; i < tailledegrilleLigne; i++) {
            for (int j = 0; j < tailledegrilleColonne; j++) {
                this.grille[i][j] = Marqueur.VIDE;
            }
        }
    }

    @Override
    public Marqueur[][] getGrille() {
        return this.grille;
    }

    public boolean verifierSequenceIdentique(Marqueur m1, Marqueur m2, Marqueur m3, Marqueur m4){
        return m1 != Marqueur.VIDE && m1 == m2 && m2 == m3 && m3 == m4;
    }

    public boolean gagnantLigne() {
        for (int i = 0; i < tailledegrilleColonne; i++) {
            for (int j = 0; j < tailledegrilleLigne - 3; j++) {
                if (verifierSequenceIdentique(grille[j][i], grille[j + 1][i], grille[j + 2][i], grille[j + 3][i])) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean gagnantColonne() {
        for (int i = 0; i < tailledegrilleLigne; i++) {
            for (int j = 0; j < tailledegrilleColonne - 3; j++) {
                if (verifierSequenceIdentique(grille[i][j], grille[i][j + 1], grille[i][j + 2], grille[i][j + 3])) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean gagnantDiagonale() {
        // verifier le diagonal decroissant
        for (int i = 0; i < tailledegrilleLigne - 3; i++) {
            for (int j = 0; j < tailledegrilleColonne - 3; j++) {
                if (verifierSequenceIdentique(grille[i][j], grille[i + 1][j + 1], grille[i + 2][j + 2], grille[i + 3][j + 3])) {
                    return true;
                }
            }
        }
        // verifier le diagonal croissant
        for (int i = 3; i < tailledegrilleLigne; i++) {
            for (int j = 0; j < tailledegrilleColonne - 3; j++) {
                if (verifierSequenceIdentique(grille[i][j], grille[i - 1][j + 1], grille[i - 2][j + 2], grille[i - 3][j + 3])) {
                    return true;
                }
            }
        }
        return false;
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

    public Integer indiceLigneAuPlusBas(Integer y){
        for(int x = tailledegrilleLigne -1; x >=0; x--){
            if(this.grille[x][y]== Marqueur.VIDE){
                return x;
            }
        }
        return 0;
    }
    @Override
    public boolean coupValide(Integer x, Integer y) {
        return y<tailledegrilleColonne && y>= 0 &&(this.grille[x][y] == Marqueur.VIDE) ;
    }

    public boolean gagnant() {
        return (gagnantDiagonale() || gagnantColonne() || gagnantLigne());
    }

    @Override
    public boolean partieFinie() {
        if (this.gagnant())
            return true;
        for (int j = 0; j < tailledegrilleColonne; j++) {
            if (grille[0][j] == Marqueur.VIDE) return false; // si on trouve une colonne qui n'est pas rempli entierement on continue a jouer
        }
        return true;
    }
}

package model;

import utils.Joueur;
import utils.Marqueur;
import view.Observateur;

public interface ModeleJeux {

    public Marqueur[][] getGrille();
    public void jouerCaseValide(Integer x, Integer y);
    public boolean coupValide(Integer x, Integer y);
    public boolean gagnant();
    public boolean partieFinie();
    public Joueur actuelJoueur();
    public void ajouterObservateur(Observateur o);
    public void supprimerObservateur(Observateur o);
    public void notifierObservateur();
}

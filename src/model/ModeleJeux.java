package model;

import utils.Joueur;
import utils.Marqueur;

import java.util.List;

public interface ModeleJeux {

    public List<List<Marqueur>> getGrille();
    public void jouerCaseValide(Integer x, Integer y);
    public boolean coupValide(Integer x, Integer y);
    public Integer gagnant();
    public boolean partieFinie();
    public Joueur actuelJoueur();
    public void ajouterObservateur(Observateur o);
    public void supprimerObservateur(Observateur o);
    public void notifierObservateur();
}

package model;

import utils.Joueur;
import utils.Marqueur;

import java.util.ArrayList;
import java.util.List;

public abstract class ModeleGrille implements ModeleJeux{
    private Joueur joueur1;
    private Joueur joueur2;
    private List<List<Marqueur>> grille;
    private Joueur actueljoueur;
    private ArrayList<Observateur> observateurs;
    public ModeleGrille(Joueur j1, Joueur j2) {
        this.joueur1=j1;
        this.joueur2=j2;
        this.observateurs=new ArrayList<>();
    }
    public Joueur actuelJoueur() {
        return this.actueljoueur;
    }
    public prochainJoueur() {
        if (this.actueljoueur.equals(this.joueur1)){
            this.actueljoueur=this.joueur2;
        }
		else {
            this.actueljoueur=this.joueur1;
        }
        return this.actueljoueur;
    }
    public void ajouterObservateur( Observateur o) {
        this.observateurs.add(o);
    }
    public void supprimerObservateur( Observateur o) {
        this.observateurs.remove(o);
    }
    public void notifierObservateur() {
        for (Observateur o : observateurs) {
            o.actualiser();
        }
    }
    public void jouerCaseValide(Integer x, Integer y);
    public boolean coupValide(Integer x, Integer y);
    public Integer gagnant();
    public boolean partieFinie();
    public List<List<Marqueur>> getGrille(){
        return this.grille;
    }
}
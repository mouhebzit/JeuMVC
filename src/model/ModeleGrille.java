package model;

import utils.Joueur;
import utils.Marqueur;
import view.Observateur;

import java.util.ArrayList;

public abstract class ModeleGrille implements ModeleJeux{
	protected Joueur joueur1;
    protected Joueur joueur2;
    //protected List<List<Marqueur>> grille;
    protected Joueur actueljoueur;
    protected ArrayList<Observateur> observateurs;
    public ModeleGrille(Joueur j1, Joueur j2) {
        this.joueur1=j1;
        this.actueljoueur = j1;
        this.joueur2=j2;
        this.observateurs=new ArrayList<>();
    }
    public Joueur actuelJoueur() {
        return this.actueljoueur;
    }
    public void prochainJoueur() {
        if (this.actueljoueur.equals(this.joueur1)){
            this.actueljoueur=this.joueur2;
        }
		else {
            this.actueljoueur=this.joueur1;
        }
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
    abstract public Marqueur[][] getGrille();

}
package controller;

import model.ModeleGrille;
import model.ModeleJeux;
import utils.CoupException;
import view.VueJeux;

public class ControleurMorpion implements ControleurJeux {

    private ModeleJeux modele;
    private VueJeux vue;

    private int ligneChoisi;

    private int colonneChoisi;
    public ControleurMorpion(ModeleJeux modele){
        this.modele = modele;
    }

    public void gererSaisirCoup() throws CoupException {
        this.ligneChoisi =  this.vue.saisrligne();
        this.colonneChoisi =  this.vue.saisirColonne();
    }

    public void setVue(VueJeux vue) {
        this.vue = vue;
    }


    public void jouerTour(){
        try {
            this.gererSaisirCoup();
            if (this.modele.coupValide(ligneChoisi,colonneChoisi)){
                this.modele.jouerCaseValide(ligneChoisi,colonneChoisi);
                if(this.modele.gagnant())
                    this.vue.afficherGagnant();
                else
                    ((ModeleGrille)this.modele).prochainJoueur();
            }
            else {
                this.vue.afficherErreurSaisirCoup();
            }
        }catch (CoupException e){
            System.out.println(e.toString());
            this.vue.afficherErreurSaisirCoup();
        }


    }
    public void demarrerJeu(){
        this.vue.activerVue();
        while (!this.modele.partieFinie()){
            this.vue.saisrCoup();
        }
    }
}

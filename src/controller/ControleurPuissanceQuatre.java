package controller;

import model.ModeleGrille;
import model.ModeleJeux;
import model.ModelePuissanceQuatre;
import view.VueJeux;

public class ControleurPuissanceQuatre implements ControleurJeux{

    private ModeleJeux modele;
    private VueJeux vue;

    private int ligneChoisi;

    private int colonneChoisi;
    public ControleurPuissanceQuatre(ModeleJeux modele){
        this.modele = modele;
    }

    public void gererSaisirCoup(){
        this.colonneChoisi =  this.vue.saisirColonne();
        this.ligneChoisi =  ((ModelePuissanceQuatre)this.modele).indiceLigneAuPlusBas(colonneChoisi);
    }

    public void setVue(VueJeux vue) {
        this.vue = vue;
    }


    public void jouerTour(){
        this.gererSaisirCoup();
        if (this.modele.coupValide(colonneChoisi,0)){
            this.modele.jouerCaseValide(ligneChoisi,colonneChoisi);
            if(this.modele.gagnant())
                this.vue.afficherGagnant();
            else
                ((ModeleGrille)this.modele).prochainJoueur();
        }
        else {
            this.vue.afficherErreurSaisirCoup();
        }

    }


}

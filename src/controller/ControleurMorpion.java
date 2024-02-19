package controller;

import model.ModeleGrille;
import model.ModeleJeux;
import utils.CoupException;
import view.VueJeux;

/**
 * Le contrôleur pour un jeu de Morpion (Tic Tac Toe).
 */
public class ControleurMorpion implements ControleurJeux {

    private ModeleJeux modele;
    private VueJeux vue;

    private int ligneChoisi;

    private int colonneChoisi;

    /**
     * Constructeur de ControleurMorpion.
     *
     * @param modele Le modèle de jeu à utiliser.
     */
    public ControleurMorpion(ModeleJeux modele){
        this.modele = modele;
    }

    /**
     *Cette méthode demande à l'utilisateur de saisir les coordonnées de la ligne et de la colonne
     * et les enregistre dans les attributs de l'instance controlleur.
     *
     * @throws CoupException Si la saisie de l'utilisateur est invalide.
     */
    public void gererSaisirCoup() throws CoupException {
        this.ligneChoisi =  this.vue.saisrligne();
        this.colonneChoisi =  this.vue.saisirColonne();
    }


    /**
     *
     * @param vue La vue associée au controlleur Morpion
     */
    public void setVue(VueJeux vue) {
        this.vue = vue;
    }

    /**
     * Cette méthode permet de jouer un tour de jeu
     * Elle gère la logique d'un seul tour à la fois :
     *  - La saisie du coup par l'utilisateur
     *  - La validation du coup
     *  - L'enregistrement du coup s'il est validé dans le modele associé
     *  - La mise à jour des affichages
     *  - Affiche un message si une exception est levée ou le coup est invalide
     */
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

    /**
     * Démarre le jeu.
     * Active la vue et entre dans une boucle de jeu, permettant à l'utilisateur de jouer des coups
     * jusqu'à ce que la partie soit finie
     */
    public void demarrerJeu(){
        this.vue.activerVue();
        while (!this.modele.partieFinie()){
            this.vue.saisrCoup();
        }
    }
}

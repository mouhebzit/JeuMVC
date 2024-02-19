package controller;

import model.ModeleGrille;
import model.ModeleJeux;
import model.ModelePuissanceQuatre;
import utils.CoupException;
import view.VueJeux;


/**
 * Contrôleur spécifique pour le jeu de Puissance Quatre.
 */
public class ControleurPuissanceQuatre implements ControleurJeux{

    private ModeleJeux modele;
    private VueJeux vue;

    private int ligneChoisi;

    private int colonneChoisi;

    /**
     * Constructeur de ControleurPuissanceQuatre.
     *
     * @param modele Le modèle de jeu à utiliser.
     */
    public ControleurPuissanceQuatre(ModeleJeux modele){
        this.modele = modele;
    }



    /**
     * Gère la saisie du coup par l'utilisateur.
     * L'utilisateur saisit uniquement la colonne, et la ligne est déterminée automatiquement
     * comme la position la plus basse disponible dans cette colonne.
     *
     * @throws CoupException Si la colonne saisie est invalide ou pleine.
     */
    public void gererSaisirCoup() throws CoupException{
        this.colonneChoisi =  this.vue.saisirColonne();
        this.ligneChoisi =  ((ModelePuissanceQuatre)this.modele).indiceLigneAuPlusBas(colonneChoisi);
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

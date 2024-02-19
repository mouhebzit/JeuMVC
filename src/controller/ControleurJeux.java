package controller;

import utils.CoupException;
import view.VueJeux;


/**
 * Interface définissant le contrat pour les contrôleurs de jeux.
 */
public interface ControleurJeux {

    /**
     * Associe une vue au contrôleur.
     * Cette méthode permet de définir la vue avec laquelle le contrôleur interagit.
     *
     * @param vue La vue à associer avec ce contrôleur.
     */
    public void setVue(VueJeux vue);


    /**
     * Exécute les actions nécessaires pour jouer un tour de jeu.
     */
    public void jouerTour();


    /**
     * Gère la saisie d'un coup par l'utilisateur.
     *
     * @throws CoupException Si la saisie de l'utilisateur est invalide selon les règles du jeu.
     */
    public void gererSaisirCoup() throws CoupException;


    /**
     * Démarre et gère le déroulement complet d'une partie de jeu.
     * Cette méthode doit activer la vue et continuer à jouer des tours jusqu'à ce que la partie soit terminée.
     */
    public void demarrerJeu();
}

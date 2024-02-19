package view;

import utils.CoupException;


/**
 * Interface définissant les méthodes nécessaires pour l'affichage et l'interaction utilisateur dans le jeu.
 */
public interface VueJeux{

    /**
     * Active et affiche la vue principale du jeu.
     */
    public void activerVue();



    /**
     * Affiche un message d'erreur lorsque la saisie d'un coup est invalide.
     * Ceci est utilisé pour informer l'utilisateur d'une action incorrecte et l'inviter à réessayer.
     */
    public void afficherErreurSaisirCoup();


    /**
     * Affiche l'état actuel de la grille de jeu à l'utilisateur.
     */
    public void afficherGrille();


    /**
     * Invite l'utilisateur à saisir un coup.
     * Cette méthode déclenche la lecture d'entrées de l'utilisateur pour déterminer le coup joué.
     */
    public void saisrCoup();


    /**
     * Demande à l'utilisateur de saisir le numéro de ligne pour leur coup.
     *
     * @return Le numéro de la ligne choisie par l'utilisateur.
     * @throws CoupException Si la saisie de l'utilisateur n'est pas valide, par exemple si elle n'est pas un entier
     */
    public Integer saisrligne() throws CoupException;


    /**
     * Demande à l'utilisateur de saisir le numéro de colonne pour leur coup.
     *
     * @return Le numéro de la colonne choisie par l'utilisateur.
     * @throws CoupException Si la saisie de l'utilisateur n'est pas valide, par exemple si elle n'est pas un entier.
     */
    public Integer saisirColonne() throws CoupException;



    /**
     * Affiche un message annonçant le gagnant du jeu.
     * Cette méthode est appelée à la fin du jeu pour annoncer le résultat final.
     */
    public void afficherGagnant();

}
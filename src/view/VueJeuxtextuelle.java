package view;
import controller.ControleurJeux;
import controller.ControleurMorpion;
import controller.ControleurPuissanceQuatre;


import model.ModeleJeux;
import utils.CoupException;
import utils.Marqueur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Implémentation textuelle de la vue pour les jeux, affichant l'état du jeu et gérant les interactions utilisateur
 * dans une interface de console.
 */
public class VueJeuxtextuelle implements VueJeux,Observateur{
    private ControleurJeux controleur ;
    private ModeleJeux modele;

    /**
     * Constructeur de VueJeuxTextuelle.
     * Initialise la vue avec le contrôleur et le modèle de jeu donnés, et s'abonne aux mises à jour du modèle.
     *
     * @param controleur Le contrôleur de jeu associé à cette vue.
     * @param m Le modèle de jeu utilisé
     */
    public VueJeuxtextuelle(ControleurJeux controleur, ModeleJeux m) {
        this.controleur = controleur;
        this.modele = m;
        this.modele.ajouterObservateur(this);
    }

    /**
     * Met à jour et affiche l'état actuel de la grille de jeu.
     * Cette méthode est appelée chaque fois qu'une mise à jour de l'état du jeu est nécessaire.
     */
    @Override
    public void actualiser() {
        this.afficherGrille();
    }



    /**
     * Active la vue, affichant initialement l'état de la grille de jeu.
     */
    @Override
    public void activerVue() {
        this.afficherGrille();
    }

    /**
     * Affiche un message d'erreur en cas de coup invalide.
     */
    @Override
    public void afficherErreurSaisirCoup() {
        System.out.println("Coup pas valide, essaye un autre");
    }



    /**
     * Affiche la grille de jeu actuelle, avec des indices pour les lignes et les colonnes pour faciliter la saisie d'un coup par l'utilisateur.
     * Utilise l'état actuel du modèle de jeu pour afficher chaque cellule de la grille.
     */
    @Override
    public void afficherGrille() {
        Marqueur[][] grille = this.modele.getGrille();
        System.out.println("Grille du " + "jeu" + " :");

        // Afficher les indices de colonne en haut
        System.out.print("   ");
        for (int j = 0; j < grille[0].length; j++) {
            System.out.print(" " + j  + "  ");
        }
        System.out.println();

        // Calculer la longueur de la ligne de séparation en fonction de la largeur de la grille
        String ligneSeparation = "   " + IntStream.range(0, grille[0].length)
                .mapToObj(i -> "---")
                .collect(Collectors.joining("+"));

        for (int i = 0; i < grille.length; i++) {
            // Afficher l'indice de ligne avant chaque ligne
            System.out.print(i  + " ");
            if (i < 9) {
                System.out.print(" ");
            }
            for (int j = 0; j < grille[i].length; j++) {
                // Afficher le contenu de la cellule
                System.out.print(" " + grille[i][j] + " ");
                if (j < grille[i].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < grille.length - 1) {
                System.out.println(ligneSeparation);
            }
        }
    }



    /**
     * Invite l'utilisateur à saisir un coup.
     * Cette méthode délègue au contrôleur la gestion de la saisie d'un coup.
     */
    @Override
    public void saisrCoup() {
        this.controleur.jouerTour();
    }


    /**
     * demande à l'utilisateur de saisir un numéro de ligne.
     *
     * @return Le numéro de ligne saisi par l'utilisateur.
     * @throws CoupException Si l'entrée n'est pas un numéro valide.
     */
    @Override
    public Integer saisrligne() throws CoupException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Saisir ligne: ");

        try {
            int ligne = scanner.nextInt();
            return ligne;
        } catch (java.util.InputMismatchException e) {
            throw new CoupException("Indice de la ligne doit etre un entier");
        }
    }



    /**
     * demande à l'utilisateur de saisir un numéro de colonne.
     *
     * @return Le numéro de colonne saisi par l'utilisateur.
     * @throws CoupException Si l'entrée n'est pas un numéro valide.
     */
    @Override
    public Integer saisirColonne() throws CoupException{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Saisir colonne: ");

        try {
            int colonne = scanner.nextInt();
            return colonne;
        } catch (java.util.InputMismatchException e) {
            throw new CoupException("Indice de la colonne doit etre un entier");
        }
    }


    /**
     * Affiche le joueur gagnant à la fin du jeu.
     * Utilise l'état actuel du modèle de jeu pour déterminer le joueur gagnant.
     */
    @Override
    public void afficherGagnant() {
        System.out.println("Le "+this.modele.actuelJoueur() + " a gagné");
    }
}



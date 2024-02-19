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

public class VueJeuxtextuelle implements VueJeux,Observateur{
    private ControleurJeux controleur ;
    private ModeleJeux modele;
    public VueJeuxtextuelle(ControleurJeux controleur, ModeleJeux m) {
        this.controleur = controleur;
        this.modele = m;
        this.modele.ajouterObservateur(this);
    }

    @Override
    public void actualiser() {
        this.afficherGrille();
    }


    @Override
    public void activerVue() {
        this.afficherGrille();
    }

    @Override
    public void afficherErreurSaisirCoup() {
        System.out.println("Coup pas valide, essaye un autre");
    }

    @Override
    public void afficherGrille() {
        Marqueur[][] grille = this.modele.getGrille();
        System.out.println("Grille du " + "jeu" + " :");
        // Afficher les indices de colonne en haut
        System.out.print("   "); // Espace pour aligner avec les indices de ligne
        for (int j = 0; j < grille[0].length; j++) {
            System.out.print(" " + j  + "  "); // Assurez-vous que l'espacement correspond à celui des cellules
        }
        System.out.println(); // Nouvelle ligne après les indices de colonne

        // Calculer la longueur de la ligne de séparation en fonction de la largeur de la grille
        String ligneSeparation = "   " + IntStream.range(0, grille[0].length)
                .mapToObj(i -> "---")
                .collect(Collectors.joining("+"));

        for (int i = 0; i < grille.length; i++) {
            // Afficher l'indice de ligne avant chaque ligne
            System.out.print(i  + " "); // Ajouter un espace pour aligner si nécessaire
            if (i < 9) { // Pour l'alignement quand i a deux chiffres
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

    @Override
    public void saisrCoup() {
        this.controleur.jouerTour();
    }

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

    @Override
    public void afficherGagnant() {
        System.out.println("Le "+this.modele.actuelJoueur() + " a gagné");
    }
}



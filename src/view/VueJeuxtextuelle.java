package view;
import controller.ControleurJeux;
import controller.ControleurMorpion;
import controller.ControleurPuissanceQuatre;


import model.ModeleJeux;
import utils.Marqueur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        while (!this.modele.partieFinie()){
            this.saisrCoup();
        }
    }

    @Override
    public void afficherErreurSaisirCoup() {
        System.out.println("Coup pas valide, essaye un autre");
    }

    @Override
    public void afficherGrille() {
        Marqueur[][] grille = this.modele.getGrille();
        System.out.println("Grille de " + "Morpion" + " :");
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                System.out.print(grille[i][j]);
                if (j < grille[i].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < grille.length - 1) {
                System.out.println("---------");
            }
        }
    }

    @Override
    public void saisrCoup() {
        this.controleur.jouerTour();
    }

    @Override
    public Integer saisrligne() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Saisir ligne: ");
        int ligne = scanner.nextInt();
        return ligne;
    }

    @Override
    public Integer saisirColonne() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Saisir colonne: ");
        int colonne = scanner.nextInt();
        return colonne;
    }

    @Override
    public void afficherGagnant() {
        System.out.println("Le "+this.modele.actuelJoueur() + " a gagné");
    }
}



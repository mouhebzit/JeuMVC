import controller.ControleurJeux;
import controller.ControleurMorpion;
import controller.ControleurPuissanceQuatre;
import model.ModeleJeux;
import model.ModeleMorpion;
import model.ModelePuissanceQuatre;
import utils.Joueur;
import view.VueJeux;
import view.VueJeuxtextuelle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            int choice = getChoixMenu();
            switch (choice) {
                case 1:
                    ModeleJeux morpion = new ModeleMorpion(Joueur.JOUEUR1,Joueur.JOUEUR2);
                    ControleurJeux controleur = new ControleurMorpion(morpion);
                    VueJeux vue = new VueJeuxtextuelle(controleur,morpion);

                    controleur.setVue(vue);
                    controleur.demarrerJeu();
                    break;
                case 2:
                    ModeleJeux puissanceQuatre = new ModelePuissanceQuatre(Joueur.JOUEUR1,Joueur.JOUEUR2);
                    ControleurJeux controleurPuissanceQuatre = new ControleurPuissanceQuatre(puissanceQuatre);
                    VueJeux vuePuissanceQuatre = new VueJeuxtextuelle(controleurPuissanceQuatre,puissanceQuatre);

                    controleurPuissanceQuatre.setVue(vuePuissanceQuatre);
                    controleurPuissanceQuatre.demarrerJeu();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix non valide, veuillez réessayer.");
            }
        }
    }
    private static int getChoixMenu() {
        System.out.println("Choisi un jeu:");
        System.out.println("1 - Morpion");
        System.out.println("2 - Puissance4");
        System.out.println("0 - Sortir");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
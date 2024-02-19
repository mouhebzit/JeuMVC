package view;


/**
 * Interface Observateur définissant la méthode de notification d'actualisation.
 * Les classes implémentant cette interface peuvent s'abonner à des sujets qui sont des modèles de jeu
 * pour être notifiées des changements d'état afinde mettre à jour leur affichage.
 */
public interface Observateur {

    /**
     * Méthode appelée pour notifier l'observateur d'une actualisation nécessaire.
     * Cette méthode doit être implémentée par toutes les classes concrètes souhaitant recevoir des notifications
     * de changements.
     */
    public void actualiser();
}

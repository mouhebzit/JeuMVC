package view;

import utils.CoupException;

public interface VueJeux{

    public void activerVue();
    public void afficherErreurSaisirCoup();
    public void afficherGrille();
    public void saisrCoup();
    public Integer saisrligne() throws CoupException;
    public Integer saisirColonne() throws CoupException;
    public void afficherGagnant();

}
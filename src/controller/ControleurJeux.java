package controller;

import view.VueJeux;

public interface ControleurJeux {
    public void setVue(VueJeux vue);

    public void jouerTour();

    public void gererSaisirCoup();
}

package utils;

public enum Marqueur {
    CROIX,
    CERCLE,
    VIDE;

    @Override
    public String toString() {
        if (this.equals(Marqueur.VIDE))
            return " ";
        else if (this.equals(Marqueur.CERCLE)) {
            return "O";
        } else if (this.equals(Marqueur.CROIX)) {
            return "X";
        }
        return null;
    }
}

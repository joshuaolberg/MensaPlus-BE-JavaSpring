package de.leuphana.mensaplus.model;

public enum EssenArt {
    mit_Fleisch("mit Fleisch"),
    mit_Fisch("mit Fisch"),
    vegetarisch("vegetarisch"),
    vegan("vegan");

    private String essenArt;

    EssenArt(String essenArt) {
        this.essenArt = essenArt;
    }

    @Override
    public String toString() {
        return this.essenArt;
    }
}


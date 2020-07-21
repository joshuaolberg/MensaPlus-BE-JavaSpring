package de.leuphana.mensaplus.model;


import java.util.HashMap;
import java.util.Map;

public enum Wochentag {
    Montag(0), Dienstag(1), Mittwoch(2), Donnerstag(3), Freitag(4);

    private int value;
    private static Map map = new HashMap<>();

    private Wochentag(int value) {
        this.value = value;
    }

    static {
        for (Wochentag wochentag : Wochentag.values()) {
            map.put(wochentag.value, wochentag);
        }
    }

    public static Wochentag valueOf(int wochentag) {
        return (Wochentag) map.get(wochentag);
    }

    public int getValue() {
        return value;
    }


}

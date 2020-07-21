package de.leuphana.mensaplus.model;

import org.hibernate.annotations.SortNatural;

import javax.persistence.*;
import java.util.*;

@Entity
public class Essensplan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int kalenderwoche;

    @ManyToMany(cascade = {CascadeType.ALL})
    @SortNatural
    private Map<Wochentag, Essen> essenProWoche = new TreeMap<>();

    public Essensplan() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setKalenderwoche(int kalenderwoche) {
        this.kalenderwoche = kalenderwoche;
    }

    public int getKalenderwoche() {
        return kalenderwoche;
    }

    public Map<Wochentag, Essen> getEssenProWoche() {
        return essenProWoche;
    }

    public void setMealsPerWeek(Map<Wochentag, Essen> essenProWoche) {
        this.essenProWoche = essenProWoche;
    }
}

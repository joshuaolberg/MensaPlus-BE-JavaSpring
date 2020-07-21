package de.leuphana.mensaplus.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Essen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private BigDecimal preis;
    private String art;

    public Essen() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPreis(BigDecimal preis) {
        this.preis = preis;
    }

    public BigDecimal getPreis() {
        return preis;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

}

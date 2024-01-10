package com.example.Rubrica.models;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "indirizzo")
public class Indirizzo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "via")
    private String via;
    @Column(name = "numeroCivico")
    private Integer numeroCivico;
    @Column(name = "citta")
    private String citta;
    @Column(name = "cap")
    private Integer cap;
    @Column(name = "provincia")
    private String provincia;

    public Indirizzo() {
    }

    public Indirizzo(Long id, String via, Integer numeroCivico, String citta, Integer cap, String provincia) {
        this.id = id;
        this.via = via;
        this.numeroCivico = numeroCivico;
        this.citta = citta;
        this.cap = cap;
        this.provincia = provincia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public Integer getNumeroCivico() {
        return numeroCivico;
    }

    public void setNumeroCivico(Integer numeroCivico) {
        this.numeroCivico = numeroCivico;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public Integer getCap() {
        return cap;
    }

    public void setCap(Integer cap) {
        this.cap = cap;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Via: " + via + "\n" + "N : " + numeroCivico + "\n" + "Città: " + citta + "\n" +
                "Cap: " + cap + "\n" + "Provincia: " + provincia + "\n";
    }
}

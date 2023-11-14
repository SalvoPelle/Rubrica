package com.example.Rubrica.models;

public class Indirizzo {
    private String via;
    private Integer numeroCivico;
    private String citta;
    private Integer cap;
    private String provincia;

    public Indirizzo() {
    }

    public Indirizzo(String via, Integer numeroCivico, String citta, Integer cap, String provincia) {
        this.via = via;
        this.numeroCivico = numeroCivico;
        this.citta = citta;
        this.cap = cap;
        this.provincia = provincia;
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

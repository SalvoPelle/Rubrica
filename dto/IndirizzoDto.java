package com.example.Rubrica.dto;

public class IndirizzoDto {

    private String via;
    private Integer numeroCivico;
    private String citta;
    private Integer cap;
    private String provincia;

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
}

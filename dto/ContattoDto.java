package com.example.Rubrica.dto;

import com.example.Rubrica.models.Indirizzo;

public class ContattoDto {
    private Long id;
    private String name;
    private String surname;
    private Integer cell;
    private String email;
    private IndirizzoDto address;
    private String company;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getCell() {
        return cell;
    }

    public void setCell(Integer cell) {
        this.cell = cell;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public IndirizzoDto getAddress() {
        return address;
    }

    public void setAddress(IndirizzoDto address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}

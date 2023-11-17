package com.example.Rubrica.models;

import jakarta.persistence.*;

@Entity
@Table(name = "contatto")
public class Contatto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "cell")
    private Integer cell;
    @Column(name = "email")
    private String email;
    @OneToOne
    @JoinColumn(name = "indirizzo_id", nullable = true)
    private Indirizzo address;
    private String company;

    public Contatto() {
    }

    public Contatto(Long id, String name, String surname, Integer cell, String email, Indirizzo address, String company) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.cell = cell;
        this.email = email;
        this.address = address;
        this.company = company;
    }

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

    public Indirizzo getAddress() {
        return address;
    }

    public void setAddress(Indirizzo address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        if (address == null){
            return "Name: " + name + "\n" + "Surname:" + surname + "\n" +
                    "Cell:" + "\n" + cell + "\n" + "email:" + email;
        }
        return "Name: " + name + "\n" + "Surname:" + surname + "\n" +
                "Cell:" + "\n" + cell + "\n" + "email:" + email +
                ", address:" + address;
    }
}

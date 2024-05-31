package com.example.demo.modele;

import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
public class Reclamation {
    public Reclamation(int id, String description, comptes compte) {
        this.id = id;
        this.description = description;
        this.compte = compte;
    }

    public Reclamation() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String description;
    @ManyToOne
    @JoinColumn(name = "comptes_id")
    private comptes compte;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public comptes getCompte() {
        return compte;
    }

    public void setCompte(comptes compte) {
        this.compte = compte;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


}


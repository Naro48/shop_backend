package com.example.demo.modele;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categorie")
public class categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String catname;
    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    private List<produit> products;

    public categorie(int id, String catname) {
        this.id = id;
        this.catname = catname;
    }

    public categorie() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public List<produit> getProducts() {
        return products;
    }

    public void setProducts(List<produit> products) {
        this.products = products;
    }
}


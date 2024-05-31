package com.example.demo.modele;
import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name ="panier")
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="account_id")
    private comptes compte;
    @ManyToOne
    @JoinColumn(name="commande_id")
    private commande commandes;
    @ManyToOne
    @JoinColumn(name="product_id")
    private produit prod;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public comptes getCompte() {
        return compte;
    }
    public void setCompte(comptes compte) {
        this.compte = compte;
    }
    public commande getCommandes() {
        return commandes;
    }
    public void setCommandes(commande commandes) {
        this.commandes = commandes;
    }
    public produit getProd() {
        return prod;
    }
    public void setProd(produit prod) {
        this.prod = prod;
    }
    public Panier() {
    }
    public Panier(int id, comptes compte, commande commandes, produit prod) {
        this.id = id;
        this.compte = compte;
        this.commandes = commandes;
        this.prod = prod;
    }
    @Override
    public String toString() {
        return "Panier{" +
                "id=" + id +
                ", compte=" + compte +
                ", commandes=" + commandes +
                ", prod=" + prod +
                '}';
    }
}
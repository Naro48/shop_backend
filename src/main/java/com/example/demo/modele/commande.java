package com.example.demo.modele;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name ="commands")
public class commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String dateLivraison;
    @Column
    private String lieuLivraison;
    @Column
    private String méthodePaiement;
    @Column
    private Boolean delivered;
    @Column
    private int quantity;
    @Column
    private Boolean confirmed;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private produit p;
    @ManyToOne
    @JoinColumn(name="customer_id")
    private comptes compte;
    @ManyToOne
    @JoinColumn(name="deliveryman_id")
    private comptes deliveryman;

    public commande() {
    }
    public commande(int id,comptes deliveryman, int quantity, produit p, comptes compte, String dateLivraison, String lieuLivraison, String méthodePaiement, Boolean delivered) {
        this.id = id;
        this.compte = compte;
        this.dateLivraison = dateLivraison;
        this.lieuLivraison = lieuLivraison;
        this.méthodePaiement = méthodePaiement;
        this.delivered = delivered;
        this.p=p;
        this.quantity= quantity;
        this.deliveryman=deliveryman;
    }
    public int getId() {
        return id;
    }

    public comptes getDeliveryman() {
        return deliveryman;
    }

    public void setDeliveryman(comptes deliveryman) {
        this.deliveryman = deliveryman;
    }

    public comptes getCompte() {
        return compte;
    }
    public String getDateLivraison() {
        return dateLivraison;
    }
    public String getLieuLivraison() {
        return lieuLivraison;
    }
    public String getMéthodePaiement() {
        return méthodePaiement;
    }
    public Boolean isDelivered() {
        return delivered;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setCompte(comptes compte) {
        this.compte = compte;
    }
    public void setDateLivraison(String dateLivraison) {
        this.dateLivraison = dateLivraison;
    }
    public void setLieuLivraison(String lieuLivraison) {
        this.lieuLivraison = lieuLivraison;
    }
    public void setMéthodePaiement(String méthodePaiement) {
        this.méthodePaiement = méthodePaiement;
    }
    public void setDelivered(Boolean delivered) {
        this.delivered = delivered;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public produit getP() {
        return p;
    }

    public void setP(produit p) {
        this.p = p;
    }

    public Boolean getDelivered() {
        return delivered;
    }

    @Override
    public String toString() {
        return "commande{" +
                "id=" + id +
                ", compte=" + compte +
                ", dateLivraison='" + dateLivraison + '\'' +
                ", lieuLivraison='" + lieuLivraison + '\'' +
                ", méthodePaiement='" + méthodePaiement + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        commande commande = (commande) o;
        return id == commande.id && Objects.equals(compte, commande.compte) && Objects.equals(dateLivraison, commande.dateLivraison) && Objects.equals(lieuLivraison, commande.lieuLivraison) && Objects.equals(méthodePaiement, commande.méthodePaiement);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, compte, dateLivraison, lieuLivraison, méthodePaiement);
    }
}
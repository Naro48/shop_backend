package com.example.demo.modele;


import jakarta.persistence.*;
import jakarta.persistence.Id;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "comptes")
public class comptes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String email;
    private int phone;
    private String password;
    private String type;
    private String photo;
    private String nom;
    private String filiere;
    @OneToMany(mappedBy = "compte", cascade = CascadeType.ALL)
    private List<Panier> paniers;
    @OneToMany(mappedBy = "compte", cascade = CascadeType.ALL)
    private List<commande> commandes;
    @OneToMany(mappedBy = "deliveryman", cascade = CascadeType.ALL)
    private List<commande> commandesd;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getFiliere() {
        return filiere;
    }
    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }
    public comptes(int id, String username, String email, int phone, String password, String type, String photo,String filiere,String nom){
        this.id=id;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.type = type;
        this.photo = photo;
        this.filiere= filiere ;
        this.nom = nom ;
    }
    public comptes(){
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        comptes comptes = (comptes) o;
        return id == comptes.id && phone == comptes.phone && Objects.equals(username, comptes.username) && Objects.equals(email, comptes.email) && Objects.equals(password, comptes.password) && Objects.equals(type, comptes.type) && Objects.equals(photo, comptes.photo) && Objects.equals(nom, comptes.nom) && Objects.equals(filiere, comptes.filiere) && Objects.equals(commandes, comptes.commandes);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, phone, password, type, photo, nom, filiere, commandes);
    }

    @Override
    public String toString() {
        return "comptes{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", photo='" + photo + '\'' +
                ", nom='" + nom + '\'' +
                ", filiere='" + filiere + '\'' +
                ", commandes=" + commandes +
                '}';
    }
}
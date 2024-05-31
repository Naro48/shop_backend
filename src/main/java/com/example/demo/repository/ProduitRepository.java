package com.example.demo.repository;

import com.example.demo.modele.categorie;
import com.example.demo.modele.produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<produit, Long> {
    int countByCategorie(categorie cat );

}

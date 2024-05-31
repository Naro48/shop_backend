package com.example.demo.repository;

import com.example.demo.modele.categorie;
import com.example.demo.modele.produit;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategorieRepository extends JpaRepository<categorie, Long> {
    boolean existsByCatname(String catname);
    categorie findCategorieByCatname(String name);
}

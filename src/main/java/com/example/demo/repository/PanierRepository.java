package com.example.demo.repository;
import com.example.demo.modele.Panier;
import com.example.demo.modele.comptes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  PanierRepository extends JpaRepository<Panier, Long> {
    List<Panier> findByCompteUsername(String username);
}

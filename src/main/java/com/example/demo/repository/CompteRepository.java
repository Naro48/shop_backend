package com.example.demo.repository;


import com.example.demo.modele.comptes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  CompteRepository extends JpaRepository<comptes, Long> {
    comptes findByUsername(String username);
    comptes findByUsernameAndPassword(String username, String password);
    int countByType(String type);
    int countByFiliere(String fill);
    List<comptes> findAllByType(String type);
}

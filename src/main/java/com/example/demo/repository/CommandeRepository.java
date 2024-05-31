package com.example.demo.repository;


import com.example.demo.modele.commande;
import com.example.demo.modele.comptes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeRepository extends JpaRepository<commande, Long> {
int countCommandesByCompte(comptes compte);
List<commande> findAllByDelivered(Boolean delivered);
List<commande> findAllByDeliveredAndDateLivraison(Boolean delivered, String dateLivraison);
List<commande> findByDateLivraisonContaining(String keyword);
int countByCompte_Filiere(String filiere);

}

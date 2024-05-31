package com.example.demo.repository;
import com.example.demo.modele.Order;
import com.example.demo.modele.Panier;
import com.example.demo.modele.commande;
import com.example.demo.modele.comptes;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface OrderRepository extends JpaRepository<Order, Long> {
}


package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.example.demo.controller.ProduitController;
import com.example.demo.modele.produit;
import com.example.demo.service.ProduitService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
@ContextConfiguration(classes = {ProduitService.class, ProduitController.class})
public class testcontroller {

    @InjectMocks
    private ProduitService produitService;

    @Test
    public void testGetAllProduits() {
        List<produit> produits = produitService.getAllProduits();
        }
    // Similarly, you can write tests for other methods like getProduitById, createProduit, updateProduit, deleteProduit
}

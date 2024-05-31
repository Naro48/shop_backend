package com.example.demo;

import com.example.demo.controller.CategorieController;
import com.example.demo.controller.ProduitController;
import com.example.demo.modele.categorie;
import com.example.demo.modele.produit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = DemoApplication.class)
class DemoApplicationTests {
	private ProduitController produitController;

	@BeforeEach
	void setUp() {
		produitController = new ProduitController();
	}

	@Test
	void contextLoads() {
		// Your existing test method
	}

}
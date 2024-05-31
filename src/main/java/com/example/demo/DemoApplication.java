package com.example.demo;

import com.example.demo.controller.CategorieController;
import com.example.demo.controller.ProduitController;
import com.example.demo.controller.ComptesController;
import com.example.demo.service.CommandeService;
import com.example.demo.service.ComptesService;
import com.example.demo.service.ProduitService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	private static ProduitService produitService=null;
	private static ProduitController produitController=null;
	private static CategorieController categorieController=null;
	private static ComptesController ComptesController=null;
	private static ComptesService DaoComptes=null;
	private static CommandeService cs=null;


	public DemoApplication(ProduitService produitService, CommandeService cs , ProduitController produitController, CategorieController categorieController, ComptesController ComptesController, ComptesService DaoComptes) {
		this.produitService = produitService;
		this.produitController = produitController;
		this.categorieController = categorieController;
		this.ComptesController = ComptesController;
		this.DaoComptes = DaoComptes;
		this.cs=cs;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		//testDeleteProduct();
		//testAddProduct();
		//testUpdateProduct();
		//testGetAllProducts();
		//testAddCategory();
		//testDeleteCategory();
		//testLogin();
		test();


		// Test des fonctionnalités pour les comptes
		//testdeleteComptes();
		//testAddComptes();
		//testupdateComptes();
		//testgetAllAccs();

	}
	// This method can be used for testing purposes
	/*public static void testGetAllProducts() {
		List<produit> all = produitController.getAllProduits();
		System.out.println(all);
	}*/
/*	public static void testDeleteProduct() {
		int id = 4;
    if(produitService.deleteProduit(4)) {
		System.out.println("Le produit n°:" + id + "\t a été supprimé avec succés");
	}
	else{
		System.out.println("Le produit n°:" + id + "\t n'existe pas!");
	}
	}*/
	/*public static void testAddProduct() {
		produit p1 = new produit(0,"Adkd",1,"","","",null);
		if(produitController.addProduct(p1)) {
			System.out.println("Le produit:" + p1 + "\t a été ajouté avec succés");
		}
		else{
			System.out.println("Erreur lors de l'ajout!");
		}
	}*/

	/*public static void testUpdateProduct() {
		int idProduitAModifier=2;
		produit prod = new produit(0,"",1,"fgh","","",null);
		if(produitController.updateProduit(idProduitAModifier,prod)){
		System.out.println("Le produit a été mis à jour");
	}
		else{
		System.out.println("Erreur!");
	}
	}*/

	//---------------Catégories--------------------


	/*public static void testAddCategory() {
		String name = "Aero";
		categorie c = new categorie(1,name);
=========
	public static void testAddCategory() {
		String name = "";
		categorie c = new categorie(0,name);
>>>>>>>>> Temporary merge branch 2
		if((categorieController.addCategorie(c))) {
			System.out.println("La categorie:" + c + "\t a été ajouté avec succés");
		}
		else{
			System.out.println("Erreur lors de l'ajout!");
		}
	}*/

	/*public static void testDeleteCategory() {
		int id = 4;
		if(categorieController.deleteCategorie(id)) {
			System.out.println("La catégorie n°:" + id + "\t a été supprimée avec succés");
		}
		else{
			System.out.println("Le catégorie n°:" + id + "\t n'existe pas!");
		}
	}*/
	/*public static void testGetAllCategories() {
		List<categorie> all = categorieController.getAllCategories();
		System.out.println(all);
	}*/
	/*public static void testLogin(){
		String username="usr";
		String password="psw";
		Comptes c = new Comptes();
		c.setPassword(password);
		c.setUsername(username);
		if(lc.Compte(c)){
			System.out.println("yes");
		}
	}*/
	/*public static void testgetAllAccs() {
		ComptesController ComptesController = null;
		List<Comptes> all = ComptesController.getAllAccs();
		System.out.println(all);
	}*/

	/*public static  void testdeleteComptes() {
		int id = 4;
		if (ComptesController.deleteComptes(id)) {
			System.out.println("Le compte n°:" + id + "\t a été supprimé avec succès");
		} else {
			System.out.println("Le compte n°:" + id + "\t n'existe pas!");
		}
	}*/

	/*public static void testAddComptes() {
		Comptes compte = new Comptes(0, "email@example.com", "INFO", "test", "password", 0666666666, "photo", "tester", "username");
		if (ComptesController.addComptes((Comptes) compte)) {
			System.out.println("Le compte a été ajouté avec succès");
		} else {
			System.out.println("Erreur lors de l'ajout du compte!");
		}
	}
	public static void testupdateComptes() {
		int idCompteAModifier = 2;
		Comptes compte = new Comptes(0, "email@example.com", "INFO", "test", "password", 0666666666, "photo", "tester", "username");
		if (ComptesController.updateComptes(idCompteAModifier, compte)) {
			System.out.println("Le compte a été mis à jour");
		} else {
			System.out.println("Erreur lors de la mise à jour du compte!");
		}
	}*/
	public static void test(){
		String filiere="hh";
		int count = cs.countCommByfiliere(filiere);
		System.out.println(count);
	}
}
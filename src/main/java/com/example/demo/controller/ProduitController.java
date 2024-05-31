package com.example.demo.controller;

import com.example.demo.modele.categorie;
import com.example.demo.modele.comptes;
import com.example.demo.modele.produit;
import com.example.demo.service.CategorieService;
import com.example.demo.service.CommandeService;
import com.example.demo.service.ComptesService;
import com.example.demo.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProduitController {

    @Autowired
    private ProduitService produitService;
    @Autowired
    private CategorieService catService;
    @Autowired
    private CategorieService categorieService;
    @Autowired
    private ComptesService daoComptes;
    @Autowired
    private CommandeService commandeService;


    @GetMapping("/catalogue")
    public String getAllProduits(Model model) {
        List<produit> produits = produitService.getAllProduits();
        model.addAttribute("all",produits);
        List<categorie> c = catService.getAllCategories();
        model.addAttribute("allc", c);
        return "shop";
    }

    @GetMapping("/viewdetails")
    public String details(@RequestParam int id) {
        // Redirect to the singleproduct endpoint with the provided ID
        return "redirect:/products/singleproduct/" + id;
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestParam String label, @RequestParam int price, @RequestParam String color,
                             @RequestParam String photo, @RequestParam String size, @RequestParam int categoryId, @RequestParam int stock,@RequestParam String description) {
        // Fetch the category object by ID
        Optional<categorie> categoryOptional = catService.getCategoryById(categoryId);

            categorie category = categoryOptional.get();

            // Create a product object and set its properties
            produit product = new produit();
            product.setLabel(label);
            product.setPrice(price);
            product.setColor(color);
            product.setPhoto(photo);
            product.setSize(size);
            product.setQuantity(stock);
            product.setDescription(description);

            // Set the category for the product
            product.setCategorie(category);

            // Save the product to the database
            produitService.createProduit(product);

            // Redirect to the desired page
            return "redirect:/products/products";
    }

    @PostMapping("/modify")
    public String modify(@RequestParam int id, @RequestParam String label, @RequestParam String description,
                         @RequestParam int stock, @RequestParam double price, @RequestParam String color,
                         @RequestParam String size, @RequestParam String category) {
        produit updated = new produit();
        updated.setLabel(label);
        updated.setDescription(description);
        updated.setColor(color);
        updated.setQuantity(stock);
        updated.setSize(size);
        updated.setPrice(price);
        categorie c = new categorie();
        c.setCatname(category);
        updated.setCategorie(c);
        boolean isModified = produitService.updateProduit(id,updated);
        if (isModified) {
            System.out.println("Product modified successfully.");
        } else {
            System.out.println("Failed to modify product.");
        }

        return "redirect:/products/products";
    }



    @GetMapping("/singleproduct/{id}")
    public String getSingleProduct(Model model, @PathVariable("id") int id) {
        Optional<produit> optionalProduct = produitService.getProduitById((long)id);

        // Check if the product exists
        if (optionalProduct.isPresent()) {
            produit product = optionalProduct.get();
            model.addAttribute("oneproduct", product);
            return "command";
        } else {
            // Handle case when product with given ID is not found
            // You can redirect to an error page or handle it based on your application's requirements
            return "error"; // Assuming you have an "error" template
        }
    }

    @PutMapping("/{id}")
    public boolean updateProduit(@PathVariable int id, @RequestBody produit updatedProduit) {
        return produitService.updateProduit(id, updatedProduit);
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id) {

            boolean isDeleted = produitService.deleteProduit(id);
            if (isDeleted) {
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("Failed to delete product.");
            }

        return "redirect:/products/products";
    }


    @GetMapping("/products")
    public String countProducts(Model model) {
        //All products
        int productCount = produitService.countProduits();
        model.addAttribute("productCount", ""+productCount);
        //Archi
        categorie archi = categorieService.findCategorieByName("Archi");
        int countArchi = produitService.countProduitsByCategorie(archi);
        model.addAttribute("archi", ""+countArchi);
        //Auto
        categorie auto = categorieService.findCategorieByName("Auto");
        int countAuto = produitService.countProduitsByCategorie(auto);
        model.addAttribute("auto", ""+countAuto);
        //Aero
        categorie aero = categorieService.findCategorieByName("Aero");
        int countAero = produitService.countProduitsByCategorie(aero);
        model.addAttribute("aero", ""+countAero);
        //CS
        categorie cs = categorieService.findCategorieByName("CS");
        int countCS = produitService.countProduitsByCategorie(cs);
        model.addAttribute("cs", ""+countCS);
        //Dentaire
        categorie dentistry = categorieService.findCategorieByName("Dentistry");
        int countDentistry = produitService.countProduitsByCategorie(dentistry);
        model.addAttribute("dentistry", ""+countDentistry);
        //Générale
        categorie medecine = categorieService.findCategorieByName("Medecine");
        int countMedecine = produitService.countProduitsByCategorie(medecine);
        model.addAttribute("medecine", ""+countMedecine);
        //Energie
        categorie energie = categorieService.findCategorieByName("Energy");
        int countEnergie = produitService.countProduitsByCategorie(energie);
        model.addAttribute("energie", ""+countEnergie);
        //No category
        categorie all = categorieService.findCategorieByName("All");
        int countAll = produitService.countProduitsByCategorie(all);
        model.addAttribute("nocat", ""+countAll);
        //getall
        List<produit> produits = produitService.getAllProduits();
        model.addAttribute("all",produits);
        List<categorie> c = catService.getAllCategories();
        model.addAttribute("allc",c);


        List<String> productNames = new ArrayList<>();
        List<Double> productRatings = new ArrayList<>();

        for (produit produit : produits) {
            productNames.add(produit.getLabel());
            productRatings.add(produit.getRating());
        }

        model.addAttribute("productNames", productNames);
        model.addAttribute("productRatings", productRatings);
        return "dashboard_products";
    }

    @GetMapping("/analytics")
    public String analytics(Model model) {
        //All products
        int productCount = produitService.countProduits();
        model.addAttribute("productCount", ""+productCount);
        //Archi
        categorie archi = categorieService.findCategorieByName("Archi");
        int countArchi = produitService.countProduitsByCategorie(archi);
        model.addAttribute("archi", ""+countArchi);
        //Auto
        categorie auto = categorieService.findCategorieByName("Auto");
        int countAuto = produitService.countProduitsByCategorie(auto);
        model.addAttribute("auto", ""+countAuto);
        //Aero
        categorie aero = categorieService.findCategorieByName("Aero");
        int countAero = produitService.countProduitsByCategorie(aero);
        model.addAttribute("aero", ""+countAero);
        //CS
        categorie cs = categorieService.findCategorieByName("CS");
        int countCS = produitService.countProduitsByCategorie(cs);
        model.addAttribute("cs", ""+countCS);
        //Dentaire
        categorie dentistry = categorieService.findCategorieByName("Dentistry");
        int countDentistry = produitService.countProduitsByCategorie(dentistry);
        model.addAttribute("dentistry", ""+countDentistry);
        //Medecine
        categorie medecine = categorieService.findCategorieByName("Medecine");
        int countMedecine = produitService.countProduitsByCategorie(medecine);
        model.addAttribute("medecine", ""+countMedecine);
        //Energie
        categorie energie = categorieService.findCategorieByName("Energy");
        int countEnergie = produitService.countProduitsByCategorie(energie);
        model.addAttribute("energie", ""+countEnergie);
        //Générale
        categorie all = categorieService.findCategorieByName("All");
        int countAll = produitService.countProduitsByCategorie(all);
        model.addAttribute("nocat", ""+countAll);
        //getall
        List<produit> produits = produitService.getAllProduits();
        model.addAttribute("all",produits);
        List<categorie> c = catService.getAllCategories();
        model.addAttribute("allc",c);

        //getRatings
        List<String> productNames = new ArrayList<>();
        List<Double> productRatings = new ArrayList<>();
        for (produit produit : produits) {
            productNames.add(produit.getLabel());
            productRatings.add(produit.getRating());
        }
        model.addAttribute("productNames", productNames);
        model.addAttribute("productRatings", productRatings);

        //getStock
        List<Integer> productQuantity = new ArrayList<>();
        for (produit produit : produits) {
            productNames.add(produit.getLabel());
            productQuantity.add(produit.getQuantity());
        }
        model.addAttribute("productQuantity", productQuantity);

        //getStock
        List<comptes> comptes = daoComptes.getAllAccs();
        List<String> accountName = new ArrayList<>();
        List<Integer> numOfCommands = new ArrayList<>();

        for (comptes acc : comptes) {
            int com = commandeService.count(acc);
            accountName.add(acc.getNom());
            numOfCommands.add(com);
        }

        model.addAttribute("accNames", accountName);
        model.addAttribute("numOfCommands", numOfCommands);


        //getTypes
        int Delivery = daoComptes.countcompteByType("DeliveryMan");
        model.addAttribute("DeliveryMan",""+Delivery);
        int Supplier = daoComptes.countcompteByType("Supplier");
        model.addAttribute("Supplier",""+Supplier);
        int Student = daoComptes.countcompteByType("Student");
        model.addAttribute("Student",""+Student);
        int Admin = daoComptes.countcompteByType("Admin");
        model.addAttribute(" Admin",""+Admin);


        //fields
        int Architecture = daoComptes.countcompteByFiliere ("Architecture");
        model.addAttribute("Architecturstudents",""+Architecture);

        int CS = daoComptes.countcompteByFiliere ("CS");
        model.addAttribute("CSstudents",""+CS);

        int Energy = daoComptes.countcompteByFiliere ("Energy");
        model.addAttribute("Energystudents",""+Energy);
        int Aerospace = daoComptes.countcompteByFiliere ("Aerospace");
        model.addAttribute("Aerospacestudents",""+Aerospace);

        int Medicine = daoComptes.countcompteByFiliere ("Medecine");
        model.addAttribute("Medicinestudents",""+Medicine);

        int Automobile = daoComptes.countcompteByFiliere ("Automobile");
        model.addAttribute("Automobilestudents",""+Automobile);

        //benefit
        double chiffreAffaires=commandeService.calculateTotalBenefit();
        model.addAttribute("CA",""+chiffreAffaires);

        //benefitPerMonth
        double january = commandeService.calculateTotalBenefitPerMonth("January");
        model.addAttribute("january", "" + january);

        double february = commandeService.calculateTotalBenefitPerMonth("February");
        model.addAttribute("february", "" + february);

        double march = commandeService.calculateTotalBenefitPerMonth("March");
        model.addAttribute("march", "" + march);

        double april = commandeService.calculateTotalBenefitPerMonth("April");
        model.addAttribute("april", "" + april);

        double may = commandeService.calculateTotalBenefitPerMonth("May");
        model.addAttribute("may", "" + may);

        double june = commandeService.calculateTotalBenefitPerMonth("June");
        model.addAttribute("june", "" + june);

        double july = commandeService.calculateTotalBenefitPerMonth("July");
        model.addAttribute("july", "" + july);

        double august = commandeService.calculateTotalBenefitPerMonth("August");
        model.addAttribute("august", "" + august);

        double september = commandeService.calculateTotalBenefitPerMonth("September");
        model.addAttribute("september", "" + september);

        double october = commandeService.calculateTotalBenefitPerMonth("October");
        model.addAttribute("october", "" + october);

        double november = commandeService.calculateTotalBenefitPerMonth("November");
        model.addAttribute("november", "" + november);

        double december = commandeService.calculateTotalBenefitPerMonth("December");
        model.addAttribute("december", "" + december);

        //benefitPerYear
        double twentyfour= commandeService.calculateTotalBenefitPerMonth("2024");
        model.addAttribute("twentyfour", "" + twentyfour);
        double twentythree= commandeService.calculateTotalBenefitPerMonth("2023");
        model.addAttribute("twentythree", "" + twentythree);


        return "dashboard_analytics";
    }


}

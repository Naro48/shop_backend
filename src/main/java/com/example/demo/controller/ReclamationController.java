package com.example.demo.controller;

import com.example.demo.modele.Reclamation;
import com.example.demo.modele.categorie;
import com.example.demo.modele.comptes;
import com.example.demo.modele.produit;
import com.example.demo.service.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/reclamation")
public class ReclamationController {

    @Autowired
    private ReclamationService ReclamationSer;

    public ReclamationController(ReclamationService reclamationService) {
        this.ReclamationSer = reclamationService;
    }

    @GetMapping
    public List<Reclamation> getAllReclamations() {
        return ReclamationSer.getAllReclamations();
    }

    @GetMapping("/{username}")
    public List<Reclamation> getReclamationsByUsername(@PathVariable String username) {
        return ReclamationSer.getReclamationsByUsername(username);
    }

    @PostMapping("/addReclamation")
    public boolean createReclamation(@RequestBody Reclamation reclamation) {
        return ReclamationSer.createReclamation(reclamation);
    }

    @DeleteMapping("/{id}")
    public boolean deleteReclamation(@PathVariable int id) {
        ReclamationSer.deleteReclamation(id);
        return false;
    }
    @GetMapping("/count")
    public String countcomplaint(Model model) {
        // Récupérer le nombre total de comptes
        int countcomplaint = ReclamationSer.countcomplaint();
        model.addAttribute("countcomplaint", "" + countcomplaint);
        System.out.println("" + countcomplaint);
        // Renvoyer le nom de la vue à afficher


        int Delivery = ReclamationSer.countByCompte_Type ("DeliveryMan");
        model.addAttribute("DeliveryMan",""+Delivery);
        System.out.println("DeliveryMan"+Delivery);
        // Renvoyer le nom de la vue à afficher


        int Supplier = ReclamationSer.countByCompte_Type ("Supplier");
        model.addAttribute("Supplier",""+Supplier);
        System.out.println("Supplier"+Supplier);
        // Renvoyer le nom de la vue à afficher

        int Student = ReclamationSer.countByCompte_Type ("Student");
        model.addAttribute("Student",""+Student);
        System.out.println("Student"+Student);
        // Renvoyer le nom de la vue à afficher

        int Admin = ReclamationSer.countByCompte_Type ("Admin");
        model.addAttribute(" Admin",""+Admin);
        System.out.println("Admin"+Admin);
        // Renvoyer le nom de la vue à afficher



        int Architecture = ReclamationSer.countByCompte_Filiere ("Architecture");
        model.addAttribute("Architecturstudents",""+Architecture);
        System.out.println("Architecturstudents"+Architecture);

        int CS = ReclamationSer.countByCompte_Filiere ("CS");
        model.addAttribute("CSstudents",""+CS);
        System.out.println("CSstudents"+CS);

        int Energy = ReclamationSer.countByCompte_Filiere ("Energy");
        model.addAttribute("Energystudents",""+Energy);
        System.out.println("Energystudents"+Energy);

        int Aerospace = ReclamationSer.countByCompte_Filiere ("Aerospace");
        model.addAttribute("Aerospacestudents",""+Aerospace);
        System.out.println("Aerospacestudents"+Aerospace);

        int Medecine = ReclamationSer.countByCompte_Filiere ("Medecine");
        model.addAttribute("Medecinestudents",""+Medecine);
        System.out.println("Medecinestudents"+Medecine);

        int Automobile = ReclamationSer.countByCompte_Filiere ("Automobile");
        model.addAttribute("Automobilestudents",""+Automobile);
        System.out.println("Automobile"+Automobile);

        int Dentistry = ReclamationSer.countByCompte_Filiere ("Dentistry");
        model.addAttribute("Dentistrystudents",""+Dentistry);
        System.out.println("Dentistry"+Dentistry);


        List<Reclamation> reclamations = ReclamationSer.getAllReclamations();
        model.addAttribute("all",reclamations);






        return "dashboard_complaints";
    }
}

package com.example.demo.controller;

import com.example.demo.modele.categorie;
import com.example.demo.modele.commande;
import com.example.demo.modele.comptes;
import com.example.demo.modele.produit;
import com.example.demo.service.CategorieService;
import com.example.demo.service.CommandeService;
import com.example.demo.service.ProduitService;
import org.aspectj.bridge.ICommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/commande")
public class CommandeController {
    @Autowired
    private CommandeService commandeService;
    @GetMapping("/commande")
    public String getAll(Model model) {
        List<commande> c = commandeService.getAllComm();
        model.addAttribute("all",c);
        return "dashboard_commandes";
    }
    @GetMapping("/dashboard")
    public String getAllProduits(Model model) {
        List<commande> c = commandeService.getAllComm();
        model.addAttribute("all",c);
        return "General_livreur";
    }


}

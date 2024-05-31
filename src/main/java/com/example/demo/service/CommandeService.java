package com.example.demo.service;

import com.example.demo.modele.categorie;
import com.example.demo.modele.commande;
import com.example.demo.modele.comptes;
import com.example.demo.repository.CategorieRepository;
import com.example.demo.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    public int count(comptes c){
        return commandeRepository.countCommandesByCompte(c);
    }

    public List<commande> getAllComm() {
        return commandeRepository.findAll();
    }

    public double calculateTotalBenefit() {
        List<commande> commands = commandeRepository.findAllByDelivered(true);
        double totalBenefit = 0.0;
        for (commande command : commands) {
            double commandBenefit = command.getP().getPrice() * command.getQuantity();
            totalBenefit += commandBenefit;
        }
        return totalBenefit;
    }
    public double calculateTotalBenefitPerMonth(String substring) {
            double totalBenefit = 0.0;
            List<commande> commands = commandeRepository.findByDateLivraisonContaining(substring);
            for (commande command : commands) {
                if (command.isDelivered()) {
                    double commandBenefit = command.getP().getPrice() * command.getQuantity();
                    totalBenefit += commandBenefit;
                }
            }
        return totalBenefit;
    }

    public int countCommByfiliere(String filiere){
        return commandeRepository.countByCompte_Filiere(filiere);
    }


}

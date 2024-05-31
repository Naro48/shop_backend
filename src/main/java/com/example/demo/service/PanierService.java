package com.example.demo.service;
import com.example.demo.modele.Panier;
import com.example.demo.modele.comptes;
import com.example.demo.modele.produit;
import com.example.demo.repository.CompteRepository;
import com.example.demo.repository.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class PanierService{
    public PanierService(){}
    public PanierService(PanierRepository panierRepository){
        this.panierRepository=panierRepository;
    }
    @Autowired
    private PanierRepository panierRepository;
    public List<Panier> getPanierByUsername(String username){
        return panierRepository.findByCompteUsername(username);
    }
    public boolean deleteprod(int id) {
        boolean res;
        if(panierRepository.existsById((long) id)) {
            panierRepository.deleteById((long) id);
            res=true;
        }
        else{
            res=false;
        }
        return res;
    }
}




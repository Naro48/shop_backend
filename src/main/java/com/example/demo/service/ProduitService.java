package com.example.demo.service;
import com.example.demo.modele.categorie;
import com.example.demo.repository.ProduitRepository;
import com.example.demo.modele.produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }
    public ProduitService() {}
    @Autowired
    private ProduitRepository produitRepository;

    public List<produit> getAllProduits() {
        return produitRepository.findAll();
    }

        public Optional<produit> getProduitById(Long id) {
        return produitRepository.findById((Long)id);
    }

    public boolean createProduit(produit produit) {
        boolean res=false;
        try{
            produitRepository.save(produit);
            res=true;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return res;
    }

    public boolean updateProduit(int id, produit updatedProduit) {
        boolean res=false;
        try{
            produitRepository.save(updatedProduit);
            updatedProduit.setId(id);
            res=true;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return res;
    }

    public boolean deleteProduit(int id) {
        boolean res;
        if(produitRepository.existsById((long) id)) {
            produitRepository.deleteById((long) id);
            res=true;
        }
        else{

            res=false;
        }
        return res;
    }

    public int countProduits() {
        return (int) produitRepository.count();
    }

    public int countProduitsByCategorie(categorie cat) {
        return produitRepository.countByCategorie(cat);
    }

}

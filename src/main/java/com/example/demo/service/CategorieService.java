package com.example.demo.service;

import com.example.demo.modele.categorie;
import com.example.demo.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categRepository;

    public List<categorie> getAllCategories() {
        return categRepository.findAll();
    }

    public Optional<categorie> getCategoryById(int id) {
        return categRepository.findById((long) id);
    }

    public boolean createCategorie(categorie categorie) {
        // Check if the category already exists
        boolean categoryExists = categRepository.existsByCatname(categorie.getCatname());

        if (categoryExists) {
            // Category already exists, return false
            return false;
        }
        // Category doesn't exist, attempt to save it
        try {
            categRepository.save(categorie);
            // Saved successfully, return true
            return true;
        } catch (Exception e) {
            // Log the exception (optional)
            System.out.println(e);
            // Return false if an exception occurs during saving
            return false;
        }
    }

    public boolean deleteCategorie(int id) {
        boolean res = false;
        try {
            if(categRepository.existsById((long) id)) {
                categRepository.deleteById((long) id);
                res=true;
            }
            else{
                return res;
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception or handle it appropriately
            return false; // Return false if deletion fails
        }
        return res;
    }
    public categorie findCategorieByName(String name){
        return categRepository.findCategorieByCatname(name);
    }

}

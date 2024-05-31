package com.example.demo.service;

import com.example.demo.modele.comptes;
import com.example.demo.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComptesService {
    public ComptesService(){}

public ComptesService(CompteRepository compteRepository){
        this.compteRepository=compteRepository;
}
@Autowired
    private CompteRepository compteRepository;

    public List<comptes> getAllAccs() {
        return compteRepository.findAll();
    }
    public comptes findByUsername(String username){
        return compteRepository.findByUsername(username);
    }

    public Optional<comptes> getAccById(Long id) {
        return compteRepository.findById(id);
    }

    public boolean createCompte(comptes compte) {
        boolean res=false;
        try{
            compteRepository.save(compte);
            res=true;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return res;
    }


    public boolean updateCompte(int id, comptes updatedCompte) {
        boolean res=false;
        try{
            compteRepository.save(updatedCompte);
            updatedCompte.setId(id);
            res=true;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return res;
    }

    public boolean deleteCompte(int id) {
        boolean res;
        if(compteRepository.existsById((long) id)) {
            compteRepository.deleteById((long) id);
            res=true;
        }
        else{

            res=false;
        }
        return res;
    }

    public int countcompte() {
        return (int) compteRepository.count();
    }
    public int countcompteByType(String type) {
        return compteRepository.countByType  (type);
}
    public int countcompteByFiliere(String fill) {
        return compteRepository.countByFiliere (fill);
}

public List<comptes> findByType(String type){
        return compteRepository.findAllByType(type);
}
}




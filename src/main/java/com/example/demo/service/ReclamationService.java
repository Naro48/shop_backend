package com.example.demo.service;

import com.example.demo.modele.Reclamation;
import com.example.demo.repository.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReclamationService {

    @Autowired
    private ReclamationRepository ReclamationSer;

    public List<Reclamation> getAllReclamations() {
        return ReclamationSer.findAll();
    }

    public List<Reclamation> getReclamationsByUsername(String username) {
        return ReclamationSer.findAllByCompteUsername(username); // Return null if reclamation is not found
    }


    public boolean createReclamation(Reclamation reclamation) {
        boolean res=false;
        try{
            ReclamationSer.save(reclamation);
            res=true;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return res;
    }
public boolean deleteReclamation(int id) {
    boolean res;
    if(ReclamationSer.existsById((long) id)) {
        res=false;
    }
    else{
        ReclamationSer.deleteById((long) id);
        res=true;
    }
    return res;
}
    public int countcomplaint() {
        return (int) ReclamationSer.count();
    }
    public int countByCompte_Type(String Type) {
        return ReclamationSer.countByCompte_Type  (Type);
    }
    public int countByCompte_Filiere(String Filiere) {return ReclamationSer.countByCompte_Filiere (Filiere);
    }
}

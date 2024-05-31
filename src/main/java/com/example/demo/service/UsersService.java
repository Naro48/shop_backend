package com.example.demo.service;

import com.example.demo.modele.comptes;
import com.example.demo.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
   @Autowired
   private final CompteRepository comptesRepository;

    public UsersService(CompteRepository comptesRepository) {
        this.comptesRepository = comptesRepository;
    }
    public comptes authenticate(String username,String password){
        return comptesRepository.findByUsernameAndPassword(username,password);
    }
    public comptes trouverParNomUtilisateur(String username) {
        return comptesRepository.findByUsername(username);
    }
}

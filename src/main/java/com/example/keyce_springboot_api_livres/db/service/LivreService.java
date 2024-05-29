package com.example.keyce_springboot_api_livres.db.service;

import com.example.keyce_springboot_api_livres.db.Auteur;
import com.example.keyce_springboot_api_livres.db.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivreService {

    @Autowired
    AuteurRepository auteurRepository;

    public void createAuteur(Auteur auteur){
        auteurRepository.save(auteur);
    }
}

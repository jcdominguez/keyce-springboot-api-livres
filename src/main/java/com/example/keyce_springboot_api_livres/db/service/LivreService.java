package com.example.keyce_springboot_api_livres.db.service;

import com.example.keyce_springboot_api_livres.db.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivreService {

    @Autowired
    AuteurRepository auteurRepository;
    @Autowired
    CategorieRepository categorieRepository;
    @Autowired
    LivreRepository livreRepository;

    public void createAuteur(Auteur auteur){
        auteurRepository.save(auteur);
    }

    public void createCategorie(Categorie categorie){
        categorieRepository.save(categorie);
    }

    public void createLivre(Livre livre){
        livreRepository.save(livre);
    }
}

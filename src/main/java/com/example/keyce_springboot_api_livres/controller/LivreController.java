package com.example.keyce_springboot_api_livres.controller;


import com.example.keyce_springboot_api_livres.db.Auteur;
import com.example.keyce_springboot_api_livres.db.Categorie;
import com.example.keyce_springboot_api_livres.db.Livre;
import com.example.keyce_springboot_api_livres.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class LivreController {

    @Autowired
    LivreService livreService;

    @PostMapping("categories")
    public void createCategorie(@RequestBody Categorie categorie){
        livreService.createCategorie(categorie);
    }

    @PostMapping("auteurs")
    public void createAuteur(@RequestBody Auteur auteur){
        livreService.createAuteur(auteur);
    }

    @PostMapping("livres")
    public void createLivre(@RequestBody Livre livre){
        livreService.createLivre(livre);
    }

    @GetMapping("livres")
    public List<Livre> getLivres(){
        return livreService.getLivres();
    }
}

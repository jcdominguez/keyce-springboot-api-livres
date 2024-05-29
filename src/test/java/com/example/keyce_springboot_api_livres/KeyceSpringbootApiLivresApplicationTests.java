package com.example.keyce_springboot_api_livres;

import com.example.keyce_springboot_api_livres.db.Auteur;
import com.example.keyce_springboot_api_livres.db.Categorie;
import com.example.keyce_springboot_api_livres.db.Livre;
import com.example.keyce_springboot_api_livres.db.service.LivreService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KeyceSpringbootApiLivresApplicationTests {

	@Autowired
	LivreService livreService;

	@Test
	void testCreateAuteur() {

		Auteur auteur = new Auteur();
		auteur.setPrenom("Jean-Jacques");
		auteur.setNom("Rousseau");

		livreService.createAuteur(auteur);
	}

	@Test
	void testCreateCategorie(){

		Categorie categorie = new Categorie();
		categorie.setNom("Littérature");

		livreService.createCategorie(categorie);
	}

	@Test
	void testCreateLivre(){
		Auteur auteur = new Auteur();
		auteur.setPrenom("Jean-Jacques");
		auteur.setNom("Rousseau");
		livreService.createAuteur(auteur);

		Categorie categorie1 = new Categorie();
		categorie1.setNom("Littérature");
		livreService.createCategorie(categorie1);

		Categorie categorie2 = new Categorie();
		categorie2.setNom("Science-fiction");
		livreService.createCategorie(categorie2);

		Livre livre = new Livre();
		livre.setTitre("Du contrat social");
		livre.setAuteur(auteur);
		livre.addCategorie(categorie1);
		livre.addCategorie(categorie2);
		livreService.createLivre(livre);
	}
}

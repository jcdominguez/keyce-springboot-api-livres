package com.example.keyce_springboot_api_livres;

import com.example.keyce_springboot_api_livres.db.Auteur;
import com.example.keyce_springboot_api_livres.db.Categorie;
import com.example.keyce_springboot_api_livres.db.Livre;
import com.example.keyce_springboot_api_livres.db.LivreRepository;
import com.example.keyce_springboot_api_livres.service.LivreService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class KeyceSpringbootApiLivresApplicationTests {

	@Autowired
	LivreService livreService;

	@Autowired
	LivreRepository livreRepository;

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

	@Test
	@Transactional
	void testLazyMode(){
		List<Livre> livres = livreService.getLivres();//requete SQL
		Livre livre = livres.get(0);
		System.out.println(livre.getTitre());

		System.out.println(livre.getAuteur().getNom());//requete SQL
	}


	@Test
	void testQuery(){
		Livre livre = new Livre();
		livre.setTitre("Livre 1");
		livre.setAnneePublication(1985);
		livreService.createLivre(livre);

		Livre livre2 = new Livre();
		livre2.setTitre("Livre 2");
		livre2.setAnneePublication(1970);
		livreService.createLivre(livre2);

		List<Livre> livres = livreRepository.findLivresAnneesParDecennie(1979, 1990);
		for(Livre l : livres){
			System.out.println(l.getTitre());
		}
	}

	@Test
	void testNativeQuery(){
		Livre livre = new Livre();
		livre.setTitre("Livre 1");
		livre.setAnneePublication(1985);
		livreService.createLivre(livre);

		Livre livre2 = new Livre();
		livre2.setTitre("Livre 2");
		livre2.setAnneePublication(1970);
		livreService.createLivre(livre2);

		List<Livre> livres = livreRepository.findLivresAnnees80();
		for(Livre l : livres){
			System.out.println(l.getTitre());
		}
	}
}

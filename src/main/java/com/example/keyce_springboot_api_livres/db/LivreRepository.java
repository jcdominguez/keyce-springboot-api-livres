package com.example.keyce_springboot_api_livres.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Integer> {

    // Custom method
    List<Livre> findAllByTitre(String titre);

    //Query method
    //@Query(value = "SELECT l FROM Livre WHERE l.anneePublication > :anneeDebut AND l.annePublication < :anneeFin")
    //List<Livre> findLivresAnneesParDecennie(@Param("anneeDebut") Integer anneeDebut, @Param("anneeFin") Integer anneeFin);

    // Native Query
    @Query(value = "SELECT * FROM livres WHERE annee_publication > 1979 AND annee_publication < 1990", nativeQuery = true)
    List<Livre> findLivresAnnees80();

}

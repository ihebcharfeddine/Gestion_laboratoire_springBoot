package com.example.projet.dao;

import com.example.projet.entities.EnseignantChercheur;
import com.example.projet.entities.Membre;
import com.example.projet.entities.Membre_Pub_Id;
import com.example.projet.entities.Membre_Publication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Membre_PublicationDao extends JpaRepository<Membre_Publication, Membre_Pub_Id> {
    List<Membre_Publication> findByAuteur(Membre auteur);
}

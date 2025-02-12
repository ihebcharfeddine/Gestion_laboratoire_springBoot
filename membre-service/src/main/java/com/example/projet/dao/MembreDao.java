package com.example.projet.dao;

import com.example.projet.entities.Etudiant;
import com.example.projet.entities.Membre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembreDao extends JpaRepository<Membre,Long> {
    Membre findByCin(String cin);
    List<Membre> findByNomStartingWith(String caractere);
    Membre findByEmail(String email);
    List<Membre> findByNom(String nom);
}

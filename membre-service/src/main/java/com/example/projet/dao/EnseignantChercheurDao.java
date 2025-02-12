package com.example.projet.dao;

import com.example.projet.entities.EnseignantChercheur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnseignantChercheurDao extends JpaRepository<EnseignantChercheur,Long> {
    List<EnseignantChercheur> findByGrade(String grade);
    List<EnseignantChercheur>findByEtablissement(String etablissement);
}

package com.example.projet.dao;

import com.example.projet.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EtudiantDao extends JpaRepository<Etudiant,Long> {
    List<Etudiant> findByDiplome(String diplome);
    List<Etudiant>findByDiplomeOrderByDateInscriptionDesc(String
                                                                  diplome);
}

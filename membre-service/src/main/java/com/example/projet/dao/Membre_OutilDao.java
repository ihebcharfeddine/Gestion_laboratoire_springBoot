package com.example.projet.dao;

import com.example.projet.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Membre_OutilDao extends JpaRepository<Membre_Outil, Membre_Outil_Id> {
    List<Membre_Outil> findByMembre(Membre membre);
}

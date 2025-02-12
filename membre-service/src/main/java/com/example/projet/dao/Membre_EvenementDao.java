package com.example.projet.dao;

import com.example.projet.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Membre_EvenementDao extends JpaRepository<Membre_Evenement, Membre_Event_Id> {
    List<Membre_Evenement> findByParticipant(Membre participant);
}

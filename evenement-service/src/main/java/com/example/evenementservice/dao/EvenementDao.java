package com.example.evenementservice.dao;

import com.example.evenementservice.entities.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenementDao extends JpaRepository<Evenement,Long> {
}

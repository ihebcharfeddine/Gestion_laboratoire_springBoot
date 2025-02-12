package com.example.outilservice.dao;

import com.example.outilservice.entities.Outil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutilDao extends JpaRepository<Outil,Long> {
}

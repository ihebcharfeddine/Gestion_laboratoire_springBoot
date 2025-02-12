package com.example.publicationservice.dao;

import com.example.publicationservice.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicationDao extends JpaRepository<Publication,Long> {
}

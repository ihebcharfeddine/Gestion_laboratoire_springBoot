package com.example.publicationservice.controllers;

import com.example.publicationservice.dao.PublicationDao;
import com.example.publicationservice.entities.Publication;
import com.example.publicationservice.services.PublicationService;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PublicationController {
    @Autowired
    PublicationService publicationService;
    @Autowired
    PublicationDao publicationDao;
    @GetMapping("/publication")
    public List<Publication> findAll(){
        return publicationService.findAll();
    }
    @GetMapping("/publication/{id}")
    public Publication find(@PathVariable(name = "id") Long id){
        return (Publication) publicationDao.findById(id).get();
    }
    @PostMapping
    public void addOutil(@RequestBody Publication outil){
        publicationService.addOutil(outil);
    }
}

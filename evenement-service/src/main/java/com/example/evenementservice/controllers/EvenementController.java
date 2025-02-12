package com.example.evenementservice.controllers;


import com.example.evenementservice.dao.EvenementDao;
import com.example.evenementservice.entities.Evenement;
import com.example.evenementservice.services.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EvenementController {
    @Autowired
    EvenementService evenementService;
    @Autowired
    EvenementDao evenementDao ;
    @GetMapping("/evenement")
    public List<Evenement> findAll(){
        return evenementService.findAll();
    }
    @GetMapping("/evenement/{id}")
    public Evenement find(@PathVariable(name = "id") Long id){
        return (Evenement) evenementDao.findById(id).get();
    }
    @PostMapping
    public void addEvenement(@RequestBody Evenement evenement){
        evenementService.addEvenement(evenement);
    }
}

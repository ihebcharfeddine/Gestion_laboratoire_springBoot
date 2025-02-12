package com.example.outilservice.controllers;


import com.example.outilservice.dao.OutilDao;
import com.example.outilservice.entities.Outil;
import com.example.outilservice.services.OutilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OutilController {
    @Autowired
    OutilService outilService;
    @Autowired
    OutilDao outilDao ;
    @GetMapping("/outil")
    public List<Outil> getAll(){
        return outilService.findAll();
    }
    @GetMapping("/outil/{id}")
    public Outil find(@PathVariable(name = "id") Long id){
        return (Outil) outilDao.findById(id).get();
    }
    @PostMapping
    public void addOutil(@RequestBody Outil outil){
        outilService.addOutil(outil);
    }

}

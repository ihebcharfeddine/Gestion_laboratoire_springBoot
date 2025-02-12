package com.example.evenementservice.services;

import com.example.evenementservice.dao.EvenementDao;
import com.example.evenementservice.entities.Evenement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvenementService {
    @Autowired
    EvenementDao evenementDao;
    public List<Evenement> findAll(){
        return  evenementDao.findAll();
    }
    public Evenement addEvenement(Evenement evenement) {
        evenementDao.save(evenement);
        return evenement;
    }
    public void deleteEvenement(Long id){
        evenementDao.deleteById(id);
    }
    public void updateEvenement(Evenement evenement){
        Evenement oldOutil=evenementDao.findById(evenement.getId()).orElse(null);
        if (oldOutil!=null){
            //to do
        }

    }
}

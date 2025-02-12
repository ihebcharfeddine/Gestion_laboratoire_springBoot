package com.example.publicationservice.services;

import com.example.publicationservice.dao.PublicationDao;
import com.example.publicationservice.entities.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationService {
    @Autowired
    PublicationDao publicationDao;

    public List<Publication> findAll(){
        return publicationDao.findAll();
    }

    public Publication addOutil(Publication outil) {
        publicationDao.save(outil);
        return outil;
    }
    public void deleteOutil(Long id){
        publicationDao.deleteById(id);
    }
    public void updateOutil(Publication outil){
        Publication oldOutil=publicationDao.findById(outil.getId()).orElse(null);
        if (oldOutil!=null){
            //to do
        }

    }
}

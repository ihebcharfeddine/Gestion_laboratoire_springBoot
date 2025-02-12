package com.example.projet;

import com.example.projet.beans.PublicationBean;
import com.example.projet.dao.EnseignantChercheurDao;
import com.example.projet.dao.MembreDao;
import com.example.projet.entities.Etudiant;
import com.example.projet.entities.Membre;
import com.example.projet.proxy.PublicationServiceProxy;
import com.example.projet.services.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Date;

@EnableFeignClients
@SpringBootApplication
public class ProjetApplication  {

    @Autowired
    MembreService membreService;
    @Autowired
    PublicationServiceProxy publicationServiceProxy;
    @Autowired

    public static void main(String[] args) {
        SpringApplication.run(ProjetApplication.class, args);
    }


}

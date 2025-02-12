package com.example.projet.controllers;

import com.example.projet.entities.*;
import com.example.projet.services.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MembreController {
    @Autowired
    MembreService membreService;

    @GetMapping("/membre")
    public List<Membre> findAll(){
        return membreService.findAll();
    }
    @PostMapping("/publication")
    public void affecterPublication(@RequestBody Membre_Pub_Id membrePubId){
        membreService.affecterauteurTopublication(membrePubId.getAuteur_id(), membrePubId.getPublication_id());
    }
    @PostMapping("/outil")
    public void affecterOutil(@RequestBody Membre_Outil_Id membreOutilId){
        membreService.affecterMembretToOutil(membreOutilId.getMembre_id(), membreOutilId.getOutil_id());
    }
    @PostMapping("/evenement")
    public void affecterEvenement(@RequestBody Membre_Event_Id membreEventId){
        membreService.affecterParticipantToEvent(membreEventId.getParticipant_id(), membreEventId.getEvent_id());
    }
    @GetMapping("/fullmember/{id}")
    public Membre findAFullMember(@PathVariable(name="id") Long id)
    {
        Membre mbr=membreService.findMember(id);
        mbr.setPubs(membreService.findPublicationparauteur(id));
        mbr.setEvents(membreService.findEventParParticipant(id));
        mbr.setOutils(membreService.findOutilParMembre(id));


        return mbr;
    }    @GetMapping("/membre/{id}")
    public Membre find(@PathVariable Long id){
        return membreService.findMember(id);
    }
    @GetMapping("/membre/email/{email}")
    public Membre findByEmail(@PathVariable String email){
        return membreService.findByEmail(email);
    }
    @GetMapping("/membre/cin/{cin}")
    public Membre find(@PathVariable String cin){
        return membreService.findByCin(cin);
    }
    @GetMapping("/membre/nom/{nom}")
    public List<Membre> findByNom(@PathVariable String nom){
        return membreService.findByNom(nom);
    }

    @GetMapping("/etudiant/{diplome}")
    public List<Etudiant> findByDiplome(@PathVariable String diplome){
        return membreService.findByDiplome(diplome);
    }
    @GetMapping("/enseignant/grade/{grade}")
    public List<EnseignantChercheur> findByGrade(String grade){
        return membreService.findByGrade(grade);
    }
    @GetMapping("/enseignant/etablissement/{etablissement}")
    public List<EnseignantChercheur> findByEtablissement(@PathVariable String etablissement){
        return membreService.findByEtablissement(etablissement);
    }
    @PostMapping("/etudiant")
    public void addEtudiant(@RequestBody Etudiant etudiant){
        membreService.addMember(etudiant);
    }
    @PostMapping("/enseignant")
    public void addEnseignant(@RequestBody EnseignantChercheur enseignantChercheur){
        membreService.addMember(enseignantChercheur);
    }
    @PutMapping("/etudiant")
    public Membre updateEtudiant(@RequestBody Etudiant etudiant){
        return membreService.updateMember(etudiant);
    }
    @PutMapping("/enseignant")
    public Membre updateEnseignant(@RequestBody EnseignantChercheur enseignantChercheur){
        return membreService.updateMember(enseignantChercheur);
    }
    @DeleteMapping("/{id}")
    public void findByDiplome(@PathVariable Long id){
        membreService.deleteMember(id);
    }


}

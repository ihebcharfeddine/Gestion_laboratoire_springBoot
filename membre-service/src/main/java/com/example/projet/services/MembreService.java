package com.example.projet.services;

import com.example.projet.beans.EvenementBean;
import com.example.projet.beans.OutilBean;
import com.example.projet.beans.PublicationBean;
import com.example.projet.dao.*;
import com.example.projet.entities.*;
import com.example.projet.proxy.EvenementServiceProxy;
import com.example.projet.proxy.OutilServiceProxy;
import com.example.projet.proxy.PublicationServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MembreService {
    @Autowired
    MembreDao membreDao;
    @Autowired
    EtudiantDao etudiantDao;
    @Autowired
    EnseignantChercheurDao enseignantChercheurDao;
    @Autowired
    Membre_PublicationDao membrePublicationDao;
    @Autowired
    PublicationServiceProxy publicationServiceProxy;
    @Autowired
    EvenementServiceProxy evenementServiceProxy;
    @Autowired
    Membre_EvenementDao membreEvenementDao;
    @Autowired
    OutilServiceProxy outilServiceProxy;
    @Autowired
    Membre_OutilDao membreOutilDao;

    public List<Membre>findAll(){
        return membreDao.findAll();
    }
    public Membre addMember(Membre m) {
        membreDao.save(m);
        return m;
    }
    public void deleteMember(Long id) {
        membreDao.deleteById(id);
    }
    public Membre updateMember(Membre m) {
        return membreDao.saveAndFlush(m);
    }
    public Membre findMember(Long id) {
        Membre m = (Membre) membreDao.findById(id).get();
        return m;
    }
    public Membre findByCin(String cin){
        return membreDao.findByCin(cin);
    }
    public Membre findByEmail(String email){
        return  membreDao.findByEmail(email);
    }
    public List<Membre> findByNom(String nom){
        return membreDao.findByNom(nom);
    }
    public List<Etudiant> findByDiplome(String diplome){
        return etudiantDao.findByDiplome(diplome);
    }
    public List<EnseignantChercheur> findByGrade(String grade){
        return enseignantChercheurDao.findByGrade(grade);
    }
    public List<EnseignantChercheur> findByEtablissement(String etablissement){
        return enseignantChercheurDao.findByEtablissement(etablissement);
    }
    public void affecterEtudiant(Long etudiantId,Long enseignantId){
        Etudiant etudiant=(Etudiant) membreDao.findById(etudiantId).get();
        EnseignantChercheur enseignantChercheur =(EnseignantChercheur) membreDao.findById(enseignantId).get();
        etudiant.setEncadrant(enseignantChercheur);
        membreDao.save(etudiant);
    }
    public void affecterauteurTopublication(Long idauteur, Long idpub)
    {
        Membre mbr= (Membre) membreDao.findById(idauteur).get();
        Membre_Publication mbs= new Membre_Publication();
        mbs.setAuteur(mbr);
        mbs.setId(new Membre_Pub_Id(idpub, idauteur));
        membrePublicationDao.save(mbs);
    }
    public List<PublicationBean> findPublicationparauteur(Long idauteur) {
        List<PublicationBean> pubs=new ArrayList<PublicationBean>();
        Membre auteur= membreDao.findById(idauteur).get();
        List< Membre_Publication>
                idpubs=membrePublicationDao.findByAuteur(auteur);
        idpubs.forEach(s->{
                    System.out.println(s);
                    pubs.add(publicationServiceProxy.findPublicationById(s.getId().getPublication_id()));
                }
        );
        return pubs;
    }
    //evenement
    public void affecterParticipantToEvent(Long idparticipant, Long idevent)
    {
        Membre mbr= (Membre) membreDao.findById(idparticipant).get();
        Membre_Evenement mbs= new Membre_Evenement();
        mbs.setParticipant(mbr);
        mbs.setId(new Membre_Event_Id(idevent, idparticipant));
        membreEvenementDao.save(mbs);
    }

    public List<EvenementBean> findEventParParticipant(Long idparticipant) {
        List<EvenementBean> events=new ArrayList<EvenementBean>();
        Membre participant= membreDao.findById(idparticipant).get();
        List< Membre_Evenement>
                idevents=membreEvenementDao.findByParticipant(participant);
        idevents.forEach(s->{
                    System.out.println(s);
                    events.add(evenementServiceProxy.findEvenementById(s.getId().getEvent_id()));
                }
        );
        return events;
    }
    //evenement
    public void affecterMembretToOutil(Long idmembre, Long idoutil)
    {
        Membre mbr= (Membre) membreDao.findById(idmembre).get();
        Membre_Outil mbs= new Membre_Outil();
        mbs.setMembre(mbr);
        mbs.setId(new Membre_Outil_Id(idoutil, idmembre));
        membreOutilDao.save(mbs);
    }

    public List<OutilBean> findOutilParMembre(Long idmembre) {
        List<OutilBean> outils=new ArrayList<OutilBean>();
        Membre membre= membreDao.findById(idmembre).get();
        List< Membre_Outil>
                idoutils=membreOutilDao.findByMembre(membre);
        idoutils.forEach(s->{
                    System.out.println(s);
                    outils.add(outilServiceProxy.findOutilById(s.getId().getOutil_id()));
                }
        );
        return outils;
    }
}

package com.example.projet.entities;

import com.example.projet.beans.EvenementBean;
import com.example.projet.beans.OutilBean;
import com.example.projet.beans.PublicationBean;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "type_mbr", discriminatorType =
        DiscriminatorType.STRING,length = 3)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public abstract class Membre implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String cin;
    @NonNull
    private String nom;
    @NonNull
    private String prenom;
    @NonNull @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    private byte[] photo;
    @NonNull
    private String cv;
    @NonNull
    private String email;
    @NonNull
    private String password;

    @Transient
    Collection<PublicationBean> pubs;
    @Transient
    Collection<EvenementBean> events;
    @Transient
    Collection<OutilBean> outils;
}

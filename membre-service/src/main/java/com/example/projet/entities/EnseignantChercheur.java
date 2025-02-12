package com.example.projet.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Collection;
import java.util.Date;

@Entity @DiscriminatorValue("ens")
@Getter
@Setter
@NoArgsConstructor

public class EnseignantChercheur extends Membre{
    @OneToMany(mappedBy = "encadrant")
    Collection<Etudiant> listEtudiants ;
    @NonNull
    private String grade;
    @NonNull
    private String etablissement;
    @Builder
    public EnseignantChercheur(@NonNull String cin, @NonNull String nom, @NonNull String prenom, @NonNull Date dateNaissance, @NonNull String cv, @NonNull String email, @NonNull String password, @NonNull String grade, @NonNull String etablissement) {
        super(cin, nom, prenom, dateNaissance, cv, email, password);
        this.grade = grade;
        this.etablissement = etablissement;
    }


}

package com.example.projet.beans;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
public class EvenementBean {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;

    @NonNull
    private Date date;
    @NonNull
    private String titre;
    @NonNull
    private String lieu;

    @Builder
    public EvenementBean(Long id, @NonNull Date date, @NonNull String titre, @NonNull String lieu) {
        this.id = id;
        this.date = date;
        this.titre = titre;
        this.lieu = lieu;
    }
}

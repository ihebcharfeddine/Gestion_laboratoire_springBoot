package com.example.evenementservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity @DiscriminatorValue("etd")
@Getter
@Setter
@NoArgsConstructor
public class Evenement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;

    @NonNull
    private Date date;
    @NonNull
    private String titre;
    @NonNull
    private String lieu;

    @Builder
    public Evenement(Long id, @NonNull Date date, @NonNull String titre, @NonNull String lieu) {
        this.id = id;
        this.date = date;
        this.titre = titre;
        this.lieu = lieu;
    }
}

package com.example.publicationservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity @DiscriminatorValue("etd")
@Getter
@Setter
@NoArgsConstructor
public class Publication {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;

    @NonNull
    private Date date;
    @NonNull
    private String type;
    @NonNull
    private String titre;
    @NonNull
    private String lien;
    @NonNull
    private String sourcePdf;
    @NonNull
    @Builder
    public Publication(Long id, @NonNull Date date, @NonNull String type, @NonNull String titre, @NonNull String lien, @NonNull String sourcePdf) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.titre = titre;
        this.lien = lien;
        this.sourcePdf = sourcePdf;
    }
}

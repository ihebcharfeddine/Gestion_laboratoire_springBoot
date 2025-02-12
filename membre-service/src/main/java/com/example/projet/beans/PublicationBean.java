package com.example.projet.beans;


import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class PublicationBean {
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

    @Builder
    public PublicationBean(Long id, @NonNull Date date, @NonNull String type, @NonNull String titre, @NonNull String lien, @NonNull String sourcePdf) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.titre = titre;
        this.lien = lien;
        this.sourcePdf = sourcePdf;
    }
}

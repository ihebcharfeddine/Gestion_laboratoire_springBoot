package com.example.projet.beans;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
public class OutilBean {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;

    @NonNull
    private Date date;
    @NonNull
    private String source;
    @Builder
    public OutilBean(Long id, @NonNull Date date, @NonNull String source) {
        this.id = id;
        this.date = date;
        this.source = source;
    }
}

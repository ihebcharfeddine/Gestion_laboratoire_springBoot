package com.example.outilservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity @DiscriminatorValue("etd")
@Getter
@Setter
@NoArgsConstructor
public class Outil {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;

    @NonNull
    private Date date;
    @NonNull
    private String source;
    @Builder
    public Outil(Long id, @NonNull Date date, @NonNull String source) {
        this.id = id;
        this.date = date;
        this.source = source;
    }
}

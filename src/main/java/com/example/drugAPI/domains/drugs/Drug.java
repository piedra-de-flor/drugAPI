package com.example.drugAPI.domains.drugs;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@NoArgsConstructor
@Entity
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String drugName;
    private String entpName;
    private String efcyQesitm;
    private String useMethodQesitm;


    @Builder
    public Drug(String drugName, String entpName, String efcyQesitm, String useMethodQesitm) {
        this.drugName = drugName;
        this.entpName = entpName;
        this.efcyQesitm = efcyQesitm;
        this.useMethodQesitm = useMethodQesitm;
    }
}

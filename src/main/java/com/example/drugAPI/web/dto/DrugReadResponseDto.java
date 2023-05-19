package com.example.drugAPI.web.dto;

import com.example.drugAPI.domains.drugs.Drug;
import lombok.Builder;
import lombok.Getter;

@Getter
public class DrugReadResponseDto {
    private final String drugName;
    private final String entpName;
    private final String efcyQesitm;
    private final String useMethodQesitm;

    @Builder
    public DrugReadResponseDto(Drug drug) {
        this.drugName = drug.getDrugName();
        this.entpName = drug.getEntpName();
        this.efcyQesitm = drug.getEfcyQesitm();
        this.useMethodQesitm = drug.getUseMethodQesitm();
    }
}
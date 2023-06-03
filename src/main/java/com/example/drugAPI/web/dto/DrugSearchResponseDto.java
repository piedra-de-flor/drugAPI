package com.example.drugAPI.web.dto;

import com.example.drugAPI.domains.drugs.Drug;
import com.example.drugAPI.service.drug.DrugApiResponseDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DrugSearchResponseDto {

    private String drugName;
    private String entpName;
    private String efcyQesitm;
    private String useMethodQesitm;

    public DrugSearchResponseDto(Drug drug) {
        this.drugName = drug.getDrugName();
        this.entpName = drug.getEntpName();
        this.efcyQesitm = drug.getEfcyQesitm();
        this.useMethodQesitm = drug.getUseMethodQesitm();
    }

    public DrugSearchResponseDto(DrugApiResponseDto.response drugApiResponse) {
        this.drugName = drugApiResponse.getItemName();
        this.entpName = drugApiResponse.getEntpName();
        this.efcyQesitm = drugApiResponse.getEfcyQesitm();
        this.useMethodQesitm = drugApiResponse.getUseMethodQesitm();
    }
}

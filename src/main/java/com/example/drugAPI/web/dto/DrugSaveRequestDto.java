package com.example.drugAPI.web.dto;

import com.example.drugAPI.domains.drugs.Drug;
import lombok.Builder;
import lombok.Getter;

@Getter
public class DrugSaveRequestDto {
    private final String drugName;
    private final String entpName;
    private final String efcyQesitm;
    private final String useMethodQesitm;

    @Builder
    public DrugSaveRequestDto(DrugSearchResponseDto drugSearchResponseDto) {
        this.drugName = drugSearchResponseDto.getDrugName();
        this.entpName = drugSearchResponseDto.getEntpName();
        this.efcyQesitm = drugSearchResponseDto.getEfcyQesitm();
        this.useMethodQesitm = drugSearchResponseDto.getUseMethodQesitm();
    }

    @Builder
    public DrugSaveRequestDto(String drugName, String entpName, String efcyQesitm, String useMethodQesitm) {
        this.drugName = drugName;
        this.entpName = entpName;
        this.efcyQesitm = efcyQesitm;
        this.useMethodQesitm = useMethodQesitm;
    }


    public Drug toEntity() {
        return Drug.builder()
                .drugName(drugName)
                .entpName(entpName)
                .efcyQesitm(efcyQesitm)
                .useMethodQesitm(useMethodQesitm)
                .build();
    }
}

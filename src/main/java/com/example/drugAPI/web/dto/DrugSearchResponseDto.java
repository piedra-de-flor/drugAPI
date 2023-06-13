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
        this.drugName = deleteExtraChar(drugApiResponse.getItemName());
        this.entpName = deleteExtraChar(drugApiResponse.getEntpName());
        this.efcyQesitm = deleteExtraChar(drugApiResponse.getEfcyQesitm());
        this.useMethodQesitm = deleteExtraChar(drugApiResponse.getUseMethodQesitm());
    }

    public String deleteExtraChar(String information) {
        String informationDeletedP = information.replaceAll("<p>", "");
        String informationDeletedEndP = informationDeletedP.replaceAll("</p>", "");
        String informationDeletedSub = informationDeletedEndP.replaceAll("<sub>", "");
        String informationDeletedEndSub = informationDeletedSub.replaceAll("</sub>", "");
        String informationDeletedSup = informationDeletedEndSub.replaceAll("<sup>", "");
        String informationDeletedBr = informationDeletedSup.replaceAll("</br>","");

        return informationDeletedBr.replaceAll("</sup>", "");
    }
}

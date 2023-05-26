package com.example.drugAPI.web.dto;

import com.example.drugAPI.domains.drugs.Drug;
import lombok.Builder;

import java.util.List;

public class DrugReadAllResponseDto {

    private final List<Drug> drugNameList;

    @Builder
    public DrugReadAllResponseDto(List<Drug> drugNameList) {
        this.drugNameList = drugNameList;
    }
}
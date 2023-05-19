package com.example.drugAPI.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class DrugSearchRequestDto {

    private String drugName;

    @Builder
    public DrugSearchRequestDto(String drugName) {
        this.drugName = drugName;
    }
}

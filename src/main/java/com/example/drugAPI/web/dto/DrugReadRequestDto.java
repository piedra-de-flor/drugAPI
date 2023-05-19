package com.example.drugAPI.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class DrugReadRequestDto {

    private String drugName;

    @Builder
    public DrugReadRequestDto(String drugName) {
        this.drugName = drugName;
    }
}

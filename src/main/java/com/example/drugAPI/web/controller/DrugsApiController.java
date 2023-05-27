package com.example.drugAPI.web.controller;

import com.example.drugAPI.domains.drugs.Drug;
import com.example.drugAPI.service.drug.DrugService;
import com.example.drugAPI.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class DrugsApiController {

    private final DrugService drugService;

    @GetMapping("/api/searchDrug/{drugName}")
    public DrugSearchResponseDto findByDrugName(@PathVariable String drugName) throws IOException {
        return drugService.findByDrugName(DrugSearchRequestDto.builder().drugName(drugName).build());
    }

    @PostMapping("/save")
    public String save(@RequestBody DrugSaveRequestDto drugSaveRequestDto) {
        return drugService.saveDrug(drugSaveRequestDto);
    }

    @GetMapping("/read/{drugName}")
    public DrugReadResponseDto readDrug(@PathVariable String drugName) {
        return drugService.readMyDrug(DrugReadRequestDto.builder().drugName(drugName).build());
    }

    @GetMapping("/readAll")
    public List<Drug> readDrug() {
        return drugService.readAllMyDrug();
    }
}
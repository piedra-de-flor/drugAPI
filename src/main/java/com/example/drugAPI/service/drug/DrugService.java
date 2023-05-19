package com.example.drugAPI.service.drug;

import com.example.drugAPI.domains.drugs.Drug;
import com.example.drugAPI.domains.drugs.DrugRepository;
import com.example.drugAPI.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DrugService {

    private final DrugRepository drugRepository;
    private final OpenFeignClient openFeignClient;

    @Transactional
    public DrugSearchResponseDto findByDrugName(DrugSearchRequestDto drugSearchRequestDto) {
        Optional<Drug> drug = drugRepository.findByDrugName(drugSearchRequestDto.getDrugName());
        if (drug.isPresent()) {
            return new DrugSearchResponseDto(drug.get());
        }
        else {
            String encodedDrugName = URLDecoder.decode(drugSearchRequestDto.getDrugName(), StandardCharsets.UTF_8);
            DrugApiResponse drugApiResponse = getDrugData(encodedDrugName);
            return new DrugSearchResponseDto(drugApiResponse);
        }
    }

    public DrugApiResponse getDrugData(String drugName) {
        String encodedServiceKey = URLDecoder.decode("MTcyNsGIdG6%2Bp%2FS6qkaEJJpjMefo31MZubzlFG%2B%2Fk8AB0MSbWmRKn%2BSFFmnWHXjFls7CGSpC5f8suZEQD4KWlw%3D%3D", StandardCharsets.UTF_8);
        return openFeignClient.getDrugData(encodedServiceKey, drugName, "json");
    }

    @Transactional
    public String saveDrug (DrugSaveRequestDto drugSaveRequestDto) {
        return drugRepository.save(drugSaveRequestDto.toEntity()).getDrugName();
    }

    @Transactional
    public DrugReadResponseDto readMyDrug (DrugReadRequestDto drugReadRequestDto) {
        Drug drug = drugRepository.findByDrugName(drugReadRequestDto.getDrugName())
                .orElseThrow(() -> new IllegalArgumentException("해당 약품은 존재하지 않습니다."));

        return new DrugReadResponseDto(drug);
    }
}

package com.example.drugAPI.service.drug;

import com.example.drugAPI.domains.drugs.Drug;
import com.example.drugAPI.domains.drugs.DrugRepository;
import com.example.drugAPI.web.dto.*;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DrugService {

    private final DrugRepository drugRepository;
    private final OpenFeignClient openFeignClient;

    @Transactional
    public DrugSearchResponseDto findByDrugName(DrugSearchRequestDto drugSearchRequestDto) throws IOException {
        Optional<Drug> drug = drugRepository.findByDrugName(drugSearchRequestDto.getDrugName());
        if (drug.isPresent()) {
            return new DrugSearchResponseDto(drug.get());
        }
        else {
            String encodedDrugName = URLDecoder.decode(drugSearchRequestDto.getDrugName(), StandardCharsets.UTF_8);
            DrugSearchResponseDto drugSearchResponseDto = new DrugSearchResponseDto(getDrugData(encodedDrugName));
            saveDrug(new DrugSaveRequestDto(drugSearchResponseDto));
            return drugSearchResponseDto;
        }
    }

    public DrugApiResponse.response getDrugData(String drugName) throws IOException {
        String encodedServiceKey = URLDecoder.decode("MTcyNsGIdG6%2Bp%2FS6qkaEJJpjMefo31MZubzlFG%2B%2Fk8AB0MSbWmRKn%2BSFFmnWHXjFls7CGSpC5f8suZEQD4KWlw%3D%3D", StandardCharsets.UTF_8);
        String xmlResponse = openFeignClient.getDrugData(encodedServiceKey, drugName);
        XmlMapper xmlMapper = new XmlMapper();
        DrugApiResponse.response value = xmlMapper.readValue(xmlResponse, DrugApiResponse.response.class);
        return value;
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

    @Transactional
    public DrugReadAllResponseDto readAllMyDrug () {
        return new DrugReadAllResponseDto(drugRepository.findAll());
    }

}

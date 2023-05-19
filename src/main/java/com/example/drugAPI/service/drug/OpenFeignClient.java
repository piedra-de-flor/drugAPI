package com.example.drugAPI.service.drug;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "searchDrug" , url = "apis.data.go.kr", configuration = config.class)
public interface OpenFeignClient {
    @GetMapping(value = "/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList", consumes = "application/x-www-form-urlencoded", produces = "application/json")
    DrugApiResponse getDrugData(@RequestParam("ServiceKey") String ServiceKey, @RequestParam("itemName") String drugName, @RequestParam("type") String type);
}

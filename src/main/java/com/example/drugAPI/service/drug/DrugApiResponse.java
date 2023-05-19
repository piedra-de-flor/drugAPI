package com.example.drugAPI.service.drug;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class DrugApiResponse {

    private String resultCode;
    private String resultMsg;
    private int numOfRows;
    private int pageNo;
    private int totalCount;
    private String entpName;
    private String itemName;
    private String itemSeq;
    private String efcyQesitm;
    private String useMethodQesitm;
    private String atpnWarnQesitm;
    private String atpnQesitm;
    private String intrcQesitm;
    private String seQesitm;
    private String depositMethodQesitm;
    private String openDe;
    private String updateDe;
    private String itemImage;
}

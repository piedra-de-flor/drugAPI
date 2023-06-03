package com.example.drugAPI.service.drug;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DrugApiResponseDto {
    @Data
    @NoArgsConstructor
    public static class header {
        public int resultCode;
        public String resultMsg;
    }

    @Data
    @NoArgsConstructor
    public static class item {
        public String entpName;
        public String itemName;
        public int itemSeq;
        public String efcyQesitm;
        public String useMethodQesitm;
        public Object atpnWarnQesitm;
        public String atpnQesitm;
        public String intrcQesitm;
        public String seQesitm;
        public String depositMethodQesitm;
        public String openDe;
        public String updateDe;
        public String itemImage;
    }

    @Data
    @NoArgsConstructor
    public static class items {
        public item item;
    }

    @Data
    @NoArgsConstructor
    public static class body {
        public int numOfRows;
        public int pageNo;
        public int totalCount;
        public items items;
    }

    @Data
    @NoArgsConstructor
    public static class response {
        public header header;
        public body body;

        public String getItemName() {
            return body.items.item.itemName;
        }

        public String getEntpName() {
            return body.items.item.entpName;
        }

        public String getEfcyQesitm() {return body.items.item.efcyQesitm;}

        public String getUseMethodQesitm() {
            return body.items.item.useMethodQesitm;
        }
    }
}

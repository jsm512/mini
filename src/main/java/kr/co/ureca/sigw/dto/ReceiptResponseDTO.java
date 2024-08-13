package kr.co.ureca.sigw.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReceiptResponseDTO {
    private int id;
    private int price;
    private String date; // or another type that matches your date format
    private String usedStore;
}

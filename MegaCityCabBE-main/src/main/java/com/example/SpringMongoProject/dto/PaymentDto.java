package com.example.SpringMongoProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class PaymentDto {
    private String userId;
    private String cardNo;
    private LocalDate exDate;
    private String cvv;
    private String cardType;

}

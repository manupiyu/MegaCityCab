package com.example.SpringMongoProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    private String userId;
    private String name;
    private String date;
    private String time;
}

package com.example.SpringMongoProject.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "payment")
@Data
public class Payment {
    @Id
    private String _id;
    private String userId;
    private String cardType;
    private String cardNo;
    private LocalDate exDate;
    private String cvv;

}

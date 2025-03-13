package com.example.SpringMongoProject.Controller;

import com.example.SpringMongoProject.Entity.Payment;
import com.example.SpringMongoProject.Service.PaymentService;
import com.example.SpringMongoProject.dto.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/pay")
    @ResponseStatus(HttpStatus.CREATED)
    public Payment doPayment(@RequestBody PaymentDto paymentDto) throws Exception {
        return this.paymentService.doPay(paymentDto);
    }
}

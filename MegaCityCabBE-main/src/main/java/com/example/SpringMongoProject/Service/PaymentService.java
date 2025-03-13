package com.example.SpringMongoProject.Service;

import com.example.SpringMongoProject.Entity.Customer;
import com.example.SpringMongoProject.Entity.Payment;
import com.example.SpringMongoProject.Repo.CustomerRepo;
import com.example.SpringMongoProject.Repo.PaymentRepo;
import com.example.SpringMongoProject.dto.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private CustomerRepo patientRepo;
    @Autowired
    private PaymentRepo paymentRepo;

    public Payment doPay(PaymentDto paymentDto) throws Exception {
        Payment payment = new Payment();
        payment.setUserId(paymentDto.getUserId());
        payment.setCardType(paymentDto.getCardType());
        payment.setCardNo(paymentDto.getCardNo());
        payment.setCvv(paymentDto.getCvv());
        payment.setExDate(paymentDto.getExDate());

        Optional<Customer> patient = patientRepo.findBy_id(paymentDto.getUserId());
        if (patient.isPresent()) {
            patient.get().setPayment(true);
            patientRepo.save(patient.get());
        } else {
            throw new Exception("Internal Server Error");
        }

        return paymentRepo.save(payment);
    }
}

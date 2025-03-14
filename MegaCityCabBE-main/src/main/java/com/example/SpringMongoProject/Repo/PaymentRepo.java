package com.example.SpringMongoProject.Repo;

import com.example.SpringMongoProject.Entity.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends MongoRepository<Payment, String> {
}

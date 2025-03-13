package com.example.SpringMongoProject.Repo;

import com.example.SpringMongoProject.Entity.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepo extends MongoRepository<Booking, String> {
}

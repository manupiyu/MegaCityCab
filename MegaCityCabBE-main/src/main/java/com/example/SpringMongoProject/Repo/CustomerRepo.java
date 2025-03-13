package com.example.SpringMongoProject.Repo;

import com.example.SpringMongoProject.Entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepo extends MongoRepository<Customer, String> {
    Optional<Customer> findBy_id(String id);

    List<Customer> findAllByNic(String nic);

}

package com.example.SpringMongoProject.Service;

import com.example.SpringMongoProject.Entity.Customer;
import com.example.SpringMongoProject.Repo.CustomerRepo;
import com.example.SpringMongoProject.dto.CustomerRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServices {

    @Autowired
    private CustomerRepo repo;

    public Customer saveorUpdate(CustomerRegisterDto patientDto) {

        Customer patient = new Customer();
        patient.setNic(patientDto.getNic());
        patient.setName(patientDto.getName());
        patient.setContact(patientDto.getContact());
        patient.setAddress(patientDto.getAddress());
        patient.setEmail(patientDto.getEmail());
        patient.setDoctor(patientDto.getDoctor());
        patient.setPayment(false);
        return repo.save(patient);

    }

    public Iterable<Customer> listAll() {
        return this.repo.findAll();
    }

    public void deletePatient(String id) {
        repo.deleteById(id);
    }

    public Customer getPatientByID(String patientId) {
        return repo.findById(patientId).get();
    }

    public List<String> getRegIdsByNic(String nic) {
        List<Customer> patients = repo.findAllByNic(nic);
        @SuppressWarnings({ "rawtypes", "unchecked" })
        List<String> ids = new ArrayList();
        for (int i = 0; i < patients.size(); i++) {
            ids.add(patients.get(i).get_id());
        }

        return ids;
    }

    public List<Customer> getReportData(String nic) {
        List<Customer> list = this.repo.findAll();
        return list.stream().filter(patient -> patient.getNic().equals(nic)).toList();
    }
}

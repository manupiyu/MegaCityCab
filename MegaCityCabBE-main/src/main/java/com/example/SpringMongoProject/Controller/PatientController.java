package com.example.SpringMongoProject.Controller;

import com.example.SpringMongoProject.Entity.Customer;
import com.example.SpringMongoProject.Service.CustomerServices;
import com.example.SpringMongoProject.dto.CustomerNicReqDto;
import com.example.SpringMongoProject.dto.CustomerRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/patient")
public class PatientController {

    @Autowired
    private CustomerServices patientServices;

    @PostMapping(value = "/save")
    private Customer savePatient(@RequestBody CustomerRegisterDto patientDto) {
        return patientServices.saveorUpdate(patientDto);
    }

    @GetMapping(value = "/getAll")
    private Iterable<Customer> getPatients() {

        return patientServices.listAll();
    }

    @PutMapping(value = "/edit/{id}")
    private void update(@RequestBody Customer patient, @PathVariable(name = "id") String _id) {

        patient.set_id(_id);
        // patientServices.saveorUpdate(patient);
        // return patient;
    }

    @DeleteMapping(value = "/delete/{id}")
    private void deletePatient(@PathVariable("id") String _id) {
        patientServices.deletePatient(_id);

    }

    @RequestMapping("/search/{id}")
    private Customer getPatients(@PathVariable(name = "id") String patientId) {
        return patientServices.getPatientByID(patientId);
    }

    @PostMapping("/get-reg-ids")
    private List<String> getRegIdsByNic(@RequestBody CustomerNicReqDto patientNicReqDto) {
        return this.patientServices.getRegIdsByNic(patientNicReqDto.getNic());
    }

    @PostMapping(value = "/reports")
    private List<Customer> getReports(@RequestBody CustomerNicReqDto nic) {
        return this.patientServices.getReportData(nic.getNic());
    }
}

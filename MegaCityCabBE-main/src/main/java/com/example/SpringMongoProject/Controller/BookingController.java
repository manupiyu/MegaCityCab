package com.example.SpringMongoProject.Controller;

import com.example.SpringMongoProject.Entity.Booking;
import com.example.SpringMongoProject.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/Booking")
public class BookingController {

    @Autowired
    private BookingService appointmentService;

    @PostMapping(value = "/create")
    private Booking createAppointment(@RequestBody Booking BookingDto) {
        return this.appointmentService.createBooking(BookingDto);
    }
}

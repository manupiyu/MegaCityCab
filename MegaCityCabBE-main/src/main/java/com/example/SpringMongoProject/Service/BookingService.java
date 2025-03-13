package com.example.SpringMongoProject.Service;

import com.example.SpringMongoProject.Entity.Booking;
import com.example.SpringMongoProject.Repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class BookingService {
    @Autowired
    private BookingRepo appointmentRepo;

    public Booking createAppointment(Booking appointmentDto) {

        Booking appointment = new Booking();
        appointment.setUserId(appointmentDto.getUserId());
        appointment.setName(appointmentDto.getName());
        appointment.setDate(LocalDate.parse(appointmentDto.getDate()));
        appointment.setTime(LocalTime.parse(null));
        return this.appointmentRepo.save(appointment);
    }

    public Booking createBooking(Booking bookingDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createBooking'");
    }
}

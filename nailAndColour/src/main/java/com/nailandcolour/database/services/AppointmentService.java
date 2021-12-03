package com.nailandcolour.database.services;

import com.nailandcolour.database.dto.Appointment;
import com.nailandcolour.database.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> readAll() {
        return appointmentRepository.findAll();
    }


}

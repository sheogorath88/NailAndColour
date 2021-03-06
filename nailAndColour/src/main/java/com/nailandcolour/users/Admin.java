package com.nailandcolour.users;

import com.nailandcolour.appointment.Appointment;
import com.nailandcolour.appointment.AppointmentRepository;
import com.nailandcolour.service.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Admin {

    private String name;
    private String surname;
    private String address;
    private AppointmentRepository appointmentRepository;

    public Admin(String name, String surname, String address, AppointmentRepository appointmentRepository) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.appointmentRepository = appointmentRepository;
    }

    public UUID bookAppointment(List<Service> services, String address, LocalDateTime appointmentDataTime, Client client) {
        System.out.println("Booking appointment");
        return appointmentRepository.create(services, address, appointmentDataTime, client);
    }

    public Appointment readAppointment(UUID id) {
        System.out.println("Print appointment");
        return appointmentRepository.read(id);
    }

    public String getAddress() {
        return address;
    }
}

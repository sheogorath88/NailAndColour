package com.nailandcolour;

import java.time.LocalDate;
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

    public UUID bookAppointment(List<Service> services, String address, LocalDate appointmentDataTime, Client client){
        System.out.println("Booking appointment");
        return appointmentRepository.create(services, address, appointmentDataTime, client);
    }

    public Appointment readAppointment(UUID id){
        System.out.println("Print appointment");
        return appointmentRepository.read(id);
    }

    public String getAddress() {
        return address;
    }
}

package com.nailandcolour;

import java.time.LocalDate;
import java.util.List;

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

    public void bookAppointment(List<Service> services, String address, LocalDate appointmentDataTime, Client client){
        System.out.println("Rejestracja klientki");
        appointmentRepository.create(services, address, appointmentDataTime, client);
    }

    public String getAddress() {
        return address;
    }
}

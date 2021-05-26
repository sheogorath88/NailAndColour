package com.nailandcolour.appointment;

import com.nailandcolour.users.Client;
import com.nailandcolour.service.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface AppointmentRepository {

    UUID create(
            List<Service> services,
            String address,
            LocalDate appointmentDataTime,
            Client client);

    Appointment read(UUID id);
    
    Set<Appointment> readAll();

    void delete(UUID id);

    void updateServices(UUID id, List<Service> newServices);

    void updateAddress(UUID id, String newAddress);

    void updateAppointmentDataTime(UUID id, LocalDate newAppointmentDataTime);

    void updateClient(UUID id, Client newClient);

}

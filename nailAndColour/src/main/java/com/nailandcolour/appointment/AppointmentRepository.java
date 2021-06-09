package com.nailandcolour.appointment;

import com.nailandcolour.users.Client;
import com.nailandcolour.service.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface AppointmentRepository {

    UUID create(
            List<Service> services,
            String address,
            LocalDateTime appointmentDataTime,
            Client client);

    Appointment read(UUID id);

    Set<Appointment> readAll();

    void delete(UUID id);

    void updateServices(UUID id, List<Service> newServices);

    void updateAddress(UUID id, String newAddress);

    void updateAppointmentDataTime(UUID id, LocalDateTime newAppointmentDataTime);

    void updateClient(UUID id, Client newClient);

}

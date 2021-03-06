package com.nailandcolour.appointment;

import com.nailandcolour.users.Client;
import com.nailandcolour.service.Service;

import java.time.LocalDateTime;
import java.util.*;

public class MemoryBasedAppointmentRepository implements AppointmentRepository {

    private Set<Appointment> appointments = new HashSet<>();

    @Override
    public UUID create(
            List<Service> services,
            String address,
            LocalDateTime appointmentDataTime,
            Client client) {
        if (services == null || services.isEmpty()
                || address == null || address.isBlank() || address.length() < 3
                || address.trim().length() < 3) {
            throw new IllegalStateException("bad data");
        }

        Appointment appointment = new Appointment(UUID.randomUUID().toString(), services, address, appointmentDataTime, client);
        appointments.add(appointment);
        return appointment.getId();
    }

    @Override
    public Appointment read(UUID id) {
        for (Appointment appointment : appointments) {
            if (appointment.getId().equals(id)) {
                return appointment;
            }
        }
        throw new IllegalStateException("Didn't find appointment with id = " + id.toString());
    }

    @Override
    public Set<Appointment> readAll() {
        return appointments;
    }

    @Override
    public void delete(UUID id) {
        Iterator<Appointment> iterator = appointments.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(id)) {
                iterator.remove();
            }
        }
    }

    @Override
    public void updateServices(UUID id, List<Service> newServices) {
        if (newServices == null || newServices.isEmpty()) {
            throw new IllegalStateException();
        }
        for (Appointment appointment : appointments) {
            if (appointment.getId().equals(id)) {
                appointment.setServices(newServices);
            }
        }
    }

    @Override
    public void updateAddress(UUID id, String newAddress) {
        if (newAddress == null || newAddress.isEmpty()
                || newAddress.length() < 3
                || newAddress.trim().length() < 3) {
            throw new IllegalStateException();
        }
        for (Appointment appointment : appointments) {
            if (appointment.getId().equals(id)) {
                appointment.setAddress(newAddress);
            }
        }
    }

    @Override
    public void updateAppointmentDataTime(UUID id, LocalDateTime newAppointmentDataTime) {
        if (newAppointmentDataTime == null || newAppointmentDataTime.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException();
        }
        for (Appointment appointment : appointments) {
            if (appointment.getId().equals(id)) {
                appointment.setAppointmentDateTime(newAppointmentDataTime);
            }
        }
    }

    @Override
    public void updateClient(UUID id, Client newClient) {
        if (newClient == null) {
            throw new IllegalStateException();
        }
        for (Appointment appointment : appointments) {
            if (appointment.getId().equals(id)) {
                appointment.setClient(newClient);
            }
        }
    }
}

package com.nailandcolour.appointment;

import com.nailandcolour.users.Client;
import com.nailandcolour.service.Service;

import java.time.LocalDate;
import java.util.*;

public class MemoryBasedAppointmentRepository implements AppointmentRepository {

    private List<Appointment> appointments = new ArrayList<>();

    @Override
    public UUID create(
            List<Service> services,
            String address,
            LocalDate appointmentDataTime,
            Client client) {
        if(services == null || services.isEmpty()
            || address == null || address.isBlank() || address.length() < 3){
            throw new IllegalStateException("bad data");
        }

        Appointment appointment = new Appointment(services, address, appointmentDataTime, client);
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
        for (Appointment appointment : appointments) {
            if (appointment.getId().equals(id)) {
                appointment.setServices(newServices);
            }
        }

    }

    @Override
    public void updateAddress(UUID id, String newAddress) {
        for (Appointment appointment : appointments) {
            if (appointment.getId().equals(id)) {
                appointment.setAddress(newAddress);
            }
        }
    }

    @Override
    public void updateAppointmentDataTime(UUID id, LocalDate newAppointmentDataTime) {
        for (Appointment appointment : appointments) {
            if (appointment.getId().equals(id)) {
                appointment.setAppointmentDateTime(newAppointmentDataTime);
            }
        }
    }

    @Override
    public void updateClient(UUID id, Client newClient) {
        for (Appointment appointment : appointments) {
            if (appointment.getId().equals(id)) {
                appointment.setClient(newClient);
            }
        }
    }
}

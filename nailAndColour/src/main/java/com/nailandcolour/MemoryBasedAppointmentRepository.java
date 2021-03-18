package com.nailandcolour;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MemoryBasedAppointmentRepository implements AppointmentRepository {

    private List<Appointment> appointments = new ArrayList<>();

    @Override
    public UUID create(
            List<Service> services,
            String address,
            LocalDate appointmentDataTime,
            Client client) {
        Appointment appointment = new Appointment(services, address, appointmentDataTime, client);
        appointments.add(appointment);
        return appointment.getId();
    }

    @Override
    public void read(UUID id, List<Appointment> appointments) {
        for (Appointment appointment : appointments) {
            if (appointment.getId().equals(id)) {
                System.out.println(appointment);
            } else {
                System.out.println("No appointment with this ID ");
            }
        }
    }
}

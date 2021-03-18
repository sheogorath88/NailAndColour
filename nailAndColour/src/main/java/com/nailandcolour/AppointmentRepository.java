package com.nailandcolour;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface AppointmentRepository {

    UUID create(
            List<Service> services,
            String address,
            LocalDate appointmentDataTime,
            Client client);

    void read(UUID id, List<Appointment> appointments);
}

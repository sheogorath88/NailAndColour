package com.nailandcolour;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class MemoryBasedAppointmenRepository implements AppointmentRepository{

    List<Appointment> appointments;

    @Override
    public void create(long id, List<Service> services, String address, LocalDate appointmentDataTime, BigDecimal price){
        Appointment appointment = new Appointment(id, services, address, appointmentDataTime, price);
        appointments.add(appointment);

    }
}

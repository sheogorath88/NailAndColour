package com.nailandcolour;

import org.apache.catalina.LifecycleState;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class MemoryBasedAppointmentRepositoryTest {

    @Test
    public void shouldIncludeAllParameters() {
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();
        List<Service> services = new ArrayList<>();
        String address = "test address";
        LocalDate appointmentDateTime = LocalDate.now();
        Client client = new Client.ClientBuilder().build();

        //when
        UUID id = memoryBasedAppointmentRepository.create(services, address, appointmentDateTime, client);

        //then

        Appointment appointment = memoryBasedAppointmentRepository.read(id);
        assertEquals(appointment.getServices(), services);
        assertEquals(appointment.getAddress(), address);
        assertEquals(appointment.getAppointmentDateTime(), appointmentDateTime);
        assertEquals(appointment.getClient(), client);
    }

}
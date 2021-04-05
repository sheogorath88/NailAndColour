package com.nailandcolour;

import org.apache.catalina.LifecycleState;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class MemoryBasedAppointmentRepositoryTest {

    @Test
    public void shouldIncludeListOfServicesAddressDateTimeClientAfterCreate() {
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
    @Test
    public void shouldFindAppointmentIfIdIsInTheAppointmentList(){
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();
        List<Service> services = new ArrayList<>();
        String address = "test address";
        LocalDate appointmentDataTime = LocalDate.now();
        Client client = new Client.ClientBuilder().build();
        UUID uuid = memoryBasedAppointmentRepository.create(services,address, appointmentDataTime, client);

        //when
        Appointment appointment = memoryBasedAppointmentRepository.read(uuid);

        //then
        assertNotNull(appointment);
    }
    @Test
    public void shouldThrowExceptionWhenListIsEmpty(){
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();

        //when
        Assertions.assertThrows(IllegalStateException.class, ()->{
            memoryBasedAppointmentRepository.read(UUID.randomUUID());
        });



        //then

    }
}
package com.nailandcolour;

import com.nailandcolour.appointment.Appointment;
import com.nailandcolour.appointment.MemoryBasedAppointmentRepository;
import com.nailandcolour.service.Manicure;
import com.nailandcolour.service.Pedicure;
import com.nailandcolour.service.Service;
import com.nailandcolour.users.Client;
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
        services.add(new Manicure());
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
    public void shouldThrowExceptionAndNotCreateAppointmentWhenServicesIsNull() {
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();
        String address = "test address";
        LocalDate appointmentDateTime = LocalDate.now();
        Client client = new Client.ClientBuilder().build();

        //when
        //then
        Assertions.assertThrows(IllegalStateException.class, ()->{
            memoryBasedAppointmentRepository.create(null, address, appointmentDateTime, client);
        });
    }

    @Test
    public void shouldThrowExceptionAndNotCreateAppointmentWhenServicesIsEmpty() {
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();
        List<Service> services = new ArrayList<>();
        String address = "test address";
        LocalDate appointmentDateTime = LocalDate.now();
        Client client = new Client.ClientBuilder().build();

        //when
        //then
        Assertions.assertThrows(IllegalStateException.class, ()->{
            memoryBasedAppointmentRepository.create(services, address, appointmentDateTime, client);
        });
    }

    @Test
    public void shouldThrowExceptionAndNotCreateAppointmentWhenAddressIsNull() {
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();
        List<Service> services = new ArrayList<>();
        services.add(new Pedicure());
        LocalDate appointmentDateTime = LocalDate.now();
        Client client = new Client.ClientBuilder().build();

        //when
        //then
        Assertions.assertThrows(IllegalStateException.class, ()->{
            memoryBasedAppointmentRepository.create(services, null, appointmentDateTime, client);
        });
    }

    @Test
    public void shouldThrowExceptionAndNotCreateAppointmentWhenAddressIsEmpty() {
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();
        List<Service> services = new ArrayList<>();
        services.add(new Pedicure());
        String address = "";
        LocalDate appointmentDateTime = LocalDate.now();
        Client client = new Client.ClientBuilder().build();

        //when
        //then
        Assertions.assertThrows(IllegalStateException.class, ()->{
            memoryBasedAppointmentRepository.create(services, address, appointmentDateTime, client);
        });
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
    }

    @Test
    public void shouldGiveANewAddressInAppointment(){
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();
        List<Service> services = new ArrayList<>();
        String address = "test address";
        LocalDate appointmentDataTime = LocalDate.now();
        Client client = new Client.ClientBuilder().build();
        UUID uuid = memoryBasedAppointmentRepository.create(services,address, appointmentDataTime, client);

        // when
        memoryBasedAppointmentRepository.updateAddress(uuid, "new Address");

        // then
        Appointment appointment = memoryBasedAppointmentRepository.read(uuid);
        assertEquals("new Address", appointment.getAddress());
    }
}
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
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        Assertions.assertThrows(IllegalStateException.class, () -> {
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
        Assertions.assertThrows(IllegalStateException.class, () -> {
            memoryBasedAppointmentRepository.create(services, address, appointmentDateTime, client);
        });
    }

    @Test
    public void shouldThrowExceptionAndNotCreateAppointmentWhenAddressIsToShort() {
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();
        List<Service> services = new ArrayList<>();
        services.add(new Pedicure());
        String address = "bf";
        LocalDate appointmentDateTime = LocalDate.now();
        Client client = new Client.ClientBuilder().build();

        //when
        //then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            memoryBasedAppointmentRepository.create(services, address, appointmentDateTime, client);
        });
    }

    @Test
    public void shouldThrowExceptionAndNotCreateAppointmentWhenAddressIsWithWhitespace() {
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();
        List<Service> services = new ArrayList<>();
        services.add(new Pedicure());
        String address = " m   ";
        LocalDate appointmentDateTime = LocalDate.now();
        Client client = new Client.ClientBuilder().build();

        //when
        //then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            memoryBasedAppointmentRepository.create(services, address, appointmentDateTime, client);
        });
    }

    @Test
    public void shouldThrowExceptionAndNotCreateAppointmentWhenAppointmentDataTimeIsNull() {
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();
        List<Service> services = new ArrayList<>();
        String address = "test address";
        Client client = new Client.ClientBuilder().build();

        //when
        //then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            memoryBasedAppointmentRepository.create(services, address, null, client);
        });
    }

    @Test
    public void shouldThrowExceptionAndNotCreateAppointmentWhenClientIsNull() {
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();
        List<Service> services = new ArrayList<>();
        String address = "test address";
        LocalDate appointmentDataTime = LocalDate.now();

        //when
        //then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            memoryBasedAppointmentRepository.create(services, address, appointmentDataTime, null);
        });
    }

    @Test
    public void shouldFindAppointmentIfIdIsInTheAppointmentSet() {
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();
        List<Service> services = new ArrayList<>();
        services.add(new Manicure());
        String address = "test address";
        LocalDate appointmentDataTime = LocalDate.now();
        Client client = new Client.ClientBuilder().build();
        UUID uuid = memoryBasedAppointmentRepository.create(services, address, appointmentDataTime, client);

        //when
        Appointment appointment = memoryBasedAppointmentRepository.read(uuid);

        //then
        assertNotNull(appointment);
    }

    @Test
    public void shouldThrowExceptionWhenListIsEmpty() {
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();

        //when
        Assertions.assertThrows(IllegalStateException.class, () -> {
            memoryBasedAppointmentRepository.read(UUID.randomUUID());
        });
    }

    @Test
    public void shouldGiveANewAddressInAppointment() {
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();
        List<Service> services = new ArrayList<>();
        services.add(new Manicure());
        String address = "test address";
        LocalDate appointmentDataTime = LocalDate.now();
        Client client = new Client.ClientBuilder().build();
        UUID uuid = memoryBasedAppointmentRepository.create(services, address, appointmentDataTime, client);

        // when
        memoryBasedAppointmentRepository.updateAddress(uuid, "new Address");

        // then
        Appointment appointment = memoryBasedAppointmentRepository.read(uuid);
        assertEquals("new Address", appointment.getAddress());
    }

    @Test
    public void shouldThrowExceptionWhenNewAddressIsNull() {
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();
        List<Service> services = new ArrayList<>();
        services.add(new Pedicure());
        String address = "test address";
        LocalDate appointmentDataTime = LocalDate.now();
        Client client = new Client.ClientBuilder().build();
        UUID uuid = memoryBasedAppointmentRepository.create(services, address, appointmentDataTime, client);

        // when
        // then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            memoryBasedAppointmentRepository.updateAddress(uuid, null);
        });
    }

    @Test
    public void shouldThrowExceptionWhenNewAddressIsEmpty() {
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();
        List<Service> services = new ArrayList<>();
        services.add(new Pedicure());
        String address = "test address";
        LocalDate appointmentDataTime = LocalDate.now();
        Client client = new Client.ClientBuilder().build();
        UUID uuid = memoryBasedAppointmentRepository.create(services, address, appointmentDataTime, client);

        // when
        // then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            memoryBasedAppointmentRepository.updateAddress(uuid, "");
        });
    }

    @Test
    public void shouldThrowExceptionWhenNewAddressIsToShort() {
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();
        List<Service> services = new ArrayList<>();
        services.add(new Pedicure());
        String address = "test address";
        LocalDate appointmentDataTime = LocalDate.now();
        Client client = new Client.ClientBuilder().build();
        UUID uuid = memoryBasedAppointmentRepository.create(services, address, appointmentDataTime, client);

        // when
        // then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            memoryBasedAppointmentRepository.updateAddress(uuid, "mk");
        });
    }

    @Test
    public void shouldThrowExceptionWhenNewAddressGotWhitespace() {
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();
        List<Service> services = new ArrayList<>();
        services.add(new Pedicure());
        String address = "test address";
        LocalDate appointmentDataTime = LocalDate.now();
        Client client = new Client.ClientBuilder().build();
        UUID uuid = memoryBasedAppointmentRepository.create(services, address, appointmentDataTime, client);

        // when
        // then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            memoryBasedAppointmentRepository.updateAddress(uuid, "   mm  ");
        });
    }

    @Test
    public void shouldGiveNewServicesInAppointment() {
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();
        List<Service> services = new ArrayList<>();
        services.add(new Manicure());
        String address = "test address";
        LocalDate appointmentDataTime = LocalDate.now();
        Client client = new Client.ClientBuilder().build();
        UUID uuid = memoryBasedAppointmentRepository.create(services, address, appointmentDataTime, client);
        List<Service> newServices = new ArrayList<>();
        newServices.add(new Pedicure());

        // when
        memoryBasedAppointmentRepository.updateServices(uuid, newServices);

        // then
        Appointment appointment = memoryBasedAppointmentRepository.read(uuid);
        assertEquals(newServices, appointment.getServices());
    }

    @Test
    public void shouldThrowExceptionWhenNewServicesListIsNull() {
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();
        List<Service> services = new ArrayList<>();
        services.add(new Pedicure());
        String address = "test address";
        LocalDate appointmentDataTime = LocalDate.now();
        Client client = new Client.ClientBuilder().build();
        UUID uuid = memoryBasedAppointmentRepository.create(services, address, appointmentDataTime, client);

        // when
        // then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            memoryBasedAppointmentRepository.updateServices(uuid, null);
        });
    }

    @Test
    public void shouldThrowExceptionWhenNewServicesListIsEmpty() {
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();
        List<Service> services = new ArrayList<>();
        services.add(new Pedicure());
        String address = "test address";
        LocalDate appointmentDataTime = LocalDate.now();
        Client client = new Client.ClientBuilder().build();
        UUID uuid = memoryBasedAppointmentRepository.create(services, address, appointmentDataTime, client);
        List<Service> newServices = new ArrayList<>();

        // when
        // then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            memoryBasedAppointmentRepository.updateServices(uuid, newServices);
        });
    }

    @Test
    public void shouldGiveNewAppointmentDataTimeInAppointment() {
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();
        List<Service> services = new ArrayList<>();
        services.add(new Manicure());
        String address = "test address";
        LocalDate appointmentDataTime = LocalDate.now();
        Client client = new Client.ClientBuilder().build();
        UUID uuid = memoryBasedAppointmentRepository.create(services, address, appointmentDataTime, client);
        LocalDate newAppointmentDataTime = LocalDate.of(2021, 12, 15);

        // when
        memoryBasedAppointmentRepository.updateAppointmentDataTime(uuid, newAppointmentDataTime);

        // then
        Appointment appointment = memoryBasedAppointmentRepository.read(uuid);
        assertEquals(newAppointmentDataTime, appointment.getAppointmentDateTime());
    }

    @Test
    public void shouldThrowExceptionWhenNewAppointmentDataTimeIsNull() {
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();
        List<Service> services = new ArrayList<>();
        services.add(new Pedicure());
        String address = "test address";
        LocalDate appointmentDataTime = LocalDate.now();
        Client client = new Client.ClientBuilder().build();
        UUID uuid = memoryBasedAppointmentRepository.create(services, address, appointmentDataTime, client);

        // when
        // then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            memoryBasedAppointmentRepository.updateAppointmentDataTime(uuid, null);
        });
    }

    @Test
    public void shouldThrowExceptionWhenNewAppointmentDataTimeIsBeforeNow() {
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();
        List<Service> services = new ArrayList<>();
        services.add(new Pedicure());
        String address = "test address";
        LocalDate appointmentDataTime = LocalDate.now();
        Client client = new Client.ClientBuilder().build();
        UUID uuid = memoryBasedAppointmentRepository.create(services, address, appointmentDataTime, client);
        LocalDate newLocalData = LocalDate.of(2020, 12, 15);

        // when
        // then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            memoryBasedAppointmentRepository.updateAppointmentDataTime(uuid, newLocalData);
        });
    }

    @Test
    public void shouldGiveNewClientInAppointment() {
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();
        List<Service> services = new ArrayList<>();
        services.add(new Manicure());
        String address = "test address";
        LocalDate appointmentDataTime = LocalDate.now();
        Client client = new Client.ClientBuilder().build();
        UUID uuid = memoryBasedAppointmentRepository.create(services, address, appointmentDataTime, client);
        Client newClient = new Client.ClientBuilder().build();

        // when
        memoryBasedAppointmentRepository.updateClient(uuid, newClient);

        // then
        Appointment appointment = memoryBasedAppointmentRepository.read(uuid);
        assertEquals(newClient, appointment.getClient());
    }

    @Test
    public void shouldThrowExceptionWhenNewClientIsNull() {
        //given
        MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();
        List<Service> services = new ArrayList<>();
        services.add(new Pedicure());
        String address = "test address";
        LocalDate appointmentDataTime = LocalDate.now();
        Client client = new Client.ClientBuilder().build();
        UUID uuid = memoryBasedAppointmentRepository.create(services, address, appointmentDataTime, client);

        // when
        // then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            memoryBasedAppointmentRepository.updateClient(uuid, null);
        });
    }
}
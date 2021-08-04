package com.nailandcolour.appointment;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

class CSVBasedAppointmentRepositoryTest {

    @Mock
    private ClientRepository clientRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void shouldReturnAppointments(){
        //given
        String appointmentsFileName = "src\\test\\resources\\test_appointments.csv";
        String clientFileName = "src\\test\\resources\\test_clients.csv";
        when(clientRepository.readAll()).thenReturn(new ArrayList<>());
        CSVBasedAppointmentRepository csvBasedAppointmentRepository = new CSVBasedAppointmentRepository(
            appointmentsFileName, clientRepository);

        //when
        Set<Appointment> appointments = csvBasedAppointmentRepository.readAll();

        //then
        List<Appointment> appointmentList = new ArrayList<>(appointments);
        Assertions.assertTrue(appointments.size() == 1);
        Assertions.assertEquals("7453ae42-35cc-492c-a0fa-7aeced283073",
                appointmentList.get(0).getId().toString());
    }

    @Test
    public void shouldThrowExceptionAndNotReadAllAppointments() {
        //given
        String appointmentsFileName = "src\\test\\resources\\test_appointments.csv";
        String clientFileName = "src\\test\\resources\\test_clients.csv";
        when(clientRepository.readAll()).thenThrow(new IllegalStateException());

        //when
        //then

        Assertions.assertThrows(Exception.class, () -> {
            clientRepository.readAll();
        });
    }
}
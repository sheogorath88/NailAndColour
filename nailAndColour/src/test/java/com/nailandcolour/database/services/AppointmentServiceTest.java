package com.nailandcolour.database.services;

import com.nailandcolour.database.dto.Appointment;
import com.nailandcolour.database.repositories.AppointmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.when;

class AppointmentServiceTest {

    @Mock
    private AppointmentRepository appointmentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldReturnAppointments() {
        //given
        when(appointmentRepository.findAll()).thenReturn(List.of());
        AppointmentService appointmentService = new AppointmentService(appointmentRepository);

        //when
        List<Appointment> appointments = appointmentService.readAll();

        //then
        Assertions.assertTrue(appointments.size() == 0);
    }

}
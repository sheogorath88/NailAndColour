package com.nailandcolour.appointment;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CSVBasedAppointmentRepositoryTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void shouldReturnAppointments(){
        //given
        String fileName = "test_appointments.csv";
        CSVBasedAppointmentRepository csvBasedAppointmentRepository = new CSVBasedAppointmentRepository(fileName);

        //when
        Set<Appointment> appointments = csvBasedAppointmentRepository.readAll();

        //then
        List<Appointment> appointmentList = new ArrayList<>(appointments);
        Assertions.assertTrue(appointments.size() == 1);
        Assertions.assertEquals("7453ae42-35cc-492c-a0fa-7aeced283073",
                appointmentList.get(0));
    }
}
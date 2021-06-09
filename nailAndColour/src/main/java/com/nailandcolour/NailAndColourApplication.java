package com.nailandcolour;

import com.nailandcolour.appointment.Appointment;
import com.nailandcolour.appointment.AppointmentRepository;
import com.nailandcolour.appointment.CSVBasedAppointmentRepository;
import com.nailandcolour.appointment.CSVBasedClientRepository;
import com.nailandcolour.appointment.MemoryBasedAppointmentRepository;
import com.nailandcolour.service.Manicure;
import com.nailandcolour.service.Service;
import com.nailandcolour.users.Admin;
import com.nailandcolour.users.Client;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class NailAndColourApplication {

    public static void main(String[] args) {
//		SpringApplication.run(NailAndColourApplication.class, args);

        Admin admin = new Admin(
                "Ania",
                "Kowalska",
                "Kowalowa 10",
                new MemoryBasedAppointmentRepository()
        );
        Client client = new Client.ClientBuilder()
                .setId("ba516cf1-818b-4373-a774-9c8f3c719dc6")
                .setName("Anna")
                .setSurname("Kowalska")
                .setAddress("Przykladowa 5")
                .setTelephoneNumber("736627737")
                .build();

        List<Service> services = new ArrayList<>();
        services.add(new Manicure());

        UUID idOfBookedAppointment = admin.bookAppointment(services, admin.getAddress(), LocalDateTime.now(), client);

        System.out.println(admin.readAppointment(idOfBookedAppointment));

        String appointmentsFileName = "data\\appointment.csv";
        String clientFileName = "data\\client.csv";
        AppointmentRepository appointmentRepository = new CSVBasedAppointmentRepository(
            appointmentsFileName,
            new CSVBasedClientRepository(clientFileName));
        Set<Appointment> appointments = appointmentRepository.readAll();
        Iterator<Appointment> iterator = appointments.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

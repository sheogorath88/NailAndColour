package com.nailandcolour;

import com.nailandcolour.appointment.AppointmentRepository;
import com.nailandcolour.appointment.CSVBasedAppointmentRepository;
import com.nailandcolour.appointment.MemoryBasedAppointmentRepository;
import com.nailandcolour.service.Manicure;
import com.nailandcolour.service.Service;
import com.nailandcolour.users.Admin;
import com.nailandcolour.users.Client;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
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
                .setId("7")
                .setName("Anna")
                .setSurname("Kowalska")
                .setAddress("Przykladowa 5")
                .setTelephoneNumber("736627737")
                .build();

        List<Service> services = new ArrayList<>();
        services.add(new Manicure());

        UUID idOfBookedAppointment = admin.bookAppointment(services, admin.getAddress(), LocalDate.now(), client);

        System.out.println(admin.readAppointment(idOfBookedAppointment));

        String fileName = "data\\appointment.csv";
        AppointmentRepository appointmentRepository = new CSVBasedAppointmentRepository(fileName);
        appointmentRepository.readAll();
    }
}

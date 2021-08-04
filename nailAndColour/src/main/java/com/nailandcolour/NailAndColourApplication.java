package com.nailandcolour;

import com.nailandcolour.appointment.*;
import com.nailandcolour.service.Manicure;
import com.nailandcolour.service.Service;
import com.nailandcolour.users.Admin;
import com.nailandcolour.users.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.*;

@SpringBootApplication
public class NailAndColourApplication {

    public static void main(String[] args) {
        SpringApplication.run(NailAndColourApplication.class, args);
    }

    private static void createServicesByHand() {
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
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

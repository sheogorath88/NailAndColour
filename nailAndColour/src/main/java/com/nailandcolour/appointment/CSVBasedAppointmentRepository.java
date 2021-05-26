package com.nailandcolour.appointment;

import com.nailandcolour.exceptions.UnrecognizableServiceException;
import com.nailandcolour.service.Manicure;
import com.nailandcolour.service.Pedicure;
import com.nailandcolour.service.Service;
import com.nailandcolour.users.Client;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class CSVBasedAppointmentRepository implements AppointmentRepository {

    public CSVBasedAppointmentRepository(String fileName) {
        this.fileName = fileName;
    }
    private String fileName = "data\\appointment.csv";

    @Override
    public UUID create(List<Service> services, String address, LocalDate appointmentDataTime, Client client) {
        try {
            CSVWriter csvWriter = new CSVWriter(new FileWriter(fileName));
            String newService;
            if(services.equals(new Manicure())){
                newService = "M";
            }else if(services.equals(new Pedicure())){
                newService = "P";
            }else {
                throw new UnrecognizableServiceException("bad service");
            }
            String newAppointmentDataTime = appointmentDataTime.toString();
            String newClient = client.toString();
            String uuid = UUID.randomUUID().toString();

            String[] appoint = {newService, address, newAppointmentDataTime, newClient};

            csvWriter.writeNext(appoint);
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Appointment read(UUID id) {
        return null;
    }

    @Override
    public Set<Appointment> readAll() {
        Set<Appointment> appointments = new HashSet<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(fileName));
             CSVReader csvReader = new CSVReader(reader)) {

//            ignore header
            String[] appoint = csvReader.readNext();
            while ((appoint = csvReader.readNext()) != null) {
                for (int i = 0; i < appoint.length; i++) {
                    String address = appoint[2];
                    List<Service> services = convertCsvFieldToService(appoint[1]);
                    LocalDate appointmentDataTime = LocalDate.parse(appoint[3]);
                    //TODO
                    Client client = ClientRepository.read(appoint[5]);
                    Appointment app = new Appointment(services, address, appointmentDataTime, client);
                    System.out.println(app);
                    appointments.add(app);
                }
            }
        } catch (IOException | CsvValidationException ex) {
            ex.printStackTrace();
        }
        return appointments;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public void updateServices(UUID id, List<Service> newServices) {

    }

    @Override
    public void updateAddress(UUID id, String newAddress) {

    }

    @Override
    public void updateAppointmentDataTime(UUID id, LocalDate newAppointmentDataTime) {

    }

    @Override
    public void updateClient(UUID id, Client newClient) {

    }

    private List<Service> convertCsvFieldToService(String service) {
        List<Service> services = new ArrayList<>();
        services.add(ServiceKind.from(service));
        return services;
    }
}

package com.nailandcolour;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Appointment {

    private UUID id;
    private List<Service> services;
    private String address;
    private LocalDate appointmentDateTime;
    private Client client;

    public Appointment(List<Service> services, String address, LocalDate appointmentDateTime, Client client) {
        this.id = UUID.randomUUID();
        this.services = services;
        this.address = address;
        this.appointmentDateTime = appointmentDateTime;
        this.client = client;
    }
    public BigDecimal sumOfPrices(){
        BigDecimal temp = new BigDecimal("0");
        for(int i = 0; i < services.size(); i++){
            Service service = services.get(i);
            BigDecimal price = service.price();
            temp = temp.add(price);
        }
        return temp;
    }

    public UUID getId() {
        return id;
    }
}

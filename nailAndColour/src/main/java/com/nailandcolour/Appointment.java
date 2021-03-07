package com.nailandcolour;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Appointment {

    private long id;
    private List<Service> services;
    private String address;
    private LocalDate appointmentDateTime;
    private BigDecimal price;

    public Appointment(long id, List<Service> services, String address, LocalDate appointmentDateTime, BigDecimal price) {
        this.id = id;
        this.services = services;
        this.address = address;
        this.appointmentDateTime = appointmentDateTime;
        this.price = price;
    }
}

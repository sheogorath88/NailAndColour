package com.nailandcolour.appointment;

import com.nailandcolour.users.Client;
import com.nailandcolour.service.Service;

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

    public Appointment(String id, List<Service> services, String address, LocalDate appointmentDateTime, Client client) {
        this.id = UUID.fromString(id);
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

    public List<Service> getServices() {
        return services;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public Client getClient() {
        return client;
    }

    public Appointment setServices(List<Service> services) {
        this.services = services;
        return this;
    }

    public Appointment setAddress(String address) {
        this.address = address;
        return this;
    }

    public Appointment setAppointmentDateTime(LocalDate appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
        return this;
    }

    public Appointment setClient(Client client) {
        this.client = client;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appointment that = (Appointment) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (services != null ? !services.equals(that.services) : that.services != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (appointmentDateTime != null ? !appointmentDateTime.equals(that.appointmentDateTime) : that.appointmentDateTime != null)
            return false;
        return client != null ? client.equals(that.client) : that.client == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (services != null ? services.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (appointmentDateTime != null ? appointmentDateTime.hashCode() : 0);
        result = 31 * result + (client != null ? client.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", services=" + services +
                ", address='" + address + '\'' +
                ", appointmentDateTime=" + appointmentDateTime +
                ", client=" + client +
                '}';
    }
}

package com.nailandcolour.database.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @Column(name = "appointment_id")
    private int appointmentId;

    @Column(name = "date_time_id")
    private int dateTimeId;

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "service_id")
    private int serviceId;

    @Column(name = "client_id")
    private int clientId;

    public Appointment(int appointmentId, int dateTimeId, int employeeId, int serviceId, int clientId) {
        this.appointmentId = appointmentId;
        this.dateTimeId = dateTimeId;
        this.employeeId = employeeId;
        this.serviceId = serviceId;
        this.clientId = clientId;
    }

    public Appointment() {
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public int getDateTimeId() {
        return dateTimeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public int getClientId() {
        return clientId;
    }

//    public Appointment setAppointmentId(int appointmentId) {
//        this.appointmentId = appointmentId;
//        return this;
//    }
//
//    public Appointment setDateTimeId(int dateTimeId) {
//        this.dateTimeId = dateTimeId;
//        return this;
//    }
//
//    public Appointment setEmployeeId(int employeeId) {
//        this.employeeId = employeeId;
//        return this;
//    }
//
//    public Appointment setServiceId(int serviceId) {
//        this.serviceId = serviceId;
//        return this;
//    }
//
//    public Appointment setClientId(int clientId) {
//        this.clientId = clientId;
//        return this;
//    }


    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setDateTimeId(int dateTimeId) {
        this.dateTimeId = dateTimeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}

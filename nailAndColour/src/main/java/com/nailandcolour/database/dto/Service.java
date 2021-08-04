package com.nailandcolour.database.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "service")
public class Service implements Serializable {

    @Id
    @Column(name = "service_id")
    private int serviceId;

    @Column(name = "service_name")
    private String serviceName;

    public Service(int serviceId, String serviceName) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
    }

    public Service() {
    }

    public int getServiceId() {
        return serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public Service setServiceId(int serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    public Service setServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }
}

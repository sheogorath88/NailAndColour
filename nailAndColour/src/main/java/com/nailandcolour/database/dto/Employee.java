package com.nailandcolour.database.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "personal_data_id")
    private int personalDataId;

    @Column(name = "address_id")
    private int addressId;

    public Employee(int employeeId, int personalDataId, int addressId) {
        this.employeeId = employeeId;
        this.personalDataId = personalDataId;
        this.addressId = addressId;
    }

    public Employee() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getPersonalDataId() {
        return personalDataId;
    }

    public int getAddressId() {
        return addressId;
    }

    public Employee setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public Employee setPersonalDataId(int personalDataId) {
        this.personalDataId = personalDataId;
        return this;
    }

    public Employee setAddressId(int addressId) {
        this.addressId = addressId;
        return this;
    }
}

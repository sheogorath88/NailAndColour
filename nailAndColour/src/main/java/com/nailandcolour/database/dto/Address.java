package com.nailandcolour.database.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "address_id")
    private int addressId;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private int number;

    public Address(int addressId, String street, int number) {
        this.addressId = addressId;
        this.street = street;
        this.number = number;
    }

    public Address() {
    }

    public int getAddressId() {
        return addressId;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public Address setAddressId(int addressId) {
        this.addressId = addressId;
        return this;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public Address setNumber(int number) {
        this.number = number;
        return this;
    }
}

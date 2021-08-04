package com.nailandcolour.database.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "client")
public class Client implements Serializable {

    @Id
    @Column(name = "client_id")
    private int clientId;

    @Column(name = "personal_data_id")
    private int personalDataId;

    @Column(name = "address_id")
    private int addressId;

    public Client(int clientId, int personalDataId, int addressId) {
        this.clientId = clientId;
        this.personalDataId = personalDataId;
        this.addressId = addressId;
    }

    public Client() {
    }

    public int getClientId() {
        return clientId;
    }

    public int getPersonalDataId() {
        return personalDataId;
    }

    public int getAddressId() {
        return addressId;
    }

    public Client setClientId(int clientId) {
        this.clientId = clientId;
        return this;
    }

    public Client setPersonalDataId(int personalDataId) {
        this.personalDataId = personalDataId;
        return this;
    }

    public Client setAddressId(int addressId) {
        this.addressId = addressId;
        return this;
    }
}

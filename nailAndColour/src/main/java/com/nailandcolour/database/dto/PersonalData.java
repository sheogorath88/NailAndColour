package com.nailandcolour.database.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personal_data")
public class PersonalData {

    @Id
    @Column(name = "personal_data_id")
    private int personalDataId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "telephone")
    private int telephone;

    public PersonalData(int personalDataId, String name, String surname, int telephone) {
        this.personalDataId = personalDataId;
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
    }

    public PersonalData() {
    }

    public int getPersonalDataId() {
        return personalDataId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getTelephone() {
        return telephone;
    }

    public PersonalData setPersonalDataId(int personalDataId) {
        this.personalDataId = personalDataId;
        return this;
    }

    public PersonalData setName(String name) {
        this.name = name;
        return this;
    }

    public PersonalData setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonalData setTelephone(int telephone) {
        this.telephone = telephone;
        return this;
    }
}

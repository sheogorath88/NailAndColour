package com.nailandcolour.users;

import java.util.UUID;

public class Client {

    private UUID id;
    private String name;
    private String surname;
    private String address;
    private int telephoneNumber;

    private Client(ClientBuilder clientBuilder) {
        this.id = clientBuilder.id;
        this.name = clientBuilder.name;
        this.surname = clientBuilder.surname;
        this.address = clientBuilder.address;
        this.telephoneNumber = clientBuilder.telephoneNumber;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", telephoneNumber=" + telephoneNumber +
                '}';
    }

    public static class ClientBuilder {
        private UUID id;
        private String name;
        private String surname;
        private String address;
        private int telephoneNumber;

        public ClientBuilder setId(String id) {
            this.id = UUID.fromString(id);
            return this;
        }

        public ClientBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ClientBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public ClientBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public ClientBuilder setTelephoneNumber(String telephoneNumber) {
            this.telephoneNumber = Integer.parseInt(telephoneNumber);
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }
}

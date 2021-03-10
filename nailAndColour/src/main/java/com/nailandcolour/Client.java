package com.nailandcolour;

public class Client {

    private String name;
    private String surname;
    private String address;
    private int telephoneNumber;

    private Client(ClientBuilder clientBuilder) {
        this.name = clientBuilder.name;
        this.surname = clientBuilder.surname;
        this.address = clientBuilder.address;
        this.telephoneNumber = clientBuilder.telephoneNumber;
    }

    public static class ClientBuilder{
        private String name;
        private String surname;
        private String address;
        private int telephoneNumber;

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

        public ClientBuilder setTelephoneNumber(int telephoneNumber) {
            this.telephoneNumber = telephoneNumber;
            return this;
        }
        public Client build(){
            return new Client(this);
        }
    }
}

package com.nailandcolour.users;

public class Client {

    private int id;
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

    public static class ClientBuilder{
        private int id;
        private String name;
        private String surname;
        private String address;
        private int telephoneNumber;

        public ClientBuilder setId(String id){
            this.id = Integer.parseInt(id);
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
        public Client build(){
            return new Client(this);
        }
    }
}

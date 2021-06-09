package com.nailandcolour.appointment;

import com.nailandcolour.exceptions.ClientNotExistentException;
import com.nailandcolour.users.Client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CSVBasedClientRepository implements ClientRepository {

    String clientFile;

    public CSVBasedClientRepository(String clientFile) {
        this.clientFile = clientFile;
    }

    @Override
    public List<Client> readAll() {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        List<Client> clientList = new ArrayList<>();
        try {
            fileReader = new FileReader(clientFile);
            bufferedReader = new BufferedReader(fileReader);
            List<String> clients = bufferedReader.lines().collect(Collectors.toList());
            for (int i = 1; i < clients.size(); i++) {
                String clientAsString = clients.get(i);
                String[] fieldsOfClient = clientAsString.split(",");
                Client client = new Client.ClientBuilder()
                        .setId(fieldsOfClient[0])
                        .setName(fieldsOfClient[1])
                        .setSurname(fieldsOfClient[2])
                        .setAddress(fieldsOfClient[3])
                        .setTelephoneNumber(fieldsOfClient[4])
                        .build();
                clientList.add(client);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return clientList;
    }

    @Override
    public Client read(String id) {
        UUID idOfSearchedClient = UUID.fromString(id);
        List<Client> clients = readAll();
        for (Client client : clients) {
            if (client.getId().equals(idOfSearchedClient)) {
                return client;
            }
        }
        throw new ClientNotExistentException("client with this id " + id + " doesn't exist");
    }
}

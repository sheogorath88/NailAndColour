package com.nailandcolour.appointment;

import com.nailandcolour.users.Client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CSVBasedClientRepository implements ClientRepository{

    String clientFile  = "data\\client.csv";

    @Override
    public List<Client> readAll() {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        List<Client> clientList = new ArrayList<>();
        try {
            fileReader = new FileReader(clientFile);
            bufferedReader = new BufferedReader(fileReader);
            List<String> clients = bufferedReader.lines().collect(Collectors.toList());
            for(int i = 1; i < clients.size(); i++){
                String clientAsString = clients.get(i);
                String[] fieldsOfClient = clientAsString.split(",");
                Client client = new Client.ClientBuilder()
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
            if(fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}

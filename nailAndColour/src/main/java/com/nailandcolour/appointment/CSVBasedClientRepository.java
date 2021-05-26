package com.nailandcolour.appointment;

import com.nailandcolour.users.Client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public interface CSVBasedClientRepository {

    String clientFile  = "data\\client.csv";

        BufferedReader br = new BufferedReader(new FileReader(clientFile));
}

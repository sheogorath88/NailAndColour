package com.nailandcolour.appointment;

import com.nailandcolour.users.Client;

import java.util.List;

public interface ClientRepository {

    List<Client> readAll();

    Client read(String id);
}

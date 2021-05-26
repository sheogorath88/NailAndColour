package com.nailandcolour.appointment;

import com.nailandcolour.users.Client;
import java.util.List;

public interface ClientRepository {

  public List<Client> readAll();
}

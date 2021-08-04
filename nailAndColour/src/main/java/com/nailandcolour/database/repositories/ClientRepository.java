package com.nailandcolour.database.repositories;

import com.nailandcolour.database.dto.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}

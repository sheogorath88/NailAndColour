package com.nailandcolour.database.repositories;

import com.nailandcolour.database.dto.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}

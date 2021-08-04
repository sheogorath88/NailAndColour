package com.nailandcolour.database.repositories;

import com.nailandcolour.database.dto.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}

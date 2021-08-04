package com.nailandcolour.database.repositories;

import com.nailandcolour.database.dto.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDataRepository extends JpaRepository<PersonalData, Integer> {
}

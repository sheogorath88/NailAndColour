package com.nailandcolour.database.repositories;

import com.nailandcolour.database.dto.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDataRepository extends JpaRepository<PersonalData, Integer> {
}

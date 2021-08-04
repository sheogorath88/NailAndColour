package com.nailandcolour.database.repositories;

import com.nailandcolour.database.dto.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateTimeRepository extends JpaRepository<DateTime, Integer> {
}

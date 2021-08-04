package com.nailandcolour.database.repositories;

import com.nailandcolour.database.dto.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}

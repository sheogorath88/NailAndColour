package com.nailandcolour.database.repositories;

import com.nailandcolour.database.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

package com.nailandcolour.database.config;

import com.nailandcolour.database.dto.Appointment;
import com.nailandcolour.database.repositories.AppointmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppointmentConfig {

    @Bean
    CommandLineRunner commandLineRunner(AppointmentRepository repository) {
        return args -> {
            Appointment appointment = new Appointment(
                    11,
                    3,
                    2,
                    3,
                    4);
            repository.save(appointment);

        };
    }
}

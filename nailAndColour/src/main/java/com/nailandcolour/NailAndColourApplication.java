package com.nailandcolour;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class NailAndColourApplication {

	public static void main(String[] args) {
//		SpringApplication.run(NailAndColourApplication.class, args);

	Admin admin = new Admin(
			"Ania",
			"Kowalska",
			"Kowalowa 10",
			new MemoryBasedAppointmentRepository()
	);
	Client client = new Client.ClientBuilder()
			.setName("Anna")
			.setSurname("Kowalska")
			.setAddress("Przykladowa 5")
			.setTelephoneNumber(736627737)
			.build();

		List<Service> services = new ArrayList<>();
		services.add(new Manicure());

	admin.bookAppointment(services, admin.getAddress(), LocalDate.now(), client);

	List<Appointment> appointments = new ArrayList<>();
	appointments.add(new Appointment(services, "Stawowa", LocalDate.now(), client));

	MemoryBasedAppointmentRepository memoryBasedAppointmentRepository = new MemoryBasedAppointmentRepository();
	memoryBasedAppointmentRepository.read(UUID.randomUUID(), appointments);



	}



}

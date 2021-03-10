package com.nailandcolour;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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



	}



}

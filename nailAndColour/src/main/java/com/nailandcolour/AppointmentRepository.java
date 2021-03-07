package com.nailandcolour;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository {

    void create(long id, List<Service> services, String address, LocalDate appointmentDataTime, BigDecimal price);


}

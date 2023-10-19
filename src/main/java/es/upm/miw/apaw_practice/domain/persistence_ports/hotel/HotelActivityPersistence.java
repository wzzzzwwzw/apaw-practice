package es.upm.miw.apaw_practice.domain.persistence_ports.hotel;

import es.upm.miw.apaw_practice.domain.models.hotel.HotelActivity;

public interface HotelActivityPersistence {

    HotelActivity updateInstructor(String activityName, String newInstructor);

    boolean existsActivity(String name);
}

package es.upm.miw.apaw_practice.domain.services.hotel;

import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelActivity;
import es.upm.miw.apaw_practice.domain.persistence_ports.hotel.HotelActivityPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelActivityService {

    private final HotelActivityPersistence hotelActivityPersistence;

    @Autowired
    public HotelActivityService(HotelActivityPersistence hotelActivityPersistence) {
        this.hotelActivityPersistence = hotelActivityPersistence;
    }

    public HotelActivity updateInstructor(String activityName, String newInstructor) {
        this.assertActivityNotExist(activityName);
        return this.hotelActivityPersistence.updateInstructor(activityName, newInstructor);
    }

    private void assertActivityNotExist(String name) {
        if (!this.hotelActivityPersistence.existsActivity(name)) {
            throw new NotFoundException(name + " activity not found.");
        }
    }
}

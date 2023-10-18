package es.upm.miw.apaw_practice.adapters.mongodb.hotel.persistance;

import es.upm.miw.apaw_practice.adapters.mongodb.hotel.daos.HotelActivityRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities.HotelActivityEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelActivity;
import es.upm.miw.apaw_practice.domain.persistence_ports.hotel.HotelActivityPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("hotelActivityPersistence")
public class HotelActivityPersistenceMongodb implements HotelActivityPersistence {
    private final HotelActivityRepository hotelActivityRepository;

    @Autowired
    public HotelActivityPersistenceMongodb(HotelActivityRepository hotelActivityRepository){
        this.hotelActivityRepository = hotelActivityRepository;
    }
    @Override
    public HotelActivity updateInstructor(String activityName, String newInstructor) {
        HotelActivityEntity activityEntity = this.hotelActivityRepository
                .findByName(activityName)
                .orElseThrow(() -> new NotFoundException(activityName + " activity not found."));
        activityEntity.setInstructor(newInstructor);
        return this.hotelActivityRepository.save(activityEntity).toObject();
    }

    @Override
    public boolean existsActivity(String name) {
        return this.hotelActivityRepository
                .findByName(name)
                .isPresent();
    }

}

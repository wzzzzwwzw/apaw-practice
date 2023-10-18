package es.upm.miw.apaw_practice.adapters.mongodb.hotel.persistance;

import es.upm.miw.apaw_practice.adapters.mongodb.hotel.daos.HotelRepository;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.hotel.Hotel;
import es.upm.miw.apaw_practice.domain.persistence_ports.hotel.HotelPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("hotelPersistence")
public class HotelPersistenceMongodb implements HotelPersistence {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelPersistenceMongodb(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }
    @Override
    public Hotel readByName(String name) {
        return this.hotelRepository
                .findByName(name)
                .orElseThrow(() -> new NotFoundException("Hotel " + name + " not found."))
                .toObject();
    }

}

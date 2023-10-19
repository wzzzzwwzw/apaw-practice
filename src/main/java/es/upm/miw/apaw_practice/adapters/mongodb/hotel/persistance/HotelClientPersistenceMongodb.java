package es.upm.miw.apaw_practice.adapters.mongodb.hotel.persistance;

import es.upm.miw.apaw_practice.adapters.mongodb.hotel.daos.HotelClientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities.HotelClientEntity;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelClient;
import es.upm.miw.apaw_practice.domain.persistence_ports.hotel.HotelClientPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("hotelClientPersistence")
public class HotelClientPersistenceMongodb implements HotelClientPersistence {
    private final HotelClientRepository hotelClientRepository;

    @Autowired
    public HotelClientPersistenceMongodb(HotelClientRepository hotelClientRepository){
        this.hotelClientRepository = hotelClientRepository;
    }
    @Override
    public void deleteClient(String dni) {
        this.hotelClientRepository.deleteByDni(dni);
    }
    @Override
    public boolean existsClient(String dni) {
        return this.hotelClientRepository.findByDni(dni).isPresent();
    }
    @Override
    public HotelClient updateClient(HotelClient client) {
        return this.hotelClientRepository.save(new HotelClientEntity(client)).toObject();
    }
}

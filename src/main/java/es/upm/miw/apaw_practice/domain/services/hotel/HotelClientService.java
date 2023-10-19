package es.upm.miw.apaw_practice.domain.services.hotel;

import es.upm.miw.apaw_practice.domain.persistence_ports.hotel.HotelClientPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelClientService {
    private final HotelClientPersistence hotelClientPersistence;

    @Autowired
    public HotelClientService(HotelClientPersistence hotelClientPersistence) {
        this.hotelClientPersistence = hotelClientPersistence;
    }

    public void deleteClient(String dni) {
        this.hotelClientPersistence.deleteClient(dni);
    }

    public boolean existClient(String dni) { return this.hotelClientPersistence.existsClient(dni); }

}

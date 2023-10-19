package es.upm.miw.apaw_practice.domain.persistence_ports.hotel;

import es.upm.miw.apaw_practice.domain.models.hotel.HotelClient;

public interface HotelClientPersistence {

    void deleteClient(String dni);

    HotelClient updateClient(HotelClient client);

    boolean existsClient(String dni);
}

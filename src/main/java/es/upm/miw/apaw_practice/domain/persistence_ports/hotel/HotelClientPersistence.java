package es.upm.miw.apaw_practice.domain.persistence_ports.hotel;

public interface HotelClientPersistence {

    void deleteClient(String dni);

    boolean existsClient(String dni);
}

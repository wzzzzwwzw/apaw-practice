package es.upm.miw.apaw_practice.domain.services.hotel;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.hospital.Patient;
import es.upm.miw.apaw_practice.domain.models.hotel.Hotel;
import es.upm.miw.apaw_practice.domain.models.shop.Article;
import es.upm.miw.apaw_practice.domain.models.shop.ArticlePriceUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.hospital.PatientPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.hotel.HotelPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.stream.Stream;

@Service
public class HotelService {

    private final HotelPersistence hotelPersistence;

    @Autowired
    public HotelService(HotelPersistence hotelPersistence) {
        this.hotelPersistence = hotelPersistence;
    }

    public Hotel read(String name) {
        return this.hotelPersistence.readByName(name);
    }

}

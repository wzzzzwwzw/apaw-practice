package es.upm.miw.apaw_practice.adapters.mongodb.hotel;

import es.upm.miw.apaw_practice.adapters.mongodb.hotel.daos.HotelActivityRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.daos.HotelBookingRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.daos.HotelClientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.daos.HotelRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities.HotelActivityEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities.HotelBookingEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities.HotelClientEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities.HotelEntity;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelActivity;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelClient;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@Service
public class HotelSeederService {

    @Autowired
    private HotelActivityRepository hotelActivityRepository;
    @Autowired
    private HotelClientRepository hotelClientRepository;
    @Autowired
    private HotelBookingRepository hotelBookingRepository;
    @Autowired
    private HotelRepository hotelRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Hotel Initial Load -----------");

        HotelActivityEntity[] hotelActivityEntities = {
                new HotelActivityEntity(new HotelActivity("AquaGym", "L 16:00, X 16:00, V 16:00", "Adam", 20)),
                new HotelActivityEntity(new HotelActivity("Surf", "M 10:00, J 10:00", "Lucy", 10)),
                new HotelActivityEntity(new HotelActivity("Badminton", "S 15:30, D 15:30", "Karen", 16)),
                new HotelActivityEntity(new HotelActivity("Tennis", "L 12:00, X 12:00", "Louis", 12)),
                new HotelActivityEntity(new HotelActivity("Volleyball", "X 17:00, V 17:00", "Carlos", 20))
        };
        this.hotelActivityRepository.saveAll(Arrays.asList(hotelActivityEntities));

        HotelClientEntity[] hotelClientEntities = {
                new HotelClientEntity(new HotelClient("11122233A", "first@email.com", 111222333, false)),
                new HotelClientEntity(new HotelClient("11122233B", "second@email.com", 111222334, false)),
                new HotelClientEntity(new HotelClient("11122233C", "third@email.com", 111222335, false)),
                new HotelClientEntity(new HotelClient("11122233D", "fourth@email.com", 111222336, true)),
                new HotelClientEntity(new HotelClient("11122233E", "fifth@email.com", 111222337, true)),
                new HotelClientEntity(new HotelClient("11122233F", "sixth@email.com", 111222338, false))
        };
        this.hotelClientRepository.saveAll(Arrays.asList(hotelClientEntities));

        HotelBookingEntity[] hotelBookingEntities = {
                new HotelBookingEntity(1, 327, LocalDate.of(2023, 10, 21), new BigDecimal("49.99"), hotelClientEntities[0]),
                new HotelBookingEntity(2, 517, LocalDate.of(2023, 11, 24), new BigDecimal("64.99"), hotelClientEntities[1]),
                new HotelBookingEntity(3, 291, LocalDate.of(2023, 10, 21), new BigDecimal("29.99"), hotelClientEntities[2]),
                new HotelBookingEntity(4, 962, LocalDate.of(2023, 12, 19), new BigDecimal("89.99"), hotelClientEntities[3]),
                new HotelBookingEntity(5, 205, LocalDate.of(2023, 12, 24), new BigDecimal("19.99"), hotelClientEntities[4]),
                new HotelBookingEntity(6, 385, LocalDate.of(2023, 12, 31), new BigDecimal("39.99"), hotelClientEntities[5])
        };
        this.hotelBookingRepository.saveAll(Arrays.asList(hotelBookingEntities));

        HotelEntity[] hotelEntities = {
                new HotelEntity("Diamond", 5, 700, Arrays.asList(hotelBookingEntities[0], hotelBookingEntities[1]), Arrays.asList(hotelActivityEntities)),
                new HotelEntity("Sunlight", 4, 1000, Arrays.asList(hotelBookingEntities[2], hotelBookingEntities[3]), Arrays.asList(hotelActivityEntities)),
                new HotelEntity("Palm", 3, 400, Arrays.asList(hotelBookingEntities[4], hotelBookingEntities[5]), Arrays.asList(hotelActivityEntities))
        };
        this.hotelRepository.saveAll(Arrays.asList(hotelEntities));

    }

    public void deleteAll() {
        this.hotelRepository.deleteAll();
        this.hotelActivityRepository.deleteAll();
        this.hotelBookingRepository.deleteAll();
        this.hotelClientRepository.deleteAll();
    }
}

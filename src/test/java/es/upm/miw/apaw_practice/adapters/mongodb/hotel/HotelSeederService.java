package es.upm.miw.apaw_practice.adapters.mongodb.hotel;

import es.upm.miw.apaw_practice.adapters.mongodb.hotel.dao.HotelActivityRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.dao.HotelBookingRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.dao.HotelClientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.dao.HotelRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities.HotelActivityEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities.HotelBookingEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities.HotelClientEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities.HotelEntity;
import es.upm.miw.apaw_practice.domain.models.hotel.Hotel;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelActivity;
import es.upm.miw.apaw_practice.domain.models.hotel.HotelBooking;
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
    private HotelRepository hotelRepository;
    @Autowired
    private HotelActivityRepository hotelActivityRepository;
    @Autowired
    private HotelBookingRepository hotelBookingRepository;
    @Autowired
    private HotelClientRepository hotelClientRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Hotel Initial Load -----------");

        HotelClient[][] hotelClients = {
            {
                new HotelClient("11122233A","first@email.com",111222333,false),
                new HotelClient("11122233B","second@email.com",111222334,false)
            },{
                new HotelClient("11122233C","third@email.com",111222335,false),
                new HotelClient("11122233D","fourth@email.com",111222336,true),
            },{
                new HotelClient("11122233E","fifth@email.com",111222337,true),
                new HotelClient("11122233F","sixth@email.com",111222338,false),
            }
        };

        HotelClientEntity[] hotelClientEntities = {
            new HotelClientEntity(hotelClients[0][0]),
            new HotelClientEntity(hotelClients[0][1]),
            new HotelClientEntity(hotelClients[1][0]),
            new HotelClientEntity(hotelClients[1][1]),
            new HotelClientEntity(hotelClients[2][0]),
            new HotelClientEntity(hotelClients[2][1])
        };

        HotelBooking[][] hotelBookings = {
            {
                new HotelBooking(1,327, LocalDate.parse("12-11-2023"),BigDecimal.valueOf(49.99),hotelClients[0][0]),
                new HotelBooking(2,517, LocalDate.parse("24-11-2023"),BigDecimal.valueOf(64.99),hotelClients[0][1])
            }, {
                new HotelBooking(3, 291, LocalDate.parse("21-10-2023"), BigDecimal.valueOf(29.99), hotelClients[1][0]),
                new HotelBooking(4, 962, LocalDate.parse("19-12-2023"), BigDecimal.valueOf(89.99), hotelClients[1][1])
            }, {
                new HotelBooking(5, 205, LocalDate.parse("24-12-2023"), BigDecimal.valueOf(19.99), hotelClients[2][0]),
                new HotelBooking(6, 385, LocalDate.parse("31-12-2023"), BigDecimal.valueOf(19.99), hotelClients[2][1])
            }
        };

        HotelBookingEntity[] hotelBookingEntities = {
            new HotelBookingEntity(hotelBookings[0][0]),
            new HotelBookingEntity(hotelBookings[0][1]),
            new HotelBookingEntity(hotelBookings[1][0]),
            new HotelBookingEntity(hotelBookings[1][1]),
            new HotelBookingEntity(hotelBookings[2][0]),
            new HotelBookingEntity(hotelBookings[2][1])
        };

        HotelActivity[] hotelActivities = {
                new HotelActivity("AquaGym","L 16:00, X 16:00, V 16:00","Adam",20),
                new HotelActivity("Surf","M 10:00, J 10:00","Lucy",10),
                new HotelActivity("Badminton","S 15:30, D 15:30","Karen",16),
                new HotelActivity("Tennis","L 12:00, X 12:00","Louis",12),
                new HotelActivity("Volleyball","X 17:00, V 17:00","Carlos",20)
        };

        HotelActivityEntity[] hotelActivityEntities = {
            new HotelActivityEntity((hotelActivities[0])),
            new HotelActivityEntity((hotelActivities[1])),
            new HotelActivityEntity((hotelActivities[2])),
            new HotelActivityEntity((hotelActivities[3])),
            new HotelActivityEntity((hotelActivities[4])),
        };

        HotelEntity[] hotelEntities = {
                new HotelEntity(new Hotel("Diamond",5,700,Arrays.asList(hotelBookings[0]),Arrays.asList(hotelActivities))),
                new HotelEntity(new Hotel("Sunlight",4,1000,Arrays.asList(hotelBookings[1]),Arrays.asList(hotelActivities))),
                new HotelEntity(new Hotel("Palm",3,400,Arrays.asList(hotelBookings[2]),Arrays.asList(hotelActivities)))
        };

        this.hotelRepository.saveAll(Arrays.asList(hotelEntities));
        this.hotelActivityRepository.saveAll(Arrays.asList(hotelActivityEntities));
        this.hotelBookingRepository.saveAll(Arrays.asList(hotelBookingEntities));
        this.hotelClientRepository.saveAll(Arrays.asList(hotelClientEntities));
    }

    public void deleteAll() {
        this.hotelRepository.deleteAll();
        this.hotelActivityRepository.deleteAll();
        this.hotelBookingRepository.deleteAll();
        this.hotelClientRepository.deleteAll();
    }
}

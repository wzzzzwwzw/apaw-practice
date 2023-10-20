package es.upm.miw.apaw_practice.adapters.mongodb.hotel.persistance;

import es.upm.miw.apaw_practice.adapters.mongodb.hotel.daos.HotelRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities.HotelActivityEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.hotel.entities.HotelEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.hotel.Hotel;
import es.upm.miw.apaw_practice.domain.persistence_ports.hotel.HotelPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository("hotelPersistence")
public class HotelPersistenceMongodb implements HotelPersistence {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelPersistenceMongodb(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel readByName(String name) {
        return this.hotelRepository
                .findByName(name)
                .orElseThrow(() -> new NotFoundException("Hotel " + name + " not found."))
                .toObject();
    }

    @Override
    public Double MaxParticipantAverageByEmail(String email) {
        Stream<HotelEntity> filteredHotels = this.hotelRepository.findAll()
                .stream().filter(hotel -> hotel.getBookings().stream()
                        .anyMatch(booking -> booking.getClient().getEmail().equals(email)));

        Stream<HotelActivityEntity> activities = filteredHotels.flatMap(hotel -> hotel.getActivities().stream());

        return activities.mapToInt(HotelActivityEntity::getMaxParticipants)
                .average()
                .orElse(0.0);
    }

    @Override
    public List<Integer> distinctRoomNumbersByInstructor(String instructorName) {
        Stream<HotelEntity> filteredHotels = this.hotelRepository.findAll()
                .stream().filter(hotel -> hotel.getActivities().stream()
                        .anyMatch(activity -> activity.getInstructor().equals(instructorName)));

        return filteredHotels.map(HotelEntity::getRooms).distinct().toList();
    }

}

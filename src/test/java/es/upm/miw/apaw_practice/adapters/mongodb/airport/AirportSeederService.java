package es.upm.miw.apaw_practice.adapters.mongodb.airport;

import es.upm.miw.apaw_practice.adapters.mongodb.airport.daos.AircraftRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.daos.AirLineRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.daos.PassengerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.daos.FlightRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.AircraftEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.AirLineEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.FlightEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.PassengerEntity;
import es.upm.miw.apaw_practice.domain.models.airport.Aircraft;
import es.upm.miw.apaw_practice.domain.models.airport.Passenger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
@Service
public class AirportSeederService {
    @Autowired
    private AircraftRepository aircraftRepository;
    @Autowired
    private AirLineRepository airLineRepository;
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private FlightRepository flightRepository;



    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Airport Initial Load -----------");

        AircraftEntity[] aircrafts = {
                new AircraftEntity(new Aircraft(LocalDate.of(2022, 12, 23), 520, "Airbus A320", "320POY")),
                new AircraftEntity(new Aircraft(LocalDate.of(2023, 8, 7), 420, "Boeing 747", "576TRT")),
                new AircraftEntity(new Aircraft(LocalDate.of(2021, 11, 23), 600, "Boeing 737","234POY")),
                new AircraftEntity(new Aircraft(LocalDate.of(2020, 6, 19), 380, "Airbus A340","764QVP")),
                new AircraftEntity(new Aircraft(LocalDate.of(2023, 3, 5), 520, "Airbus A320","875PRT")),
                new AircraftEntity(new Aircraft(LocalDate.of(2022, 7, 25), 605, "Boeing 787","209NGF")),
                new AircraftEntity(new Aircraft(LocalDate.of(2021, 9, 12), 380, "Airbus A340","901LMN"))
        };
        this.aircraftRepository.saveAll(Arrays.asList(aircrafts));

        AirLineEntity[] airLines = {
                new AirLineEntity("Iberia", LocalDate.of(1927, 6, 28),Arrays.asList(aircrafts[0],aircrafts[3],aircrafts[4])),
                new AirLineEntity("Ryanair", LocalDate.of(1984, 11, 28),Arrays.asList(aircrafts[1],aircrafts[2])),
                new AirLineEntity("Air Europa", LocalDate.of(1986, 11, 21),Arrays.asList(aircrafts[6],aircrafts[5]))
        };
        this.airLineRepository.saveAll(Arrays.asList(airLines));

        PassengerEntity[] passengers = {
                new PassengerEntity(new Passenger("Juan Pérez", 24,"678098123")),
                new PassengerEntity(new Passenger("Marina Gómez", 73,"678659023")),
                new PassengerEntity(new Passenger("Alavaro Torres", 47,"638068183")),
                new PassengerEntity(new Passenger("Alba Cuenca", 14,"610123180")),
                new PassengerEntity(new Passenger("Carmen Moreno", 20,"6280942123")),
                new PassengerEntity(new Passenger("Raul Martín", 53,"618649053")),
                new PassengerEntity(new Passenger("Mario Paz", 17,"708068103")),
                new PassengerEntity(new Passenger("Ana Navarro", 33,"690131308")),
        };
        this.passengerRepository.saveAll(Arrays.asList(passengers));


        FlightEntity[] flights = {
                new FlightEntity(12345, LocalDate.of(2023, 6, 28),Arrays.asList(passengers[0],passengers[1],passengers[2]),airLines[0]),
                new FlightEntity(14345, LocalDate.of(2023, 7, 5),Arrays.asList(passengers[0],passengers[1],passengers[2]),airLines[0]),
                new FlightEntity(54321, LocalDate.of(2022, 11, 28),Arrays.asList(passengers[3],passengers[4]),airLines[1]),
                new FlightEntity(34524, LocalDate.of(2023, 11, 21),Arrays.asList(passengers[5],passengers[7],passengers[6]),airLines[2])
        };
        this.flightRepository.saveAll(Arrays.asList(flights));

    }


    public void deleteAll() {
        this.aircraftRepository.deleteAll();
        this.airLineRepository.deleteAll();
        this.passengerRepository.deleteAll();
        this.flightRepository.deleteAll();
    }
}

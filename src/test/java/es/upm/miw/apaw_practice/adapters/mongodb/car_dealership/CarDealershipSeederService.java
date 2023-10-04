package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership;

import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.daos.CarRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.daos.DealershipRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.daos.SellerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities.CarEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities.CarModelEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities.DealershipEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities.SellerEntity;
import net.bytebuddy.asm.Advice;
import org.apache.logging.log4j.LogManager;
import org.bson.codecs.jsr310.LocalDateCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class CarDealershipSeederService {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private DealershipRepository dealershipRepository;
    @Autowired
    private SellerRepository sellerRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("---------- Car Dealership data initial load ----------");
        SellerEntity[] sellers = {
                new SellerEntity("Asier", "Gonzalez", 30000),
                new SellerEntity("Javier", "Fernandez", 45000),
                new SellerEntity("Mikel", "Bosque", 25000)
        };
        this.sellerRepository.saveAll(Arrays.asList(sellers));
        CarModelEntity[] carModels = {
                new CarModelEntity("Camry", "Toyota", LocalDate.of(2018, 6, 25)),
                new CarModelEntity("C5", "Citroën", LocalDate.of(2015, 4, 12)),
                new CarModelEntity("Yaris", "Toyota", LocalDate.of(2019, 10, 18))
        };
        CarEntity[] cars = {
                new CarEntity("HV30-0169266692781", BigDecimal.valueOf(44000), true, LocalDate.now().minusMonths(15), carModels[0], List.of(sellers[0], sellers[1])),
                new CarEntity("SV30-BTPNKKJUBGDFN", BigDecimal.valueOf(56399.99), false, LocalDate.now().minusMonths(11), carModels[0], List.of(sellers[1])),
                new CarEntity("CP12-1237896142875", BigDecimal.valueOf(19049.99), true, LocalDate.now().minusMonths(9), carModels[2], List.of(sellers[0], sellers[2])),
                new CarEntity("SP12-8147661452835", BigDecimal.valueOf(25350), false, LocalDate.now().minusMonths(7), carModels[2], List.of(sellers[0], sellers[2])),
                new CarEntity("CH20-6842176814178", BigDecimal.valueOf(12999), false, LocalDate.now().minusYears(7), carModels[1], List.of(sellers[2]))
        };
        this.carRepository.saveAll(Arrays.asList(cars));
        DealershipEntity[] dealerships = {
                new DealershipEntity("Miña Car", "Malaga", "Malaga", List.of(cars[2], cars[3], cars[4])),
                new DealershipEntity("Premium Car", "Alcala de Henares", "Madrid", List.of(cars[0], cars[1]))
        };
        this.dealershipRepository.saveAll(Arrays.asList(dealerships));
    }

    public void deleteAll() {
        this.dealershipRepository.deleteAll();
        this.carRepository.deleteAll();
        this.sellerRepository.deleteAll();
    }
}

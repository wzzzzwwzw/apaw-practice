package es.upm.miw.apaw_practice.domain.models.car_dealership;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void testCarBuilder() {
        Car car = new Car.CarBuilder()
                .chassisNumber("test")
                .price(new BigDecimal(23000))
                .sold(true)
                .fabricationDate(LocalDate.now())
                .seller()
                    .name("sellerName1")
                    .build()
                .seller()
                    .surname("sellerSurname2")
                    .salary(23000)
                    .build()
                .carModel()
                    .name("testNameModel")
                    .brand("testBrand")
                    .createDate(LocalDate.now())
                    .build()
                .build();

        assertEquals("test", car.getChassisNumber());
        assertTrue(car.getSold());
        assertEquals(LocalDate.now(), car.getFabricationDate());

        Optional<Seller> seller = car.getSellerList().stream()
                .filter(seller1 -> "sellerName1".equals(seller1.getName()))
                .findFirst();
        assertTrue(seller.isPresent());
        assertEquals("sellerName1", seller.get().getName());

        seller = car.getSellerList().stream()
                .filter(seller1 -> "sellerSurname2".equals(seller1.getSurname()))
                .findFirst();
        assertTrue(seller.isPresent());
        assertEquals("sellerSurname2", seller.get().getSurname());
        assertEquals(23000, seller.get().getSalary());

        assertEquals("testNameModel", car.getCarModel().getName());
        assertEquals("testBrand", car.getCarModel().getBrand());
        assertEquals(LocalDate.now(), car.getCarModel().getCreateDate());
    }
}

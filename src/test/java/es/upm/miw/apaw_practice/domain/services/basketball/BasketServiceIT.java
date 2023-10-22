package es.upm.miw.apaw_practice.domain.services.basketball;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.basketball.Basket;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.mongodb.internal.connection.tlschannel.util.Util.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class BasketServiceIT {
    @Autowired
    private BasketService basketService;
    @Test
    void testUpdateService() {
        Basket basket = this.basketService.updateBasket("canasta1",7);
        assertEquals(7, basket.getValue());
    }

    @Test
    void testFindIdentifiersByPavilionDirection() {
        List<String> identifiers = this.basketService.findIdentifiersByPavilionDirection("direction1");
        assertTrue(identifiers.contains("canasta1"));
        assertEquals(2, identifiers.size());
    }
}

package es.upm.miw.apaw_practice.domain.services.food_delivery;

import es.upm.miw.apaw_practice.domain.models.food_delivery.Order;
import es.upm.miw.apaw_practice.domain.persistence_ports.food_delivery.OrderPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderPersistence orderPersistence;

    @Autowired
    public OrderService(OrderPersistence orderPersistence) {
        this.orderPersistence = orderPersistence;
    }

    public Order read(Integer number) {
        return this.orderPersistence.read(number);
    }

}

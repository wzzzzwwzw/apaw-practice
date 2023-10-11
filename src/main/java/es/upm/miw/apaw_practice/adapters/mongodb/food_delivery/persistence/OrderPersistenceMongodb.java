package es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.daos.OrderRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.food_delivery.entities.OrderEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.food_delivery.Order;
import es.upm.miw.apaw_practice.domain.persistence_ports.food_delivery.OrderPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("orderPersistence")
public class OrderPersistenceMongodb implements OrderPersistence {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderPersistenceMongodb(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public Order read(Integer number) {
        return this.orderRepository.findByNumber(number)
                .orElseThrow(() -> new NotFoundException("Order number: " + number))
                .toOrder();
    }

    @Override
    public Order update(Integer number, Order order) {
        OrderEntity orderEntity = this.orderRepository
                .findByNumber(number)
                .orElseThrow(() -> new NotFoundException("Order number: " + number));
        orderEntity.fromOrder(order);
        return this.orderRepository
                .save(orderEntity)
                .toOrder();
    }

}

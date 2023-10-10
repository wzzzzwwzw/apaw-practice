package es.upm.miw.apaw_practice.adapters.rest.food_delivery;


import es.upm.miw.apaw_practice.domain.models.food_delivery.Order;
import es.upm.miw.apaw_practice.domain.models.food_delivery.OrderPriceUpdating;
import es.upm.miw.apaw_practice.domain.services.food_delivery.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(OrderResource.ORDERS)
public class OrderResource {


    static final String ORDERS = "/food_delivery/orders";
    static final String NUMBER_ID = "/{number}";
    private final OrderService orderService;

    @Autowired
    public OrderResource(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping(NUMBER_ID)
    public Order read(@PathVariable Integer number){
        return this.orderService.read(number);
    }

    @PatchMapping
    public void updatePrices(@RequestBody List<OrderPriceUpdating> orderPriceUpdatingList){
        this.orderService.updatePrices(orderPriceUpdatingList.stream());
    }

}

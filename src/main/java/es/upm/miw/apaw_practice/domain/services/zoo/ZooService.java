package es.upm.miw.apaw_practice.domain.services.zoo;

import es.upm.miw.apaw_practice.domain.models.shop.Article;
import es.upm.miw.apaw_practice.domain.models.zoo.Zoo;
import es.upm.miw.apaw_practice.domain.models.zoo.ZooPriceUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.zoo.ZooPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ZooService {

    private final ZooPersistence zooPersistence;


    @Autowired
    public ZooService(ZooPersistence zooPersistence) {
        this.zooPersistence = zooPersistence;
    }

    public void delete(String name) {
        this.zooPersistence.delete(name);
    }

    public void updatePrices(Stream<ZooPriceUpdating> zooPriceUpdatingList) {
        zooPriceUpdatingList.map(zooNewPrice -> {
                    Zoo zoo = this.zooPersistence.read(zooNewPrice.getName());
                    zoo.setTicketPrice(zooNewPrice.getTicketPrice());
                    return zoo;
                })
                .forEach(zoo -> this.zooPersistence.update(zoo.getName(), zoo));
    }
}
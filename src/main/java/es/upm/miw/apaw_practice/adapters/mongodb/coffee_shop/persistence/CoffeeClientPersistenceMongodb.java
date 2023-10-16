package es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.daos.CoffeeClientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.entities.CoffeeClientEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.entities.CoffeeEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.coffee_shop.entities.TransactionEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.coffee_shop.CoffeeClient;
import es.upm.miw.apaw_practice.domain.persistence_ports.coffee_shop.CoffeeClientPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Repository("coffeeClientPersistence")
public class CoffeeClientPersistenceMongodb implements CoffeeClientPersistence {
    private final CoffeeClientRepository coffeeClientRepository;

    @Autowired
    public CoffeeClientPersistenceMongodb(CoffeeClientRepository coffeeClientRepository) {
        this.coffeeClientRepository = coffeeClientRepository;
    }
    @Override
    public void delete(String name) {
        this.coffeeClientRepository.deleteByName(name);
    }

    @Override
    public CoffeeClient updateAddressByName(String name) {
        CoffeeClientEntity coffeeClient = this.coffeeClientRepository
                .findByName(name)
                .orElseThrow(() -> new NotFoundException("Client name: " + name));
        coffeeClient.setAddress("new address");
        return this.coffeeClientRepository.save(coffeeClient).toClient();
    }

    @Override
    public BigDecimal getTotalPriceByCategory(String category) {
        List<CoffeeClientEntity> clients = this.coffeeClientRepository.findAll();
        BigDecimal totalPrice = BigDecimal.ZERO;

        for (CoffeeClientEntity client : clients) {
            List<CoffeeEntity> coffeesInCategory = client.getCoffeesEntities().stream()
                    .filter(coffee -> coffee.getCategory().equalsIgnoreCase(category))
                    .toList();

            if (!coffeesInCategory.isEmpty()) {
                totalPrice = totalPrice.add(
                        client.getTransactionsEntities().stream()
                                .map(TransactionEntity::getTotalPrice)
                                .reduce(BigDecimal.ZERO, BigDecimal::add)
                );
            }
        }

        return totalPrice;
    }
}

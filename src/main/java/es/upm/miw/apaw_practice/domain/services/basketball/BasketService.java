package es.upm.miw.apaw_practice.domain.services.basketball;

import es.upm.miw.apaw_practice.domain.models.basketball.Basket;
import es.upm.miw.apaw_practice.domain.models.basketball.Player;
import es.upm.miw.apaw_practice.domain.persistence_ports.basketball.BasketPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.basketball.TeamPersistence;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {
    private final BasketPersistence basketPersistence;
    private final TeamPersistence teamPersistence;

    public BasketService(BasketPersistence basketPersistence, TeamPersistence teamPersistence) {
        this.basketPersistence = basketPersistence;
        this.teamPersistence = teamPersistence;
    }

    public Basket read(String id) {
        return this.basketPersistence.read(id);
    }

    public Basket updateBasket(String id, Integer value) {
        Basket basket = this.basketPersistence.read(id);
        basket.setValue(value);
        return this.basketPersistence.update(basket);
    }

    public List<String> findIdentifiersByPavilionDirection(String direction) {

        List<Player> teamPlayers = this.teamPersistence.findAll()
                .stream()
                .filter(team -> team.getPavilions().stream().anyMatch(pavilion -> pavilion.getDirection().equals(direction)))
                .flatMap(team -> team.getPlayers().stream())
                .distinct()
                .toList();

        return this.basketPersistence.findAll()
                .stream()
                .filter(basket -> teamPlayers.stream()
                        .anyMatch(teamPlayer -> teamPlayer.getEmail().equals(basket.getPlayer().getEmail())))
                .map(Basket::getIdentifier)
                .toList();
    }

}
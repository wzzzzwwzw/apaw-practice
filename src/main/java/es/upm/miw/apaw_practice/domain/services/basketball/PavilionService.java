package es.upm.miw.apaw_practice.domain.services.basketball;

import es.upm.miw.apaw_practice.domain.models.basketball.Basket;
import es.upm.miw.apaw_practice.domain.models.basketball.Pavilion;
import es.upm.miw.apaw_practice.domain.models.basketball.Player;
import es.upm.miw.apaw_practice.domain.persistence_ports.basketball.BasketPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.basketball.PavilionPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.basketball.TeamPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PavilionService {
    private final PavilionPersistence pavilionPersistence;
    private final TeamPersistence teamPersistence;
    private final BasketPersistence basketPersistence;
    @Autowired
    public PavilionService(PavilionPersistence pavilionPersistence, TeamPersistence teamPersistence, BasketPersistence basketPersistence) {
        this.pavilionPersistence = pavilionPersistence;
        this.teamPersistence = teamPersistence;
        this.basketPersistence = basketPersistence;
    }
    public Pavilion create(Pavilion pavilion) {
        return this.pavilionPersistence.create(pavilion);
    }

    public BigDecimal findAvgOfTotalCapacityByBasketValue(Integer value) {
        List<Player> basketPlayers = this.basketPersistence.findAll()
                .stream()
                .filter(basket -> Objects.equals(basket.getValue(), value))
                .map(Basket::getPlayer)
                .distinct()
                .toList();

        List<Pavilion> pavilionsToAvg = this.teamPersistence.findAll()
                .stream()
                .filter(team -> team.getPlayers().stream().anyMatch(player -> basketPlayers.stream()
                        .anyMatch(basketPlayer -> basketPlayer.getEmail().equals(player.getEmail()))))
                .flatMap(team -> team.getPavilions().stream())
                .distinct()
                .toList();

        Optional<BigDecimal> totalCapacity = pavilionsToAvg.stream()
                .map(pavilion -> new BigDecimal(pavilion.getCapacity()))
                .reduce(BigDecimal::add);

        return totalCapacity.map(sum -> sum.divide(BigDecimal.valueOf(pavilionsToAvg.size()), 0, BigDecimal.ROUND_DOWN))
                .orElse(BigDecimal.ZERO);
    }
}
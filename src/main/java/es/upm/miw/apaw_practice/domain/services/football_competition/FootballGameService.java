package es.upm.miw.apaw_practice.domain.services.football_competition;

import es.upm.miw.apaw_practice.domain.models.football_competition.FootballGame;
import es.upm.miw.apaw_practice.domain.models.football_competition.FootballGameDateUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.football_competition.FootballGamePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FootballGameService {
    private final FootballGamePersistence footballGamePersistence;

    @Autowired
    public FootballGameService(FootballGamePersistence footballGamePersistence) {
        this.footballGamePersistence = footballGamePersistence;
    }

    public List<FootballGame> updateDates(List<FootballGameDateUpdating> footballGameDateUpdatingList) {
        return footballGameDateUpdatingList.stream()
                .map(gameUpdate -> this.footballGamePersistence.updateDate(gameUpdate.getId(), gameUpdate.getDate()))
                .toList();
    }

    public BigDecimal findTotalBudgetByLocation(String location) {
        return this.footballGamePersistence.getTotalBudgetByLocation(location);
    }
}

package es.upm.miw.apaw_practice.domain.services.climbing;

import es.upm.miw.apaw_practice.domain.models.climbing.Area;
import es.upm.miw.apaw_practice.domain.models.climbing.Expedition;
import es.upm.miw.apaw_practice.domain.persistence_ports.climbing.AreaPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.climbing.ExpeditionPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ExpeditionService {

    private final ExpeditionPersistence expeditionPersistence;
    private final AreaPersistence areaPersistence;

    @Autowired
    public ExpeditionService(ExpeditionPersistence expeditionPersistence, AreaPersistence areaPersistence) {
        this.expeditionPersistence = expeditionPersistence;
        this.areaPersistence = areaPersistence;
    }

    public Expedition create(Expedition expedition) {
        return this.expeditionPersistence.create(expedition);
    }

    public Expedition updateTotalExpense(String identifier, BigDecimal totalExpense) {
        Expedition expedition = this.expeditionPersistence.readByIdentifier(identifier);
        expedition.setTotalExpense(totalExpense);
        return this.expeditionPersistence.update(expedition);
    }

    public BigDecimal findSumOfTotalExpenseByRouteDifficulty(String difficulty) {
        return this.areaPersistence.findAll()
                .stream()
                .filter(area -> area.getRoutes().stream()
                        .anyMatch(route -> difficulty.equals(route.getDifficulty())))
                .map(Area::getExpedition)
                .map(Expedition::getTotalExpense)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

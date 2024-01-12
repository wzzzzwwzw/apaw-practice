package es.upm.miw.apaw_practice.domain.services.padel_academy;

import es.upm.miw.apaw_practice.domain.models.padel_academy.Tournament;
import es.upm.miw.apaw_practice.domain.persistence_ports.padel_academy.TournamentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TournamentService {
    private TournamentPersistence tournamentPersistence;

    @Autowired
    public TournamentService(TournamentPersistence tournamentPersistence) {
        this.tournamentPersistence = tournamentPersistence;
    }

    public Tournament create(Tournament tournament) {
        return this.tournamentPersistence.create(tournament);
    }

    public BigDecimal findSumOfPrizeByInstructorDni(String dni) {
        return this.tournamentPersistence.readAll()
                .filter(tournament -> tournament.getAcademy().getInstructors()
                        .stream().anyMatch(instructor -> instructor.getDni().equals(dni)))
                .map(Tournament::getPrize)
                .reduce((totalPrice, actualPrice) -> totalPrice.add(actualPrice))
                .orElse(BigDecimal.ZERO);
    }
}

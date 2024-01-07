package es.upm.miw.apaw_practice.domain.persistence_ports.padel_academy;

import es.upm.miw.apaw_practice.domain.models.padel_academy.Tournament;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentPersistence {
    Tournament create(Tournament tournament);
}

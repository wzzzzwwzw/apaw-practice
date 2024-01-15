package es.upm.miw.apaw_practice.adapters.mongodb.basketball.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos.PlayerRepository;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.basketball.Player;
import es.upm.miw.apaw_practice.domain.persistence_ports.basketball.PlayerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("playerPersistence")
public class PlayerPersistenceMongodb implements PlayerPersistence {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerPersistenceMongodb(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player readByEmail(String email) {
        return this.playerRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Player email: " + email))
                .toPlayer();
    }

    @Override
    public void delete(String email) {
        this.playerRepository.deleteByEmail(email);
    }

}

package es.upm.miw.apaw_practice.domain.services.basketball;

import es.upm.miw.apaw_practice.domain.models.basketball.Player;
import es.upm.miw.apaw_practice.domain.models.basketball.Team;
import es.upm.miw.apaw_practice.domain.persistence_ports.basketball.TeamPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamBasketballService {

    private final TeamPersistence teamBasketballPersistence;
    @Autowired
    public TeamBasketballService(TeamPersistence teamPersistence){
        this.teamBasketballPersistence=teamPersistence;
    }

    public Team updatePlayer(String alias, String playerEmail, Player player) {
        Team team = this.teamBasketballPersistence.readByAlias(alias);
        List<Player> players = new ArrayList<>(team.getPlayers());
        int index = 0;
        Boolean condition = false;

        while(!condition && index < players.size()) {
            if (players.get(index).getEmail().equals(playerEmail)){
                players.set(index, player);
                condition = true;
            }
            index++;
        }

        team.setPlayers(players);

        return this.teamBasketballPersistence.update(team);
    }

    public Team read(String alias){
        return this.teamBasketballPersistence.readByAlias(alias);
    }

}

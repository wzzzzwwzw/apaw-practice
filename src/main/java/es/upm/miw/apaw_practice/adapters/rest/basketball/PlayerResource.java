package es.upm.miw.apaw_practice.adapters.rest.basketball;

import es.upm.miw.apaw_practice.domain.services.basketball.PlayerService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PlayerResource.PLAYER)
public class PlayerResource {
    static final String PLAYER = "/basketball/player";
    static final String EMAIL_ID = "/{email}";
    private final PlayerService playerService;

    public PlayerResource(PlayerService playerService) {
        this.playerService = playerService;
    }

    @DeleteMapping(EMAIL_ID)
    public void delete(@PathVariable String email) {
        this.playerService.delete(email);
    }
}

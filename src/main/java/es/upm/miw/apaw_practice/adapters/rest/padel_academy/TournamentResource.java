package es.upm.miw.apaw_practice.adapters.rest.padel_academy;

import es.upm.miw.apaw_practice.domain.models.padel_academy.Tournament;
import es.upm.miw.apaw_practice.domain.services.padel_academy.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TournamentResource.TOURNAMENTS)
public class TournamentResource {
    static final String TOURNAMENTS = "/padel-academy/tournaments";
    private final  TournamentService tournamentService;

    @Autowired
    public TournamentResource(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @PostMapping
    public Tournament create(@RequestBody Tournament tournament) {
        return this.tournamentService.create(tournament);
    }
}

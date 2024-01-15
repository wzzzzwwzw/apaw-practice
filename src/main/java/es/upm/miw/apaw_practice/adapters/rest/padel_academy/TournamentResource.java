package es.upm.miw.apaw_practice.adapters.rest.padel_academy;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.padel_academy.Tournament;
import es.upm.miw.apaw_practice.domain.services.padel_academy.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(TournamentResource.TOURNAMENTS)
public class TournamentResource {
    static final String TOURNAMENTS = "/padel-academy/tournaments";
    static final String SEARCH = "/search";
    private final  TournamentService tournamentService;

    @Autowired
    public TournamentResource(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @PostMapping
    public Tournament create(@RequestBody Tournament tournament) {
        return this.tournamentService.create(tournament);
    }

    @GetMapping(SEARCH)
    public BigDecimal findSumOfPrizeByInstructorDni(@RequestParam String q) {
        String dni = new LexicalAnalyzer().extractWithAssure(q, "dni", String::new);
        return this.tournamentService.findSumOfPrizeByInstructorDni(dni);
    }
}

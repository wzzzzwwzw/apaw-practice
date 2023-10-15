package es.upm.miw.apaw_practice.adapters.rest.videogame_company;

import es.upm.miw.apaw_practice.domain.models.videogame_company.VideogameCompany;
import es.upm.miw.apaw_practice.domain.services.computer_store.WireService;
import es.upm.miw.apaw_practice.domain.services.videogame_company.VideogameCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(VideogameCompanyResource.VIDEOGAME_COMPANIES)
public class VideogameCompanyResource {
    static final String VIDEOGAME_COMPANIES = "/videogame-company/companies";
    private final VideogameCompanyService videogameCompanyService;

    @Autowired
    public VideogameCompanyResource(VideogameCompanyService videogameCompanyService) {
        this.videogameCompanyService = videogameCompanyService;
    }
    @PostMapping
    public VideogameCompany create(@RequestBody VideogameCompany videogameCompany){
        return this.videogameCompanyService.create(videogameCompany);
    }
}

package es.upm.miw.apaw_practice.adapters.rest.videogame_company;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.daos.VideogameRepository;
import es.upm.miw.apaw_practice.domain.services.videogame_company.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(VideogameResource.VIDEOGAMES)
public class VideogameResource {
    static final String VIDEOGAMES = "/videogame-company/videogames";
    static final String NAME_ID = "/{name}";

    @Autowired
    private  final VideogameService videogameService;

    public VideogameResource(VideogameService videogameService){
        this.videogameService = videogameService;
    }

    @DeleteMapping(NAME_ID)
    public void delete(@PathVariable String name){
        this.videogameService.delete(name);
    }

}

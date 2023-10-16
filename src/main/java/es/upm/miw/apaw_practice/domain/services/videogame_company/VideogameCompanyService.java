package es.upm.miw.apaw_practice.domain.services.videogame_company;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.videogame_company.VideogameCompany;
import es.upm.miw.apaw_practice.domain.persistence_ports.videogame_company.VideogameCompanyPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideogameCompanyService {
    private final VideogameCompanyPersistence videogameCompanyPersistence;

    @Autowired
    public VideogameCompanyService(VideogameCompanyPersistence videogameCompanyPersistence){
        this.videogameCompanyPersistence = videogameCompanyPersistence;
    }

    public VideogameCompany create(VideogameCompany videogameCompany){
        this.assertVideogameCompanyExist(videogameCompany.getName());
        return this.videogameCompanyPersistence.create(videogameCompany);
    }

    public void assertVideogameCompanyExist(String name){
            if(this.videogameCompanyPersistence.existVideogameCompanyName(name)){
                throw new ConflictException("Videogame Company name already exist: " + name);
            }
    }


}


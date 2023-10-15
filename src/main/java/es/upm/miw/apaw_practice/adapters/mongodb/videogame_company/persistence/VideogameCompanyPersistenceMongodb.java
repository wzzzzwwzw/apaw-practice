package es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.daos.VideogameCompanyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.entities.VideogameCompanyEntity;
import es.upm.miw.apaw_practice.domain.models.videogame_company.VideogameCompany;
import es.upm.miw.apaw_practice.domain.persistence_ports.videogame_company.VideogameCompanyPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("videogameCompanyPersistence")
public class VideogameCompanyPersistenceMongodb implements VideogameCompanyPersistence {
    private final VideogameCompanyRepository videogameCompanyRepository;

    @Autowired
    public VideogameCompanyPersistenceMongodb(VideogameCompanyRepository videogameCompanyRepository){
        this.videogameCompanyRepository = videogameCompanyRepository;
    }

    @Override
    public boolean existVideogameCompanyName(String name){
        return this.videogameCompanyRepository
                .findByName(name)
                .isPresent();
    }

    @Override
    public VideogameCompany create(VideogameCompany videogameCompany){
        return this.videogameCompanyRepository
                .save(new VideogameCompanyEntity(videogameCompany))
                .toVideogameCompany();
    }

}

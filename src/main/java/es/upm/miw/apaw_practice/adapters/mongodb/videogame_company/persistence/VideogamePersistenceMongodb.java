package es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.daos.VideogameRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.videogame_company.VideogamePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("videogamePersistence")
public class VideogamePersistenceMongodb implements VideogamePersistence {
    private final VideogameRepository videogameRepository;

    @Autowired
    public VideogamePersistenceMongodb(VideogameRepository videogameRepository){
        this.videogameRepository = videogameRepository;
    }

    @Override
    public void delete(String name){
        this.videogameRepository.deleteByName(name);
    }
}

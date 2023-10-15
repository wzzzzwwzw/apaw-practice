package es.upm.miw.apaw_practice.domain.services.videogame_company;

import es.upm.miw.apaw_practice.domain.persistence_ports.videogame_company.VideogamePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideogameService {
    private final VideogamePersistence videogamePersistence;

    @Autowired
    public VideogameService(VideogamePersistence videogamePersistence){
        this.videogamePersistence = videogamePersistence;
    }

    public void delete(String name){
        this.videogamePersistence.delete(name);
    }
}

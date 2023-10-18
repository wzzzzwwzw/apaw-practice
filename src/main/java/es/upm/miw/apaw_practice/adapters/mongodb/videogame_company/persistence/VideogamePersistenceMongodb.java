package es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.daos.VideogameRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame_company.entities.VideogameEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.videogame_company.Videogame;
import es.upm.miw.apaw_practice.domain.persistence_ports.videogame_company.VideogamePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.stream.Stream;

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

    @Override
    public Videogame updateReleaseDateByName(String name){
        VideogameEntity videogame = this.videogameRepository
                .findByName(name)
                .orElseThrow(() -> new NotFoundException("Videogame Name: " + name));
        videogame.setReleaseDate(LocalDate.now());
        return this.videogameRepository.save(videogame).toVideogame();
    }

    @Override
    public Stream<Videogame> readAll(){
        return this.videogameRepository.findAll()
                .stream()
                .map(VideogameEntity::toVideogame);
    }

}

package es.upm.miw.apaw_practice.adapters.mongodb.film.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.film.daos.DirectorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.film.entities.DirectorEntity;
import es.upm.miw.apaw_practice.domain.models.film.Director;
import es.upm.miw.apaw_practice.domain.persistence_ports.film.DirectorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("directorRepository")
public class DirectorPersistenceMongodb implements DirectorPersistence {

    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorPersistenceMongodb(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public Director create(Director director) {
        return this.directorRepository
                .save(new DirectorEntity(director))
                .toDirector();
    }

    @Override
    public boolean existsDirectorDni(String dni) {
        return this.directorRepository
                .findByDni(dni)
                .isPresent();
    }
}

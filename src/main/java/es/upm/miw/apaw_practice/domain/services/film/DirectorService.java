package es.upm.miw.apaw_practice.domain.services.film;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.film.Director;
import es.upm.miw.apaw_practice.domain.persistence_ports.film.DirectorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {

    private final DirectorPersistence directorPersistence;

    @Autowired
    public DirectorService(DirectorPersistence directorPersistence) {
        this.directorPersistence = directorPersistence;
    }

    public Director create(Director director) {
        this.assertDirectorDniNotExists(director.getDni());
        return this.directorPersistence.create(director);
    }

    public void assertDirectorDniNotExists(String dni) {
        if (this.directorPersistence.existsDirectorDni(dni))
            throw new ConflictException("Director dni already exists: " + dni);
    }

    public Director updateSurname(String dni, String surname) {
        return this.directorPersistence.updateSurname(dni, surname);
    }
}

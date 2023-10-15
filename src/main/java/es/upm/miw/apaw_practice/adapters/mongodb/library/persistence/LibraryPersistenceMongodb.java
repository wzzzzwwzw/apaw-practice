package es.upm.miw.apaw_practice.adapters.mongodb.library.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.library.daos.LibraryRepository;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.library.Library;
import es.upm.miw.apaw_practice.domain.persistence_ports.library.LibraryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("libraryPersistence")
public class LibraryPersistenceMongodb implements LibraryPersistence {
    private final LibraryRepository libraryRepository;
    @Autowired
    public LibraryPersistenceMongodb(LibraryRepository libraryRepository){
        this.libraryRepository = libraryRepository;
    }
    @Override
    public Library read(String name) {
        return this.libraryRepository
                .findByName(name)
                .orElseThrow(()-> new NotFoundException("Library name not found: "+name))
                .toLibrary();
    }
}

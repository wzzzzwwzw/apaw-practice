package es.upm.miw.apaw_practice.domain.services.library;

import es.upm.miw.apaw_practice.domain.models.library.Library;
import es.upm.miw.apaw_practice.domain.persistence_ports.library.LibraryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LibraryService {
    private final LibraryPersistence libraryPersistence;
    @Autowired
    public LibraryService(LibraryPersistence libraryPersistence) {
        this.libraryPersistence = libraryPersistence;
    }

    public Library read(String name){
        return this.libraryPersistence.read(name);
    }

    public BigDecimal findAverageOfNumberOfBookByLibraryName(String name){ return this.libraryPersistence.findAverageOfNumberOfBookByLibraryName(name); }
}

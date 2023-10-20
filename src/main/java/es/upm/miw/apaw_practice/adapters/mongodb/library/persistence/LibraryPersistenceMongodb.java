package es.upm.miw.apaw_practice.adapters.mongodb.library.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.library.daos.LibraryRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.BookWriterEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.library.Library;
import es.upm.miw.apaw_practice.domain.persistence_ports.library.LibraryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Repository("libraryPersistence")
public class LibraryPersistenceMongodb implements LibraryPersistence {
    private final LibraryRepository libraryRepository;

    @Autowired
    public LibraryPersistenceMongodb(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @Override
    public Library read(String name) {
        return this.libraryRepository
                .findByName(name)
                .orElseThrow(() -> new NotFoundException("Library name not found: " + name))
                .toLibrary();
    }

    @Override
    public BigDecimal findAverageOfNumberOfBookByLibraryName(String name) {

        List<BookWriterEntity> bookWriterEntityList = this.libraryRepository
                .findByName(name)
                .orElseThrow(() -> new NotFoundException("Library with name: " + name))
                .getBookEntities().stream()
                .flatMap(bookEntity -> bookEntity.getBookWriterEntities().stream())
                .distinct()
                .toList();
        BigDecimal totalBook = BigDecimal.valueOf(bookWriterEntityList.stream()
                .mapToDouble(BookWriterEntity::getNumberOfBook)
                .sum());

        return totalBook.divide(BigDecimal.valueOf(bookWriterEntityList.size()), 2, RoundingMode.HALF_UP);
    }
}


package es.upm.miw.apaw_practice.adapters.mongodb.library.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.library.daos.LibraryRepository;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.LibraryEntity;
import es.upm.miw.apaw_practice.domain.models.library.Book;
import es.upm.miw.apaw_practice.domain.models.library.Library;
import es.upm.miw.apaw_practice.domain.persistence_ports.library.LibraryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public List<Book> findBookByLibraryName(String name) {
        return this.libraryRepository
                .findByName(name)
                .orElseThrow(() -> new NotFoundException("Library with name: " + name))
                .toLibrary().getBooks();
    }

    @Override
    public List<String> findAddressByBook(List<Book> listOfBook){
        List<String> isbnList = listOfBook.stream()
                .map(Book::getIsbn)
                .toList();

        return this.libraryRepository.findAll()
                .stream()
                .map(LibraryEntity::toLibrary)
                .filter(library -> library.getBooks().stream()
                        .anyMatch(book -> isbnList.contains(book.getIsbn())))
                .map(Library::getAddress)
                .toList();
    }
}
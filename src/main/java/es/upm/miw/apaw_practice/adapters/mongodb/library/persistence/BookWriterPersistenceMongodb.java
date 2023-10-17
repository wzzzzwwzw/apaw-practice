package es.upm.miw.apaw_practice.adapters.mongodb.library.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.library.daos.BookWriterRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.BookWriterEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.library.BookWriter;
import es.upm.miw.apaw_practice.domain.persistence_ports.library.BookWriterPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("bookWriterPersistence")
public class BookWriterPersistenceMongodb implements BookWriterPersistence {
    private final BookWriterRepository bookWriterRepository;
    @Autowired
    public BookWriterPersistenceMongodb(BookWriterRepository bookWriterRepository){
        this.bookWriterRepository = bookWriterRepository;
    }

    @Override
    public BookWriter readByNickname(String nickname){
        return this.bookWriterRepository
                .findByNickname(nickname)
                .orElseThrow(() -> new NotFoundException("BookWriter nickname: " + nickname))
                .toBookWriter();
    }

    @Override
    public boolean existsNickname(String nickname){
        return this.bookWriterRepository
                .findByNickname(nickname)
                .isPresent();
    }

    @Override
    public BookWriter create(BookWriter bookWriter) {
        return this.bookWriterRepository
                .save(new BookWriterEntity(bookWriter))
                .toBookWriter();
    }

    @Override
    public BookWriter updateNumberOfBook(BookWriter bookWriter){
        BookWriterEntity bookWriterEntity = this.bookWriterRepository
                .findByNickname(bookWriter.getNickname())
                .orElseThrow(() -> new NotFoundException("BookWriter nickname: " + bookWriter.getNumberOfBook()));
        bookWriterEntity.setNumberOfBook(bookWriter.getNumberOfBook());
        return this.bookWriterRepository.save(bookWriterEntity).toBookWriter();
    }

}

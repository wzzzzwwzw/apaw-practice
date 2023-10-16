package es.upm.miw.apaw_practice.domain.services.library;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.library.BookWriter;
import es.upm.miw.apaw_practice.domain.persistence_ports.library.BookWriterPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookWriterService {
    private final BookWriterPersistence bookWriterPersistence;
    @Autowired
    public BookWriterService(BookWriterPersistence bookWriterPersistence){
        this.bookWriterPersistence = bookWriterPersistence;
    }

    public BookWriter create(BookWriter bookWriter){
        this.assertNicknameNotExist(bookWriter.getNickname());
        return this.bookWriterPersistence.create(bookWriter);
    }

    public void assertNicknameNotExist(String nickname){
        if(this.bookWriterPersistence.existsNickname(nickname)){
            throw new ConflictException("Nickname exist: "+nickname);
        }
    }
}

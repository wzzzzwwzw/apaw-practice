package es.upm.miw.apaw_practice.adapters.rest.library;

import es.upm.miw.apaw_practice.domain.models.library.BookWriter;
import es.upm.miw.apaw_practice.domain.services.library.BookWriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BookWriterResource.BOOKWRITER)
public class BookWriterResource {
    static final String BOOKWRITER = "/library/bookWriters";
    private final BookWriterService bookWriterService;
    @Autowired
    public BookWriterResource(BookWriterService bookWriterService){
        this.bookWriterService = bookWriterService;
    }

    @PostMapping
    public BookWriter create(@RequestBody BookWriter bookWriter){
        return this.bookWriterService.create(bookWriter);
    }
}

package es.upm.miw.apaw_practice.adapters.rest.conference;

import es.upm.miw.apaw_practice.domain.models.conference.Author;
import es.upm.miw.apaw_practice.domain.services.conference.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AuthorResource.AUTHORS)
public class AuthorResource {
    static final String AUTHORS = "/conference/authors";

    private final AuthorService authorService;

    @Autowired
    public AuthorResource(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public Author create(@RequestBody Author author) {
        return this.authorService.create(author);
    }
}

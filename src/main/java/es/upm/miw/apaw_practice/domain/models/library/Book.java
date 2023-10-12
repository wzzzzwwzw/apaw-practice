package es.upm.miw.apaw_practice.domain.models.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String isbn;
    private LocalDate publicationDate;
    private List<Author> authors;

    public Book(){
        authors = new ArrayList<>();
    }

    public Book(String title, String isbn, LocalDate publicationDate, List<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.authors = authors;
    }

    public String getTitle() { return title;}
    public void setTitle(String title) { this.title = title;}
    public String getIsbn(){ return isbn;}
    public void setIsbn(String isbn){ this.isbn=isbn;}
    public LocalDate getPublicationDate(){ return publicationDate;}
    public void setPublicationDate(LocalDate publicationDate){ this.publicationDate=publicationDate;}
    public List<Author> getAuthors() { return authors; }
    public void setAuthors(List<Author> authors) { this.authors = authors; }
    public void addAuthor(Author author) { this.authors.add(author);}

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publicationDate=" + publicationDate +
                ", authors=" + authors +
                '}';
    }
}

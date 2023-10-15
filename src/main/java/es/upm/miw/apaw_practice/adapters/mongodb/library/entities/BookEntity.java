package es.upm.miw.apaw_practice.adapters.mongodb.library.entities;

import es.upm.miw.apaw_practice.domain.models.library.Book;
import es.upm.miw.apaw_practice.domain.models.library.BookWriter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Document
public class BookEntity {
    @Id
    private String id;
    private String title;
    //@Indexed(unique = true)
    private String isbn;
    private LocalDate publicationDate;
    @DBRef
    private List<BookWriterEntity> bookWriterEntities;

    public BookEntity() {
        //empty from framework
    }

    public BookEntity(String title, String isbn, LocalDate publicationDate, List<BookWriterEntity> bookWriterEntities) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.bookWriterEntities = bookWriterEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public List<BookWriterEntity> getBookWriterEntities() {
        return bookWriterEntities;
    }

    public void setWriterEntities(List<BookWriterEntity> bookWriterEntities) { this.bookWriterEntities = bookWriterEntities;}

    public Book toBook() {
        List<BookWriter> bookWriters = this.bookWriterEntities.stream()
                .map(BookWriterEntity::toBookWriter)
                .toList();
        return new Book(this.title, this.isbn, this.publicationDate, bookWriters);
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (isbn.equals(((BookEntity) obj).isbn));
    }

    @Override
    public int hashCode() {
        return this.isbn.hashCode();
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publicationDate=" + publicationDate +
                ", bookWriterEntities=" + bookWriterEntities +
                '}';
    }
}

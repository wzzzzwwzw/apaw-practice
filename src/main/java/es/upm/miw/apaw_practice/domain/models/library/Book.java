package es.upm.miw.apaw_practice.domain.models.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String isbn;
    private LocalDate publicationDate;
    private List<BookWriter> bookWriters;

    public Book(){
        bookWriters = new ArrayList<>();
    }

    public Book(String title, String isbn, LocalDate publicationDate, List<BookWriter> bookWriters) {
        this.title = title;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.bookWriters = bookWriters;
    }

    public String getTitle() { return title;}
    public void setTitle(String title) { this.title = title;}
    public String getIsbn(){ return isbn;}
    public void setIsbn(String isbn){ this.isbn=isbn;}
    public LocalDate getPublicationDate(){ return publicationDate;}
    public void setPublicationDate(LocalDate publicationDate){ this.publicationDate=publicationDate;}
    public List<BookWriter> getBookWriters() { return bookWriters; }
    public void setBookWriters(List<BookWriter> bookWriters) { this.bookWriters = bookWriters; }
    public void addBookWriter(BookWriter bookWriter) { this.bookWriters.add(bookWriter);}

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publicationDate=" + publicationDate +
                ", bookWriters=" + bookWriters +
                '}';
    }
}

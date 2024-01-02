package es.upm.miw.apaw_practice.domain.models.library;
import es.upm.miw.apaw_practice.domain.models.library.composite.TreeBooks;
import es.upm.miw.apaw_practice.domain.models.library.builders.BookBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Book implements TreeBooks{
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

    public static class Builder implements BookBuilders.Isbn, BookBuilders.Optionals {
        private final Book book;

        public Builder(){
            this.book = new Book();
        }

        @Override
        public BookBuilders.Optionals isbn(String isbn) {
            this.book.setIsbn(isbn);
            return this;
        }

        @Override
        public BookBuilders.Optionals title(String title) {
            this.book.setTitle(title);
            return this;
        }

        @Override
        public BookBuilders.Optionals publicationDate(LocalDate publicationDate) {
            this.book.setPublicationDate(publicationDate);
            return this;
        }

        @Override
        public BookBuilders.Optionals bookWriters(List<BookWriter> bookWriters) {
            this.book.setBookWriters(bookWriters);
            return this;
        }

        @Override
        public Book build() {
            return this.book;
        }

    }

    @Override
    public Boolean isComposite() {
        return false;
    }

    @Override
    public void add(TreeBooks treeBooks) {
        throw new UnsupportedOperationException("Unsupported operation in Book leaf");
    }

    @Override
    public void remove(TreeBooks treeBooks) {
        // cannot remove in leaf
    }

    @Override
    public int number() {
        return 1;
    }
}

package es.upm.miw.apaw_practice.domain.models.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private String address;
    private LocalDate foundationDate;
    private List<Book> books;

    public Library(){
        this.books = new ArrayList<>();
    }

    public Library(String name, String address, LocalDate foundationDate, List<Book> books){
        this.name=name;
        this.address=address;
        this.foundationDate=foundationDate;
        this.books = books;
    }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public String getAddress(){ return address; }
    public void setAddress(String address){ this.address=address; }
    public LocalDate getFoundationDate(){ return foundationDate; }
    public void setFoundationDate(LocalDate foundationDate){ this.foundationDate=foundationDate; }
    public List<Book> getBooks(){ return this.books; }
    public void setBooks(List<Book> books) { this.books=books; }
    public void addBook(Book book) { this.books.add(book); }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", foundationDate=" + foundationDate +
                ", books=" + books +
                '}';
    }
}

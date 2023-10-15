package es.upm.miw.apaw_practice.adapters.mongodb.library.entities;

import es.upm.miw.apaw_practice.domain.models.library.Book;
import es.upm.miw.apaw_practice.domain.models.library.Library;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Document
public class LibraryEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String address;
    private LocalDate foundationDate;
    @DBRef
    private List<BookEntity> bookEntities;

    public LibraryEntity() {
        //empty for framework
    }

    public LibraryEntity(String name, String address, LocalDate foundationDate, List<BookEntity> bookEntities) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
        this.foundationDate = foundationDate;
        this.bookEntities = bookEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    public List<BookEntity> getBookEntities() {
        return bookEntities;
    }

    public void setBookEntities(List<BookEntity> bookEntities) {
        this.bookEntities = bookEntities;
    }

    public Library toLibrary() {
        Library library = new Library();
        BeanUtils.copyProperties(this, library, "bookEntities");
        List<Book> books = this.bookEntities.stream()
                .map(BookEntity::toBook)
                .collect(Collectors.toList());
        library.setBooks(books);
        return library;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (name.equals(((LibraryEntity) obj).name));
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public String toString() {
        return "LibraryEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", foundationDate=" + foundationDate +
                ", bookEntities=" + bookEntities +
                '}';
    }
}

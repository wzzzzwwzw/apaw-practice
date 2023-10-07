package es.upm.miw.apaw_practice.adapters.mongodb.conference.entities;

import es.upm.miw.apaw_practice.domain.models.conference.Author;
import es.upm.miw.apaw_practice.domain.models.shop.Article;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document
public class AuthorEntity {
    @Id
    private String id;
    private String name;
    private String surname;
    private String honorific;

    public AuthorEntity() {
        //empty for framework
    }

    public AuthorEntity(String name, String surname, String honorific) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.honorific = honorific;
    }

    public AuthorEntity(Author author) {
        BeanUtils.copyProperties(author, this);
        this.id = UUID.randomUUID().toString();
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getHonorific() {
        return honorific;
    }

    public void setHonorific(String honorific) {
        this.honorific = honorific;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorEntity that = (AuthorEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AuthorEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", honorific='" + honorific + '\'' +
                '}';
    }

    public Author toAuthor() {
        Author author = new Author();
        BeanUtils.copyProperties(this, author);
        return author;
    }
}

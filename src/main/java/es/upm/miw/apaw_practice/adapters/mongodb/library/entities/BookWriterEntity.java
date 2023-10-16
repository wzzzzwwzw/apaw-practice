package es.upm.miw.apaw_practice.adapters.mongodb.library.entities;

import es.upm.miw.apaw_practice.domain.models.library.BookWriter;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class BookWriterEntity {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String nickname;
    private Integer numberOfBook;

    public BookWriterEntity() {
        //empty for framework
    }

    public BookWriterEntity(BookWriter bookWriter) {
        BeanUtils.copyProperties(bookWriter,this);
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getNumberOfBook() {
        return numberOfBook;
    }

    public void setNumberOfBook(Integer numberOfBook) {
        this.numberOfBook = numberOfBook;
    }

    public BookWriter toBookWriter() {
        BookWriter bookWriter = new BookWriter();
        BeanUtils.copyProperties(this, bookWriter);
        return bookWriter;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (nickname.equals(((BookWriterEntity) obj).nickname));
    }

    @Override
    public int hashCode() {
        return this.nickname.hashCode();
    }

    @Override
    public String toString() {
        return "BookWriterEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", numberOfBook=" + numberOfBook +
                '}';
    }
}

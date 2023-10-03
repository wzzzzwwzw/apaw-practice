package es.upm.miw.apaw_practice.domain.models.conference;

import java.util.ArrayList;
import java.util.List;

public class Paper {
    String title;
    String digitalObjectIdentifier;
    Integer length;
    List<Author> authors;

    public Paper() {
        authors = new ArrayList<>();
    }

    public Paper(String title, String digitalObjectIdentifier, Integer length) {
        this();
        this.title = title;
        this.digitalObjectIdentifier = digitalObjectIdentifier;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDigitalObjectIdentifier() {
        return digitalObjectIdentifier;
    }

    public void setDigitalObjectIdentifier(String digitalObjectIdentifier) {
        this.digitalObjectIdentifier = digitalObjectIdentifier;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    @Override
    public String toString() {
        return "Paper{" +
                "title='" + title + '\'' +
                ", digitalObjectIdentifier='" + digitalObjectIdentifier + '\'' +
                ", length=" + length +
                ", authors=" + authors +
                '}';
    }
}

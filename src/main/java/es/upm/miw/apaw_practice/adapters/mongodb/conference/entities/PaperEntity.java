package es.upm.miw.apaw_practice.adapters.mongodb.conference.entities;

import es.upm.miw.apaw_practice.domain.models.conference.Author;
import es.upm.miw.apaw_practice.domain.models.conference.Paper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class PaperEntity {
    @Id
    private String id;
    private String title;
    @Indexed(unique = true)
    private String digitalObjectIdentifier;
    private Integer length;
    @DBRef
    List<AuthorEntity> authorEntities;

    public PaperEntity() {
        // empty for framework
    }

    public PaperEntity(String title, String digitalObjectIdentifier, Integer length, List<AuthorEntity> authorEntities) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.digitalObjectIdentifier = digitalObjectIdentifier;
        this.length = length;
        this.authorEntities = authorEntities;
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

    public List<AuthorEntity> getAuthorEntities() {
        return authorEntities;
    }

    public void setAuthorEntities(List<AuthorEntity> authorEntities) {
        this.authorEntities = authorEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaperEntity that = (PaperEntity) o;
        return Objects.equals(digitalObjectIdentifier, that.digitalObjectIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(digitalObjectIdentifier);
    }

    @Override
    public String toString() {
        return "PaperEntity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", digitalObjectIdentifier='" + digitalObjectIdentifier + '\'' +
                ", length=" + length +
                ", authorEntities=" + authorEntities +
                '}';
    }

    public Paper toPaper() {
        List<Author> authors = this.authorEntities.stream()
                .map(AuthorEntity::toAuthor).toList();
        Paper paper = new Paper(title, digitalObjectIdentifier, length);
        paper.setAuthors(authors);
        return paper;
    }
}

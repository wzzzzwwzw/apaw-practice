package es.upm.miw.apaw_practice.domain.models.conference;

import java.util.ArrayList;
import java.util.List;

public class Paper implements TreePapers{
    private String title;
    private String digitalObjectIdentifier;
    private Integer length;
    private List<Author> authors;

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

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
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

    @Override
    public Boolean isComposite() {
        return false;
    }

    @Override
    public void add(TreePapers treePapers) {
        throw new UnsupportedOperationException("Unsupported operation in leaf");
    }

    @Override
    public void remove(TreePapers treePapers) {
        // cannot remove in leaf
    }
}

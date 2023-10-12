package es.upm.miw.apaw_practice.domain.models.conference;

public interface TreePapers {
    Boolean isComposite();

    void add(TreePapers treePapers);

    void remove(TreePapers treePapers);
}

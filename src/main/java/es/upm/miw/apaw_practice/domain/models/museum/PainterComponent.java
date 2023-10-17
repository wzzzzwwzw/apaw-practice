package es.upm.miw.apaw_practice.domain.models.museum;

public interface PainterComponent {
    boolean isComposite();

    void add (PainterComponent painterComponent);

    void remove(PainterComponent painterComponent);
}

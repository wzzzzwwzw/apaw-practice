package es.upm.miw.apaw_practice.domain.models.bakery;

public interface ProductComponent {
    void add(ProductComponent productComponent);

    void remove(ProductComponent productComponent);

    boolean isComposite();
}

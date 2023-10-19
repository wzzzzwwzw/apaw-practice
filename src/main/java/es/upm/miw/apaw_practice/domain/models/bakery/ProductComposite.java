package es.upm.miw.apaw_practice.domain.models.bakery;

import java.util.ArrayList;
import java.util.List;

public class ProductComposite implements ProductComponent {
    private final List<ProductComponent> productComponentList;

    public ProductComposite() {
        this.productComponentList = new ArrayList<>();
    }

    @Override
    public void add(ProductComponent productComponent) {
        this.productComponentList.add(productComponent);
    }

    @Override
    public void remove(ProductComponent productComponent) {
        this.productComponentList.remove(productComponent);
    }

    @Override
    public boolean isComposite() {
        return true;
    }
}

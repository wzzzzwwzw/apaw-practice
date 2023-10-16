package es.upm.miw.apaw_practice.domain.models.museum;

import java.util.ArrayList;
import java.util.List;

public class PainterComposite implements PainterComponent {
    private final List<PainterComponent> painterComponentList;

    public PainterComposite() {
        this.painterComponentList = new ArrayList<>();
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public void add(PainterComponent painterComponent) {
        this.painterComponentList.add(painterComponent);
    }

    @Override
    public void remove(PainterComponent painterComponent) {
        this.painterComponentList.remove(painterComponent);
    }
}

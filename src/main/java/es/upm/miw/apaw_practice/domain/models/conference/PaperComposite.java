package es.upm.miw.apaw_practice.domain.models.conference;

import java.util.ArrayList;
import java.util.List;

public class PaperComposite implements TreePapers {
    private final String journalName;
    private final List<TreePapers> treePapers;

    public PaperComposite(String journalName) {
        this.journalName = journalName;
        this.treePapers = new ArrayList<>();
    }

    @Override
    public Boolean isComposite() {
        return true;
    }

    @Override
    public void add(TreePapers treePapers) {
        this.treePapers.add(treePapers);
    }

    @Override
    public void remove(TreePapers treePapers) {
        this.treePapers.remove(treePapers);
    }

    @Override
    public String toString() {
        return "PaperComposite{" +
                "journalName='" + journalName + '\'' +
                ", treePapers=" + treePapers +
                '}';
    }
}

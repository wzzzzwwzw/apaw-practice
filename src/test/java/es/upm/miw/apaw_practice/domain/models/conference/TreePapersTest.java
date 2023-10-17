package es.upm.miw.apaw_practice.domain.models.conference;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TreePapersTest {

    @Test
    void testTreePapersComposite() {
        PaperComposite paperComposite = new PaperComposite("A journal");
        Assertions.assertTrue(paperComposite.isComposite());

        Paper paper = new Paper("title", "DOI NaN", 3);
        paperComposite.add(paper);
        Assertions.assertEquals(1, paperComposite.getTreePapers().size());

        paperComposite.remove(paper);
        Assertions.assertEquals(0, paperComposite.getTreePapers().size());
    }

    @Test
    void testTreePapersLeaf() {
        Paper paper = new Paper("title", "DOI NaN", 3);
        Assertions.assertFalse(paper.isComposite());

        Assertions.assertThrows(UnsupportedOperationException.class, () -> paper.add(paper));
    }
}

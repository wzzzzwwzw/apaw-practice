package es.upm.miw.apaw_practice.domain.models.bank.composite;

public interface TreeBank {

    boolean isComposite();

    void add(TreeBank treeBank);

    void delete(TreeBank treeBank);
}

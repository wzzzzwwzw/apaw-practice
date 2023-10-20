package es.upm.miw.apaw_practice.domain.models.library;

import es.upm.miw.apaw_practice.domain.models.library.composite.TreeBooks;

import java.util.ArrayList;
import java.util.List;

public class BooksComposite implements TreeBooks {
    private final String title;
    private final List<TreeBooks> treeBooksList;

    public BooksComposite(String title) {
        this.title = title;
        this.treeBooksList = new ArrayList<>();
    }

    @Override
    public Boolean isComposite() {
        return true;
    }

    @Override
    public void add(TreeBooks treeBooks) {
        this.treeBooksList.add(treeBooks);
    }

    @Override
    public void remove(TreeBooks treeBooks) {
        this.treeBooksList.remove(treeBooks);
    }

    @Override
    public int number() {
        return this.treeBooksList.size();
    }

    public List<TreeBooks> getTreeBooksList(){
        return this.treeBooksList;
    }

    @Override
    public String toString() {
        return "BooksComposite{" +
                "title='" + title + '\'' +
                ", treeBooksList=" + treeBooksList +
                '}';
    }
}

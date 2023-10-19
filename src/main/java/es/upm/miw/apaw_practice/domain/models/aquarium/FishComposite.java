package es.upm.miw.apaw_practice.domain.models.aquarium;
import java.util.ArrayList;
import java.util.List;
public class FishComposite implements TreeFishes {
    private final String species;
    private final List<TreeFishes> treeFishes;

    public FishComposite(String species){
        this.species=species;
        this.treeFishes=new ArrayList<>();
    }
    @Override
    public Boolean isComposite(){
        return true;
    }

    @Override
    public void add(TreeFishes treeFishes) {
        this.treeFishes.add(treeFishes);
    }

    @Override
    public void remove(TreeFishes treeFishes) {
        this.treeFishes.remove(treeFishes);
    }
    public List<TreeFishes>getTreeFishes(){
        return this.treeFishes;
    }

    @Override
    public String toString() {
        return "FishComposite{" +
                "species='" + species + '\'' +
                ", treeFishes=" + treeFishes +
                '}';
    }
}

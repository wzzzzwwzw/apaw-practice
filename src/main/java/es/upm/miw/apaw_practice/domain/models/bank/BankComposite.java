package es.upm.miw.apaw_practice.domain.models.bank;

import es.upm.miw.apaw_practice.domain.models.bank.composite.TreeBank;

import java.util.ArrayList;
import java.util.List;

public class BankComposite implements TreeBank {

    private final String bankName;


    private final List<TreeBank> treeBanks;

    public BankComposite(String bankName){
        this.bankName=bankName;
        this.treeBanks=new ArrayList<TreeBank>();

    }

    public List<TreeBank> getTreeBanks() {
        return treeBanks;
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public void add(TreeBank treeBank) {
       this.treeBanks.add(treeBank);
    }

    @Override
    public void delete(TreeBank treeBank) {
        this.treeBanks.remove(treeBank);
    }

    @Override
    public String toString() {
        return "BankComposite{" +
                "bankName='" + bankName + '\'' +
                ", treeBanks=" + treeBanks +
                '}';
    }
}

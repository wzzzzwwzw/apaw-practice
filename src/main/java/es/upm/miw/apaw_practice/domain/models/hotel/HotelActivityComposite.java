package es.upm.miw.apaw_practice.domain.models.hotel;

import es.upm.miw.apaw_practice.domain.models.hotel.composite.HotelActivitiesTree;

import java.util.ArrayList;
import java.util.List;

public class HotelActivityComposite implements HotelActivitiesTree {
    private final String name;
    private final List<HotelActivitiesTree> hotelActivityTree;

    public HotelActivityComposite(String name) {
        this.name = name;
        this.hotelActivityTree = new ArrayList<>();
    }

    @Override
    public Boolean isComposite() {
        return true;
    }

    @Override
    public void add(HotelActivitiesTree treeActivities) {
        this.hotelActivityTree.add(treeActivities);
    }

    @Override
    public void remove(HotelActivitiesTree treeActivities) {
        this.hotelActivityTree.remove(treeActivities);
    }

    public List<HotelActivitiesTree> getTreeActivities() {
        return hotelActivityTree;
    }

    @Override
    public String toString() {
        return "HotelActivityComposite{" +
                "name='" + name + '\'' +
                ", treeActivities=" + getTreeActivities() +
                '}';
    }
}

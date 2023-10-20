package es.upm.miw.apaw_practice.domain.models.hotel.composite;

public interface HotelActivitiesTree {
    Boolean isComposite();

    void add(HotelActivitiesTree treeActivity);

    void remove(HotelActivitiesTree treeActivity);
}

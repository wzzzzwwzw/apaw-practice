package es.upm.miw.apaw_practice.domain.models.ticket_bus;

public interface PassengerComponent {

    boolean isComposite();

    void add(PassengerComponent treePassengers);

    void remove(PassengerComponent treePassengers);

    int numberOfNodes();
}

package es.upm.miw.apaw_practice.domain.models.ticket_bus;

import java.util.ArrayList;
import java.util.List;

public class PassengerComposite implements PassengerComponent {

    private final String fullName;
    private final List<PassengerComponent> passengerComponents;

    public PassengerComposite(String fullName) {
        this.fullName = fullName;
        this.passengerComponents = new ArrayList<>();
    }

    public String getFullName() {
        return this.fullName;
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public void add(PassengerComponent treePassenger) {
        this.passengerComponents.add(treePassenger);
    }

    @Override
    public void remove(PassengerComponent treePassenger) {
        this.passengerComponents.remove(treePassenger);
    }

    @Override
    public int numberOfNodes() {
        return this.passengerComponents.size();
    }
}

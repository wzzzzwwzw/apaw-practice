package es.upm.miw.apaw_practice.domain.models.ticket_bus;

public record PassengerLeaf(Passenger passenger) implements PassengerComponent {


    public boolean isComposite() {
        return false;
    }

    @Override
    public void add(PassengerComponent treePassengers) {
        // Do nothing because it is a leaf
    }

    @Override
    public void remove(PassengerComponent treePassengers) {
        // Do nothing because it is a leaf
    }

    @Override
    public int numberOfNodes() {
        return 1;
    }
}

package es.upm.miw.apaw_practice.domain.persistence_ports.car_workshop;

public interface InvoicePersistence {
    void deleteByPaid(Boolean paid);
}

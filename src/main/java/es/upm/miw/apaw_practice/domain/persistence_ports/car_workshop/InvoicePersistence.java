package es.upm.miw.apaw_practice.domain.persistence_ports.car_workshop;

import es.upm.miw.apaw_practice.domain.models.car_workshop.Invoice;

import java.util.stream.Stream;

public interface InvoicePersistence {
    void deleteByPaid(Boolean paid);

    Stream<Invoice> findAll();

    Stream<Invoice> findByCarComponent(String carComponentName);
}

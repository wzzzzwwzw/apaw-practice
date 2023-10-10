package es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.daos.InvoiceRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_workshop.InvoicePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("invoicePersistence")
public class InvoicePersistenceMongodb implements InvoicePersistence {

    private InvoiceRepository invoiceRepository;

    @Autowired
    public InvoicePersistenceMongodb(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public void deleteByPaid(Boolean paid) {
        //TODO

    }
}

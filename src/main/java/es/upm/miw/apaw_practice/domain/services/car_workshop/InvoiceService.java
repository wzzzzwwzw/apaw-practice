package es.upm.miw.apaw_practice.domain.services.car_workshop;

import es.upm.miw.apaw_practice.domain.persistence_ports.car_workshop.InvoicePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    private final InvoicePersistence invoicePersistence;
    @Autowired
    public InvoiceService(InvoicePersistence invoicePersistence) {
        this.invoicePersistence = invoicePersistence;
    }


    public void deleteByPaid(Boolean paid) {
        this.invoicePersistence.deleteByPaid(paid);
    }
}

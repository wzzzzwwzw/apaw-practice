package es.upm.miw.apaw_practice.adapters.rest.car_workshop;

import es.upm.miw.apaw_practice.domain.services.car_workshop.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(InvoiceResource.INVOICES)
public class InvoiceResource {

    static final String INVOICES = "/car-workshop/invoices";

    static final String PAID = "/paid";

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceResource(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @DeleteMapping(InvoiceResource.PAID)
    public void delete() {
        this.invoiceService.deleteByPaid(true);
    }
}

package es.upm.miw.apaw_practice.domain.services.car_workshop;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class InvoiceServiceIT {

    @Autowired
    private InvoiceService invoiceService;

    @Test
    void testDelete() {
        int invoiceCountBefore = this.invoiceService.readAll().toList().size();
        this.invoiceService.deleteByPaid(true);
        int invoiceCountAfter = this.invoiceService.readAll().toList().size();
        assertEquals(invoiceCountBefore, 4);
        assertEquals(invoiceCountAfter, 1);
    }
}

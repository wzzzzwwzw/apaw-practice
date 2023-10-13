package es.upm.miw.apaw_practice.domain.services.car_workshop;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.car_workshop.CarComponent;
import es.upm.miw.apaw_practice.domain.models.car_workshop.Invoice;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_workshop.CarComponentPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_workshop.InvoicePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class CarComponentService {

    private final CarComponentPersistence carComponentPersistence;

    private final InvoicePersistence invoicePersistence;

    @Autowired
    public CarComponentService(CarComponentPersistence carComponentPersistence, InvoicePersistence invoicePersistence) {
        this.carComponentPersistence = carComponentPersistence;
        this.invoicePersistence = invoicePersistence;
    }

    public CarComponent create(CarComponent carComponent) {
        this.assertNameNotExist(carComponent.getName());
        return this.carComponentPersistence.create(carComponent);
    }

    public void assertNameNotExist(String name) {
        if (this.carComponentPersistence.existsName(name)) {
            throw new ConflictException("Name exist: " + name);
        }
    }

    public Integer findTotalStockByIsITVSafe(Boolean isITVSafe) {
        Stream<Invoice> invoicesWithCarComponent = this.invoicePersistence.findByIsITVSafe(isITVSafe);
    }
}

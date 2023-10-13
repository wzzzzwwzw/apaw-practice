package es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.daos.InvoiceRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.entities.InvoiceEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.entities.OBDFaultEntity;
import es.upm.miw.apaw_practice.domain.models.car_workshop.Invoice;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_workshop.InvoicePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("invoicePersistence")
public class InvoicePersistenceMongodb implements InvoicePersistence {

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoicePersistenceMongodb(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public void deleteByPaid(Boolean paid) {
        this.invoiceRepository.findAll().stream()
                .filter(invoiceEntity -> invoiceEntity.getPaid().equals(paid))
                .forEach(invoiceEntity -> this.invoiceRepository.delete(invoiceEntity));
    }

    @Override
    public Stream<Invoice> findAll() {
        return this.invoiceRepository.findAll().stream()
                .map(InvoiceEntity::toInvoice);
    }

    @Override
    public Stream<Invoice> findByCarComponent(String carComponentName) {
        return this.invoiceRepository.findAll().stream()
                .filter(invoiceEntity -> invoiceEntity.getCarComponentEntities().stream()
                        .anyMatch(carComponentEntity -> carComponentEntity.getName().equals(carComponentName)))
                .map(InvoiceEntity::toInvoice)
                .distinct();
    }

    @Override
    public Stream<Invoice> findByIsITVSafe(Boolean isITVSafe) {
        return this.invoiceRepository.findAll().stream()
                .filter(invoiceEntity -> invoiceEntity.getCarToRepairEntity()
                        .getObdFaultEntities().stream()
                        .anyMatch(obdFaultEntity -> obdFaultEntity.getIsITVSafe().equals(isITVSafe)))
                .map(InvoiceEntity::toInvoice);
    }
}

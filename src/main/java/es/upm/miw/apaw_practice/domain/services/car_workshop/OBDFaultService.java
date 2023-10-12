package es.upm.miw.apaw_practice.domain.services.car_workshop;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.car_workshop.Invoice;
import es.upm.miw.apaw_practice.domain.models.car_workshop.OBDFault;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_workshop.InvoicePersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_workshop.OBDFaultPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class OBDFaultService {

    private final OBDFaultPersistence obdFaultPersistence;

    private final InvoicePersistence invoicePersistence;

    @Autowired
    public OBDFaultService(OBDFaultPersistence obdFaultPersistence, InvoicePersistence invoicePersistence) {
        this.obdFaultPersistence = obdFaultPersistence;
        this.invoicePersistence = invoicePersistence;
    }

    public Stream<OBDFault> findByIsITVSafe(Boolean isITVSafe) {
        return this.obdFaultPersistence.findByIsITVSafe(isITVSafe);
    }

    public OBDFault updatePartial(String code, OBDFault obdFault) {
        this.assertCodeNotConflict(code, obdFault.getCode());
        return this.obdFaultPersistence.updatePartial(code,obdFault);
    }

    private void assertCodeNotConflict(String code, String newCode) {
        if(!this.obdFaultPersistence.existsCode(code)){
            throw new NotFoundException("Code not exits: " + code);
        }
        if(!code.equals(newCode) && this.obdFaultPersistence.existsCode(newCode)){
            throw new ConflictException("New code exists: " + newCode);
        }
    }

    public Stream<String> findByCarComponentName(String carComponentName) {
        Stream<Invoice> invoicesWithCarComponent = this.invoicePersistence.findByCarComponent(carComponentName);
        return invoicesWithCarComponent.flatMap(invoice ->
                invoice.getCarToRepair()
                        .getObdFaults().stream()
                        .map(OBDFault::getCode)
        );
    }

}

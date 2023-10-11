package es.upm.miw.apaw_practice.domain.services.car_workshop;

import es.upm.miw.apaw_practice.domain.models.car_workshop.OBDFault;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_workshop.OBDFaultPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class OBDFaultService {

    private final OBDFaultPersistence obdFaultPersistence;

    @Autowired
    public OBDFaultService(OBDFaultPersistence obdFaultPersistence) {
        this.obdFaultPersistence = obdFaultPersistence;
    }

    public Stream<OBDFault> findByIsITVSafe(Boolean isITVSafe) {
        return this.obdFaultPersistence.findByIsITVSafe(isITVSafe);
    }

    public OBDFault updatePartial(String code, OBDFault obdFault) {
        OBDFault existingOBDFault = this.readByCode(code);
        //TODO update existingOBDFault
        return this.obdFaultPersistence.updatePartial(obdFault);
    }

}

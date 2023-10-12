package es.upm.miw.apaw_practice.domain.models.computer_store.builders;


import es.upm.miw.apaw_practice.domain.models.computer_store.Monitor;
import es.upm.miw.apaw_practice.domain.models.computer_store.Wire;

import java.math.BigDecimal;
import java.util.List;

public interface MonitorBuilders {
    interface SerialNumber {
        Optionals serialNumber(String serialNumber);
    }

    interface Optionals {
        Optionals size(BigDecimal size);

        Optionals refreshRate(Integer refreshRate);

        Optionals wires(List<Wire> wires);

        Monitor build();
    }
}

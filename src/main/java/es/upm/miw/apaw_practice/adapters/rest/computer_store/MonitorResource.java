package es.upm.miw.apaw_practice.adapters.rest.computer_store;

import es.upm.miw.apaw_practice.domain.models.computer_store.Monitor;
import es.upm.miw.apaw_practice.domain.services.computer_store.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(MonitorResource.MONITORS)
public class MonitorResource {
    static final String MONITORS = "/computer-store/monitors";
    static final String SERIALNUMBER_ID = "/{serialNumber}";
    static final String REFRESH_RATE = "/refresh-rate";
    private final MonitorService monitorService;

    @Autowired
    public MonitorResource(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    @PutMapping(SERIALNUMBER_ID + REFRESH_RATE)
    public Monitor updateMonitorRefreshRate(@PathVariable String serialNumber, @RequestBody Integer refreshRate) {
        return this.monitorService.updateRefreshRate(serialNumber, refreshRate);
    }
}

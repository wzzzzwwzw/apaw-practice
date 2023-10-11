package es.upm.miw.apaw_practice.adapters.rest.computer_store;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.exceptions.BadRequestException;
import es.upm.miw.apaw_practice.domain.models.computer_store.Monitor;
import es.upm.miw.apaw_practice.domain.services.computer_store.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

@RestController
@RequestMapping(MonitorResource.MONITORS)
public class MonitorResource {
    static final String MONITORS = "/computer-store/monitors";
    static final String SERIALNUMBER_ID = "/{serialNumber}";
    static final String REFRESH_RATE = "/refresh-rate";
    static final String SEARCH = "/search";
    private final MonitorService monitorService;

    @Autowired
    public MonitorResource(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    @PutMapping(SERIALNUMBER_ID + REFRESH_RATE)
    public Monitor updateMonitorRefreshRate(@PathVariable String serialNumber, @RequestBody Integer refreshRate) {
        return this.monitorService.updateRefreshRate(serialNumber, refreshRate);
    }

    @GetMapping(SEARCH)
    public Stream<Monitor> findSerialNumbersByDateAndCost(@RequestParam String q) {
        LocalDateTime date = new LexicalAnalyzer().extractWithAssure(q, "date", dateString -> {
            String[] splittedDate = dateString.split(" ");
            String correctDateString = splittedDate[0] + " " + String.join(":", splittedDate[1], splittedDate[2], splittedDate[3]);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return LocalDateTime.parse(correctDateString, dateTimeFormatter);
        });
        BigDecimal cost = new LexicalAnalyzer().extractWithAssure(q, "cost", BigDecimal::new);
        if (cost.compareTo(BigDecimal.ZERO) < 0) {
            throw new BadRequestException("Cost: " + cost + " should be greater than 0");
        }
        return this.monitorService.findSerialNumberByDateAndCost(date, cost);
    }
}

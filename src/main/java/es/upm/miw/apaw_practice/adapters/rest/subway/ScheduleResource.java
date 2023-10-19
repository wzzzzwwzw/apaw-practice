package es.upm.miw.apaw_practice.adapters.rest.subway;

import es.upm.miw.apaw_practice.domain.models.subway.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import es.upm.miw.apaw_practice.domain.services.subway.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(ScheduleResource.SCHEDULES)
public class ScheduleResource {

    static final String SCHEDULES = "/subway/schedules";

    static final String SEARCH = "/search";

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleResource(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PatchMapping
    public Stream<Schedule> update(@RequestBody Float newFrequency) {
        return this.scheduleService.update(newFrequency);
    }

    @GetMapping()
    public Stream<Schedule> readAll() {
        return this.scheduleService.readAll();
    }

    @GetMapping(SEARCH)
    public Float getAverageFrequencyByCity(@RequestParam String city) {
        return this.scheduleService.getAverageFrequencyByCity(city);
    }

}

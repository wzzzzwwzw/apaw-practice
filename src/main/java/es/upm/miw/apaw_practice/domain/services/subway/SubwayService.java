package es.upm.miw.apaw_practice.domain.services.subway;

import es.upm.miw.apaw_practice.domain.models.subway.Line;
import es.upm.miw.apaw_practice.domain.models.subway.Subway;
import org.springframework.beans.factory.annotation.Autowired;
import es.upm.miw.apaw_practice.domain.persistence_ports.subway.SubwayPersistence;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubwayService {

    private final SubwayPersistence subwayPersistence;

    @Autowired
    public SubwayService(SubwayPersistence subwayPersistence) {
        this.subwayPersistence = subwayPersistence;
    }

    public Line findLineByCityAndLabel(String city,String lineLabel) {
        return this.subwayPersistence.findLineByCityAndLabel(city,lineLabel);
    }

    public Subway findByCity(String city) {
        return this.subwayPersistence.readByCity(city);
    }


    public Subway updateLines(String city, List<Line> lines) {
        Subway subway = this.subwayPersistence.readByCity(city);
        subway.setLines(lines);
        return this.subwayPersistence.update(subway);
    }
}

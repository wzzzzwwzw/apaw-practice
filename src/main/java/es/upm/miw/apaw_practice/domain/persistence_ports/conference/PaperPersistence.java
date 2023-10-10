package es.upm.miw.apaw_practice.domain.persistence_ports.conference;

import es.upm.miw.apaw_practice.domain.models.conference.Paper;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperPersistence {
    Paper readByDigitalObjectIdentifier(String digitalObjectIdentifier);

    Paper update(Paper paper);

    Integer findTotalLengthByConferenceLocationHall(String hall);
}

package es.upm.miw.apaw_practice.domain.persistence_ports.conference;

import es.upm.miw.apaw_practice.domain.models.conference.Paper;

public interface PaperPersistence {
    Paper readByDigitalObjectIdentifier(String digitalObjectIdentifier);
}

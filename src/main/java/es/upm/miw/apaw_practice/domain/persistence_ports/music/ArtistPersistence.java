package es.upm.miw.apaw_practice.domain.persistence_ports.music;

import es.upm.miw.apaw_practice.domain.models.music.Artist;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistPersistence {

    Artist updatePhoneNumber(Artist artist);

    Artist readByDni(String dni);
}

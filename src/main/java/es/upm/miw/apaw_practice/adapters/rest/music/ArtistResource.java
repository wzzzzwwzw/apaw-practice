package es.upm.miw.apaw_practice.adapters.rest.music;

import es.upm.miw.apaw_practice.domain.models.music.Artist;
import es.upm.miw.apaw_practice.domain.services.music.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ArtistResource.ARTISTS)
public class ArtistResource {

    static final String ARTISTS = "/music/artists";

    static final String DNI_ID = "/{dni}";

    static final String PHONE_NUMBER = "/phone-number";

    private final ArtistService artistService;

    @Autowired
    public ArtistResource(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PutMapping(DNI_ID + PHONE_NUMBER)
    public Artist updateArtistPhoneNumber(@PathVariable String dni, @RequestBody Integer phoneNumber) {
        return this.artistService.updatePhoneNumber(dni, phoneNumber);
    }

}

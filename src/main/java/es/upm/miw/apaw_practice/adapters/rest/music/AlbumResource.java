package es.upm.miw.apaw_practice.adapters.rest.music;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.adapters.rest.music.dtos.DenominationCollectionDTO;
import es.upm.miw.apaw_practice.domain.models.music.Song;
import es.upm.miw.apaw_practice.domain.services.music.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(AlbumResource.ALBUMS)
public class AlbumResource {

    static final String ALBUMS = "/music/albums";

    static final String DENOMINATION_ID = "/{denomination}";

    static final String SONGS = "/songs";

    static final String SEARCH = "/search";

    static final String SEARCH2 = "/search2";


    private final AlbumService albumService;

    @Autowired
    public AlbumResource(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping(DENOMINATION_ID + SONGS)
    public Stream<Song> readSongsByAlbumDenomination(@PathVariable String denomination) {
        return this.albumService.readSongsByAlbumDenomination(denomination);
    }

    @DeleteMapping(DENOMINATION_ID)
    public void delete(@PathVariable String denomination) {
        this.albumService.delete(denomination);
    }

    @GetMapping(SEARCH)
    public Stream<Integer> getPhoneNumberByTypeAndRecordLabel(@RequestParam String q) {
        String type = new LexicalAnalyzer().extractWithAssure(q, "type");
        String recordLabel = new LexicalAnalyzer().extractWithAssure(q, "recordLabel");
        return this.albumService.getPhoneNumberByTypeAndRecordLabel(type, recordLabel);
    }

    @GetMapping(SEARCH2)
    public DenominationCollectionDTO getDifferentDenominationsByFullname(@RequestParam String q) {
        String fullname = new LexicalAnalyzer().extractWithAssure(q, "fullname");
        return new DenominationCollectionDTO(this.albumService.getDifferentDenominationsByFullname(fullname));
    }


}

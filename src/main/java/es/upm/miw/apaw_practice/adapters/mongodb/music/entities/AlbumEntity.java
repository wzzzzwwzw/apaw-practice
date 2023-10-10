package es.upm.miw.apaw_practice.adapters.mongodb.music.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class AlbumEntity {

    @Id
    private String id;

    @Indexed(unique = true)
    private String denomination;

    private LocalDateTime releaseDate;

    private String recordLabel;

    private List<SongEntity> songsEntitiesList;

    public AlbumEntity() {
        this.songsEntitiesList = new ArrayList<>();
    }

    public AlbumEntity(String denomination, LocalDateTime releaseDate, String recordLabel, List<SongEntity> songsEntitiesList) {
        this();
        this.id = UUID.randomUUID().toString();
        this.denomination = denomination;
        this.releaseDate = releaseDate;
        this.recordLabel = recordLabel;
        this.songsEntitiesList = songsEntitiesList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public void setRecordLabel(String recordLabel) {
        this.recordLabel = recordLabel;
    }

    public List<SongEntity> getSongsList() {
        return songsEntitiesList;
    }

    public void setSongsList(List<SongEntity> songsEntitiesList) {
        this.songsEntitiesList = songsEntitiesList;
    }

    public void addSong(SongEntity song) {
        this.songsEntitiesList.add(song);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumEntity that = (AlbumEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(denomination, that.denomination) &&
                Objects.equals(releaseDate, that.releaseDate) && Objects.equals(recordLabel, that.recordLabel)
                && Objects.equals(songsEntitiesList, that.songsEntitiesList);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "AlbumEntity{" +
                "id='" + id + '\'' +
                ", denomination='" + denomination + '\'' +
                ", releaseDate=" + releaseDate +
                ", recordLabel='" + recordLabel + '\'' +
                ", songsList=" + songsEntitiesList +
                '}';
    }
}

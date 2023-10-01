package es.upm.miw.apaw_practice.domain.models.music;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Album {

    private String denomination;

    private LocalDateTime releaseDate;

    private String recordLabel;

    private List<Song> songsList;

    public Album() {
        this.songsList = new ArrayList<>();
    }

    public Album(String denomination, LocalDateTime releaseDate, String recordLabel) {
        this();
        this.denomination = denomination;
        this.releaseDate = releaseDate;
        this.recordLabel = recordLabel;
    }

    public String getDenomination() {
        return this.denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public LocalDateTime getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRecordLabel() {
        return this.recordLabel;
    }

    public void setRecordLabel(String recordLabel) {
        this.recordLabel = recordLabel;
    }

    public List<Song> getSongsList() {
        return this.songsList;
    }

    public void setSongsList(List<Song> songsList) {
        this.songsList = songsList;
    }

    public void addSong(Song song) {
        this.songsList.add(song);
    }

    @Override
    public String toString() {
        return "Album{" +
                "denomination='" + this.denomination + '\'' +
                ", releaseDate=" + this.releaseDate +
                ", recordLabel='" + this.recordLabel + '\'' +
                ", songsList=" + this.songsList +
                '}';
    }
}

package es.upm.miw.apaw_practice.adapters.mongodb.museum.entities;

import es.upm.miw.apaw_practice.domain.models.museum.ArtWork;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class ArtWorkEntity {
    @Id
    private String inventoryNumber;
    private String title;
    private Integer approximateYear;
    private Boolean exhibited;
    @DBRef
    private RoomEntity room;

    public ArtWorkEntity() {
        // Empty for framework
    }

    public ArtWorkEntity(String inventoryNumber, String title, Integer approximateYear, Boolean exhibited, RoomEntity room) {
        this.inventoryNumber = inventoryNumber;
        this.title = title;
        this.approximateYear = approximateYear;
        this.exhibited = exhibited;
        this.room = room;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getApproximateYear() {
        return approximateYear;
    }

    public void setApproximateYear(Integer approximateYear) {
        this.approximateYear = approximateYear;
    }

    public Boolean getExhibited() {
        return exhibited;
    }

    public void setExhibited(Boolean exhibited) {
        this.exhibited = exhibited;
    }

    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }

    public void fromArtWork(ArtWork artWork) {
        BeanUtils.copyProperties(artWork, this);
    }

    public ArtWork toArtWork() {
        ArtWork artWork = new ArtWork();
        BeanUtils.copyProperties(this, artWork);
        return artWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtWorkEntity that = (ArtWorkEntity) o;
        return Objects.equals(inventoryNumber, that.inventoryNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryNumber);
    }

    @Override
    public String toString() {
        return "ArtWorkEntity{" +
                "inventoryNumber='" + inventoryNumber + '\'' +
                ", title='" + title + '\'' +
                ", approximateYear=" + approximateYear +
                ", exhibited=" + exhibited +
                ", room=" + room +
                '}';
    }
}

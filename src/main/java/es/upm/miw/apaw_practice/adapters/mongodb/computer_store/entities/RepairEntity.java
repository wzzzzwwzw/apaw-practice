package es.upm.miw.apaw_practice.adapters.mongodb.computer_store.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Document
public class RepairEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String repairNumber;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
    private ComputerEntity computerEntity;

    public RepairEntity() {
        //empty for framework
    }

    public RepairEntity(String repairNumber, LocalDateTime beginTime, LocalDateTime endTime, ComputerEntity computerEntity) {
        this.id = UUID.randomUUID().toString();
        this.repairNumber = repairNumber;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.computerEntity = computerEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRepairNumber() {
        return repairNumber;
    }

    public void setRepairNumber(String repairNumber) {
        this.repairNumber = repairNumber;
    }

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public ComputerEntity getComputerEntity() {
        return computerEntity;
    }

    public void setComputerEntity(ComputerEntity computerEntity) {
        this.computerEntity = computerEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RepairEntity that)) return false;
        return (Objects.equals(getId(), that.getId()) || Objects.equals(getRepairNumber(), that.getRepairNumber()))
                && Objects.equals(getBeginTime(), that.getBeginTime())
                && Objects.equals(getEndTime(), that.getEndTime())
                && Objects.equals(getComputerEntity(), that.getComputerEntity());
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "RepairEntity{" +
                "id='" + id + '\'' +
                ", repairNumber='" + repairNumber + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", computer=" + computerEntity +
                '}';
    }
}

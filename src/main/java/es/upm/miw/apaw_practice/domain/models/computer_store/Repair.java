package es.upm.miw.apaw_practice.domain.models.computer_store;

import java.time.LocalDateTime;

public class Repair {
    private String repairNumber;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
    private Computer computer;

    public Repair() {
    }

    public Repair(String repairNumber, LocalDateTime beginTime, LocalDateTime endTime, Computer computer) {
        this.repairNumber = repairNumber;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.computer = computer;
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

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "repairNumber='" + repairNumber + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", computer=" + computer +
                '}';
    }
}

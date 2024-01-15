package es.upm.miw.apaw_practice.domain.models.hotel;

import es.upm.miw.apaw_practice.domain.models.hotel.composite.HotelActivitiesTree;

public class HotelActivity implements HotelActivitiesTree {
    private String name;
    private String schedule;
    private String instructor;
    private Integer maxParticipants;

    public HotelActivity(String name, String schedule, String instructor, Integer maxParticipants) {
        this.name = name;
        this.schedule = schedule;
        this.instructor = instructor;
        this.maxParticipants = maxParticipants;
    }

    public HotelActivity() {
        // empty for framework
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Integer getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(Integer maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    @Override
    public String toString() {
        return "HotelActivity {" + '\'' +
                "  name = '" + name + '\'' +
                "  schedule = '" + schedule + '\'' +
                "  instructor = '" + instructor + '\'' +
                "  maxParticipants = " + maxParticipants + '\'' +
                '}';
    }

    @Override
    public Boolean isComposite() {
        return false;
    }

    @Override
    public void add(HotelActivitiesTree treeActivity) {
        throw new UnsupportedOperationException("Unsupported operation in HotelActivity leaf");
    }

    @Override
    public void remove(HotelActivitiesTree treeActivity) {
        // cannot remove in leaf
    }
}

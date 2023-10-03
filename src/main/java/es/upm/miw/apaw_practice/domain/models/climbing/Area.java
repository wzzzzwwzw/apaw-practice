package es.upm.miw.apaw_practice.domain.models.climbing;

public class Area {
    private String areaName;
    private String location;
    private boolean easyAccess;

    public Area(String areaName, String location, boolean easyAccess) {
        this.areaName = areaName;
        this.location = location;
        this.easyAccess = easyAccess;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isEasyAccess() {
        return easyAccess;
    }

    public void setEasyAccess(boolean easyAccess) {
        this.easyAccess = easyAccess;
    }

    @Override
    public String toString() {
        return "Area{" +
                "areaName='" + areaName + '\'' +
                ", location='" + location + '\'' +
                ", easyAccess=" + easyAccess +
                '}';
    }
}

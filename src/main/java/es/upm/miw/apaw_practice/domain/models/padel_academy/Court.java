package es.upm.miw.apaw_practice.domain.models.padel_academy;

public class Court {
    private Integer number;
    private Boolean withRoof;
    private String surface;

    public Court(Integer number, Boolean withRoof, String surface) {
        this.number = number;
        this.withRoof = withRoof;
        this.surface = surface;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getWithRoof() {
        return withRoof;
    }

    public void setWithRoof(Boolean roof) {
        this.withRoof = roof;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    @Override
    public String toString() {
        return "Court{" +
                "number=" + number +
                ", withRoof=" + withRoof +
                ", surface='" + surface + '\'' +
                '}';
    }
}

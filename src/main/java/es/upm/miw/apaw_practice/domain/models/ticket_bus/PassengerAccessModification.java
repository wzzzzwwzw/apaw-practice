package es.upm.miw.apaw_practice.domain.models.ticket_bus;

import java.util.Objects;

public class PassengerAccessModification {

    private Boolean oldAccess;
    private Boolean newAccess;

    public PassengerAccessModification() {
    }

    public PassengerAccessModification(Boolean oldAccess, Boolean newAccess) {
        this.oldAccess = oldAccess;
        this.newAccess = newAccess;
    }

    public Boolean getOldAccess() {
        return oldAccess;
    }

    public void setOldAccess(Boolean oldAccess) {
        this.oldAccess = oldAccess;
    }

    public Boolean getNewAccess() {
        return newAccess;
    }

    public void setNewAccess(Boolean newAccess) {
        this.newAccess = newAccess;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerAccessModification that)) return false;
        return Objects.equals(oldAccess, that.oldAccess) && Objects.equals(newAccess, that.newAccess);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oldAccess, newAccess);
    }

    @Override
    public String toString() {
        return "PassengerAccessModification{" +
                "oldAccess=" + oldAccess +
                ", newAccess=" + newAccess +
                '}';
    }
}

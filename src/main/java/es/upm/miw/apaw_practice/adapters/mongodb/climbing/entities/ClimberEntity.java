package es.upm.miw.apaw_practice.adapters.mongodb.climbing.entities;

import es.upm.miw.apaw_practice.domain.models.climbing.Climber;
import es.upm.miw.apaw_practice.domain.models.climbing.Expedition;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Document
public class ClimberEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String email;
    private LocalDate dateOfBirth;
    private String level;
    private List<ExpeditionEntity> expeditionEntities;

    public ClimberEntity() {
        //empty for framework
    }

    public ClimberEntity(String email, LocalDate dateOfBirth, String level, List<ExpeditionEntity> expeditionEntities) {
        this.id = UUID.randomUUID().toString();
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.level = level;
        this.expeditionEntities = expeditionEntities;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<ExpeditionEntity> getExpeditionEntities() {
        return expeditionEntities;
    }

    public void setExpeditionEntities(List<ExpeditionEntity> expeditionEntities) {
        this.expeditionEntities = expeditionEntities;
    }

    public Climber toClimber() {
        List<Expedition> expeditions = this.expeditionEntities.stream()
                .map(ExpeditionEntity::toExpedition)
                .toList();
        return new Climber(this.email, this.dateOfBirth, this.level, expeditions);
    }

    @Override
    public int hashCode() {
        return this.email.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (email.equals(((ClimberEntity) obj).email));
    }

    @Override
    public String toString() {
        return "ClimberEntity{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", level='" + level + '\'' +
                ", expeditionEntities=" + expeditionEntities +
                '}';
    }
}

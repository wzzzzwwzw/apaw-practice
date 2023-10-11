package es.upm.miw.apaw_practice.adapters.mongodb.olympic_games.entities;

import es.upm.miw.apaw_practice.domain.models.olympic_games.Competitor;
import es.upm.miw.apaw_practice.domain.models.olympic_games.Discipline;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Document
public class DisciplineEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private Integer numberOfCompetitions;
    private LocalDate additionDate;
    @DBRef
    private List<CompetitorEntity> competitorEntities;

    public DisciplineEntity() {
    }

    public DisciplineEntity(String name, Integer numberOfCompetitions, LocalDate additionDate, List<CompetitorEntity> competitorEntities) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.numberOfCompetitions = numberOfCompetitions;
        this.additionDate = additionDate;
        this.competitorEntities = competitorEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfCompetitions() {
        return numberOfCompetitions;
    }

    public void setNumberOfCompetitions(Integer numberOfCompetitions) {
        this.numberOfCompetitions = numberOfCompetitions;
    }

    public LocalDate getAdditionDate() {
        return additionDate;
    }

    public void setAdditionDate(LocalDate additionDate) {
        this.additionDate = additionDate;
    }

    public List<CompetitorEntity> getCompetitorEntities() {
        return competitorEntities;
    }

    public void setCompetitorEntities(List<CompetitorEntity> competitorEntities) {
        this.competitorEntities = competitorEntities;
    }

    public Discipline toDiscipline() {
        List<Competitor> competitors = this.competitorEntities.stream()
                .map(CompetitorEntity::toCompetitor)
                .toList();
        return new Discipline(name, numberOfCompetitions, additionDate, competitors);
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (name.equals(((DisciplineEntity) obj).name));

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "DisciplineEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", numberOfCompetitions=" + numberOfCompetitions +
                ", additionDate=" + additionDate +
                ", competitorEntities=" + competitorEntities +
                '}';
    }
}


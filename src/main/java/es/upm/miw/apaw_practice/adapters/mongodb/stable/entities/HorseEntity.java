package es.upm.miw.apaw_practice.adapters.mongodb.stable.entities;

import es.upm.miw.apaw_practice.domain.models.stable.Horse;
import es.upm.miw.apaw_practice.domain.models.stable.Keeper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Document
public class HorseEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private Integer age;
    private LocalDate birthDate;
    private String race;
    private Double health;
    private BigDecimal purchasePrice;
    private Boolean sold;
    private List<KeeperEntity> keeperEntities;
    private CareTaskEntity careTaskEntity;

    public HorseEntity() {
        //Empty for framework
    }

    public HorseEntity(String name, Integer age, LocalDate birthDate, String race, Double health, BigDecimal purchasePrice, Boolean sold, List<KeeperEntity> keeperEntities, CareTaskEntity careTaskEntity) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.race = race;
        this.health = health;
        this.purchasePrice = purchasePrice;
        this.sold = sold;
        this.keeperEntities = keeperEntities;
        this.careTaskEntity = careTaskEntity;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Double getHealth() {
        return health;
    }

    public void setHealth(Double health) {
        this.health = health;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Boolean getSold() {
        return sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }

    public List<KeeperEntity> getKeeperEntities() {
        return keeperEntities;
    }

    public void setKeeperEntities(List<KeeperEntity> keeperEntities) {
        this.keeperEntities = keeperEntities;
    }

    public CareTaskEntity getCareTaskEntity() {
        return careTaskEntity;
    }

    public void setCareTaskEntity(CareTaskEntity careTaskEntity) {
        this.careTaskEntity = careTaskEntity;
    }

    public Horse toHorse() {
        List<Keeper> keepers = this.keeperEntities.stream()
                .map(KeeperEntity::toKeeper)
                .collect(Collectors.toList());
        return new Horse(this.name, this.age, this.birthDate, this.race, this.health, this.purchasePrice, this.sold, keepers, this.careTaskEntity.toCareTask());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HorseEntity that = (HorseEntity) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "HorseEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", race='" + race + '\'' +
                ", health=" + health +
                ", purchasePrice=" + purchasePrice +
                ", sold=" + sold +
                ", keeperEntities=" + keeperEntities +
                ", careTaskEntity=" + careTaskEntity +
                '}';
    }
}

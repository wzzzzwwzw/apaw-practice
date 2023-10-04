package es.upm.miw.apaw_practice.adapters.mongodb.car_workshop.entities;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import es.upm.miw.apaw_practice.domain.models.car_workshop.OBDFault;

@Document
public class OBDFaultEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String code;
    private String description;
    private Boolean canPassITV;
    private String solution;

    public OBDFaultEntity() {
        // empty for framework
    }

    public OBDFaultEntity(OBDFault obdFault) {
        BeanUtils.copyProperties(obdFault, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCanPassITV() {
        return canPassITV;
    }

    public void setCanPassITV(Boolean canPassITV) {
        this.canPassITV = canPassITV;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public OBDFault toOBDFault() {
        OBDFault obdFault = new OBDFault();
        BeanUtils.copyProperties(this, obdFault);
        return obdFault;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OBDFaultEntity other = (OBDFaultEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "OBDFaultEntity [id=" + id + ", code=" + code + ", description=" + description + ", canPassITV="
                + canPassITV + ", solution=" + solution + "]";
    }

}

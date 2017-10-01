package com.tr.sigorta.domain;

import com.tr.nebula.persistence.jpa.domain.BaseEntity;

import javax.persistence.Entity;

/**
 * Created by Mustafa Erbin on 30/09/2017.
 * Sigorta şirketi.
 */
@Entity
public class Company extends BaseEntity {

    private String name;
    private Boolean status = true;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

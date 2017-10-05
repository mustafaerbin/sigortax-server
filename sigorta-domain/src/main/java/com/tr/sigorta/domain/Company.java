package com.tr.sigorta.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tr.nebula.persistence.jpa.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Mustafa Erbin on 30/09/2017.
 * Sigorta şirketi.
 */
@Entity
public class Company extends BaseEntity {

    @Id
    @Column
    @GeneratedValue
    @JsonProperty("value")
    private Long id;
    @JsonProperty("label")
    private String name;
    private Boolean status = true;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

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

package com.tr.sigorta.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tr.nebula.persistence.jpa.domain.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Mustafa Erbin on 30/09/2017.
 * Sigorta ürünleri
 */
@Entity
public class CompanyProduct extends BaseEntity {

    @Id
    @Column
    @GeneratedValue
    @JsonProperty("value")
    private Long id;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private Company company;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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

package com.tr.sigorta.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tr.nebula.persistence.jpa.domain.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Mustafa Erbin on 30/09/2017.
 * sigorta alt ürünleri.
 */
@Entity
public class CompanySubProduct extends BaseEntity {

    @Id
    @Column
    @GeneratedValue
    @JsonProperty("value")
    private Long id;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private CompanyProduct companyProduct;
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

    public CompanyProduct getCompanyProduct() {
        return companyProduct;
    }

    public void setCompanyProduct(CompanyProduct companyProduct) {
        this.companyProduct = companyProduct;
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

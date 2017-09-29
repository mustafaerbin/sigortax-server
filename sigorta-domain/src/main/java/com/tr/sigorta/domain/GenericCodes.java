package com.tr.sigorta.domain;

import com.tr.nebula.persistence.jpa.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Created by Mustafa Erbin on 16/09/2017.
 * Genel parametreler; sigorta tipi, sigorta yapan şirketler(axa sigorta gibi) vs..
 */
@Entity
public class GenericCodes extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    private Company company; // şirket
    private String name;
    private String code;
    private Boolean status; // 1 --> aktif, 0 --> pasif
    private ClassName className;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public ClassName getClassName() {
        return className;
    }

    public void setClassName(ClassName className) {
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}

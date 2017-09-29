package com.tr.sigorta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tr.nebula.persistence.jpa.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;


/**
 * Created by Mustafa Erbin on 16/09/2017.
 * Sigortacının müşterileri
 */
@Entity
public class Customer extends BaseEntity {

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private CompanyUser companyUser;
    private String name;
    private String surname;
    private Long tc;
    private String email;
    private Long mobilePhone;
    private String address;
    private String job;
    private Boolean status; // 1 --> aktif, 0 --> pasif

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public CompanyUser getCompanyUser() {
        return companyUser;
    }

    public void setCompanyUser(CompanyUser companyUser) {
        this.companyUser = companyUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getTc() {
        return tc;
    }

    public void setTc(Long tc) {
        this.tc = tc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(Long mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}

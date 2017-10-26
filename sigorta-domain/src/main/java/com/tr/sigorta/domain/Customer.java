package com.tr.sigorta.domain;

import com.tr.nebula.persistence.jpa.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


/**
 * Created by Mustafa Erbin on 16/09/2017.
 * Acentenin müşterileri
 */
@Entity
public class Customer extends BaseEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private AgencyUser agencyUser; // acente kullanıcısı
    private String name;
    private String surname;
    private Long tc;
    private String email;
    private Long mobilePhone;
    private String address;
    private String job;
    private Boolean status = true; // 1 --> aktif, 0 --> pasif
    private String description; // açıklama
    private Long agencyId;

    public Long getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Long agencyId) {
        this.agencyId = agencyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public AgencyUser getAgencyUser() {
        return agencyUser;
    }

    public void setAgencyUser(AgencyUser agencyUser) {
        this.agencyUser = agencyUser;
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

package com.tr.sigorta.domain;

import com.tr.nebula.persistence.jpa.domain.BaseEntity;
import com.tr.sigorta.domain.enumm.EnumCustomerType;

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
    private String name; // gerçek --> isim / tüzel --> ünvan
    private String surname; // soyisim / yetkili kişi
    private String tc; // tc / vergi no
    private String email; // email / email
    private String mobilePhone; // cep tel / cep tel
    private String jobPhone; // iş tel / iş tel
    private String job; // iş / faaliyet alanı
    private String address; // adres / adres
    private Boolean status = true; // 1 --> aktif, 0 --> pasif
    private String description; // açıklama / açıklama
    private Long agencyId;
    private EnumCustomerType enumCustomerType = EnumCustomerType.GERCEK; // müşteri tipi.

    public String getJobPhone() {
        return jobPhone;
    }

    public void setJobPhone(String jobPhone) {
        this.jobPhone = jobPhone;
    }

    public EnumCustomerType getEnumCustomerType() {
        return enumCustomerType;
    }

    public void setEnumCustomerType(EnumCustomerType enumCustomerType) {
        this.enumCustomerType = enumCustomerType;
    }

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

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
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

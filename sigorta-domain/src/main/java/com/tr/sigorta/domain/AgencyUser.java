package com.tr.sigorta.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tr.nebula.security.db.domain.User;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * Created by Mustafa Erbin on 16/09/2017.
 * Sigorta acentesi kullanıcısı.
 */
@Entity
public class AgencyUser extends User {

    public AgencyUser(Long userId) {
        super();
        this.setOid(userId);
    }

    public AgencyUser() {
        super();
    }

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agency")
    @JsonBackReference
    private Agency agency; // acentesi
    private String email;
    private Long mobilePhone;
    private Date endDate; // kullanım bitiş tarihi.
    private Boolean status = true; // 1 --> aktif, 0 --> pasif

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }
}

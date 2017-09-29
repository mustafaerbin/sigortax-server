package com.tr.sigorta.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tr.nebula.security.db.domain.User;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;


/**
 * Created by Mustafa Erbin on 16/09/2017.
 * Sigorta acentesi kullanıcıları.
 */
@Entity
public class CompanyUser extends User {

    public CompanyUser(Long userId) {
        super();
        this.setOid(userId);
    }

    public CompanyUser() {
        super();
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company")
    @JsonBackReference
    private Company company;
    private String email;
    private Long mobilePhone;
    private Date endDate; // kullanım bitiş tarihi.

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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}

package com.tr.sigorta.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tr.nebula.persistence.jpa.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Mustafa Erbin on 16/09/2017.
 * Geçmiş policeler.
 */
@Entity
public class PolicyOld extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    private AgencyUser agencyUser; // acente kullanıcısı
    private String customer; // acente müşterisi
    private String company;
    private String companyProduct;
    private String companySubProduct;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+0300")
    private Date startDate; // poliçe başlangıç tarihi
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+0300")
    private Date endDate; // poliçe bitiş tarihi
    private String description; // açıklama
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+0300")
    private Date reminderDate; // hatırlatma tarihi; mesajın veya mailin gönderileceği tarih.
    private String userMessage; // kullaniciya gidecek mesaj.
    private String customerMessage; // müşteriye gidecek mesaj.
    private String policyNumber; // poliçe numarası.
    private BigDecimal policyEmount; // poliçe tutarı.
    private Long agencyId; // sigorta şirketi id'si (acente admini bütün kullanıcıların kestiği poliçeleri görebilmesi için eklendi.)
    @Transient
    private String agencyUserFullName;

    public String getAgencyUserFullName() {
        return agencyUser.getName() + " " + agencyUser.getSurname();
    }

    public AgencyUser getAgencyUser() {
        return agencyUser;
    }

    public void setAgencyUser(AgencyUser agencyUser) {
        this.agencyUser = agencyUser;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyProduct() {
        return companyProduct;
    }

    public void setCompanyProduct(String companyProduct) {
        this.companyProduct = companyProduct;
    }

    public String getCompanySubProduct() {
        return companySubProduct;
    }

    public void setCompanySubProduct(String companySubProduct) {
        this.companySubProduct = companySubProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(Date reminderDate) {
        this.reminderDate = reminderDate;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getCustomerMessage() {
        return customerMessage;
    }

    public void setCustomerMessage(String customerMessage) {
        this.customerMessage = customerMessage;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public BigDecimal getPolicyEmount() {
        return policyEmount;
    }

    public void setPolicyEmount(BigDecimal policyEmount) {
        this.policyEmount = policyEmount;
    }

    public Long getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Long agencyId) {
        this.agencyId = agencyId;
    }
}

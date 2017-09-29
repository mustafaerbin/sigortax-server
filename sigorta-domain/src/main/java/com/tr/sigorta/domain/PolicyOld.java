package com.tr.sigorta.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tr.nebula.persistence.jpa.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Mustafa Erbin on 16/09/2017.
 * Geçmiş policeler.
 */
@Entity
public class PolicyOld extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    private CompanyUser companyUser; // şirket kullanıcısı
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer; // şirket müşterisi
    @ManyToOne(fetch = FetchType.EAGER)
    private GenericCodes policyType; // sigorta poliçesi tipi; sağlık, trafik vs..
    @ManyToOne(fetch = FetchType.EAGER)
    private GenericCodes policyCompany; // sigorta şirketi; axa, ak, demir hayat vs..
    private Date startDate; // poliçe başlangıç tarihi
    private Date endDate; // poliçe bitiş tarihi
    private String description; // açıklama
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "EET")
    private Date reminderDate; // hatırlatma tarihi; mesajın veya mailin gönderileceği tarih.
    private String userMessage; // kullaniciya gidecek mesaj.
    private String customerMessage; // müşteriye gidecek mesaj.
    private String policyNumber; // poliçe numarası.
    private BigDecimal policyEmount; // poliçe tutarı.
    private Long companyId; // şirket id'si

    public CompanyUser getCompanyUser() {
        return companyUser;
    }

    public void setCompanyUser(CompanyUser companyUser) {
        this.companyUser = companyUser;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public GenericCodes getPolicyType() {
        return policyType;
    }

    public void setPolicyType(GenericCodes policyType) {
        this.policyType = policyType;
    }

    public GenericCodes getPolicyCompany() {
        return policyCompany;
    }

    public void setPolicyCompany(GenericCodes policyCompany) {
        this.policyCompany = policyCompany;
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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

}

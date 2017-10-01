package com.tr.sigorta.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tr.nebula.persistence.jpa.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Mustafa Erbin on 16/09/2017.
 * Geçmiş policeler.
 */
@Entity
public class PolicyOld extends BaseEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private AgencyUser agencyUser; // acente kullanıcısı
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer; // acente müşterisi
    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;
    @ManyToOne(fetch = FetchType.EAGER)
    private CompanyProduct companyProduct;
    @ManyToOne(fetch = FetchType.EAGER)
    private CompanySubProduct companySubProduct;
    private Date startDate; // poliçe başlangıç tarihi
    private Date endDate; // poliçe bitiş tarihi
    private String description; // açıklama
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "EET")
    private Date reminderDate; // hatırlatma tarihi; mesajın veya mailin gönderileceği tarih.
    private String userMessage; // kullaniciya gidecek mesaj.
    private String customerMessage; // müşteriye gidecek mesaj.
    private String policyNumber; // poliçe numarası.
    private BigDecimal policyEmount; // poliçe tutarı.
    private Long agencyId; // sigorta şirketi id'si (acente admini bütün kullanıcıların kestiği poliçeleri görebilmesi için eklendi.)

    public AgencyUser getAgencyUser() {
        return agencyUser;
    }

    public void setAgencyUser(AgencyUser agencyUser) {
        this.agencyUser = agencyUser;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public CompanyProduct getCompanyProduct() {
        return companyProduct;
    }

    public void setCompanyProduct(CompanyProduct companyProduct) {
        this.companyProduct = companyProduct;
    }

    public CompanySubProduct getCompanySubProduct() {
        return companySubProduct;
    }

    public void setCompanySubProduct(CompanySubProduct companySubProduct) {
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

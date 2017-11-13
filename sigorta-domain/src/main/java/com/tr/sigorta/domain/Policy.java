package com.tr.sigorta.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tr.nebula.persistence.jpa.domain.BaseEntity;
import com.tr.sigorta.domain.enumm.EnumPolicyState;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Mustafa Erbin on 16/09/2017.
 * Müşteriye kesilen sigorta poliçesi.
 */
@Entity
public class Policy extends BaseEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private AgencyUser agencyUser; // acente kullanıcısı
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer; // acente müşterisi
    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;
    @ManyToOne(fetch = FetchType.EAGER)
    private CompanyPolicyType companyPolicyType;
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
    private EnumPolicyState enumPolicyState = EnumPolicyState.YENILENMEDI;
    private String vehiclePlate; // taşıt plakası.
    private String registryNumber; // tescil belge no.

    @Transient
    private String agencyUserFullName;
    @Transient
    private String customerFullName;


    public String getRegistryNumber() {
        return registryNumber;
    }

    public void setRegistryNumber(String registryNumber) {
        this.registryNumber = registryNumber;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public EnumPolicyState getEnumPolicyState() {
        return enumPolicyState;
    }

    public void setEnumPolicyState(EnumPolicyState enumPolicyState) {
        this.enumPolicyState = enumPolicyState;
    }

    public String getCustomerFullName() {
        return customer.getName() + " " + customer.getSurname();
    }

    public String getAgencyUserFullName() {
        return agencyUser.getName() + " " + agencyUser.getSurname();
    }

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

    public CompanyPolicyType getCompanyPolicyType() {
        return companyPolicyType;
    }

    public void setCompanyPolicyType(CompanyPolicyType companyPolicyType) {
        this.companyPolicyType = companyPolicyType;
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

package com.sales.swiftsalescrm.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Prospect {

    private Long id;
    private CompanyInfo companyInfo;
    private ContactInfo contactInfo;
    //private CompanyType companyType;
    private Set<CompanyDocs> companyDocs = new HashSet<>();
    private CompanyStatus companyStatus;
    private Leads leads;
    private Customer customer;
    private String currentSupplier;
    private String monthlyVolume;
    private LocalDateTime createdDate;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @CreationTimestamp
    @Column(updatable = false)
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_info_id", referencedColumnName = "id")
    public CompanyInfo getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(CompanyInfo companyInfo) {
        this.companyInfo = companyInfo;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_info_id", referencedColumnName = "id")
    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

/*

    *Made company type a string
    @OneToOne
    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }
 */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "prospect")
    public Set<CompanyDocs> getCompanyDocs() {
        return companyDocs;
    }

    public void setCompanyDocs(Set<CompanyDocs> companyDocs) {
        this.companyDocs = companyDocs;
    }

    @OneToOne
    public CompanyStatus getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(CompanyStatus companyStatus) {
        this.companyStatus = companyStatus;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "prospect")
    public Leads getLeads() {
        return leads;
    }

    public void setLeads(Leads leads) {
        this.leads = leads;
    }

    @OneToOne
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCurrentSupplier() {
        return currentSupplier;
    }

    public void setCurrentSupplier(String currentSupplier) {
        this.currentSupplier = currentSupplier;
    }

    public String getMonthlyVolume() {
        return monthlyVolume;
    }

    public void setMonthlyVolume(String monthlyVolume) {
        this.monthlyVolume = monthlyVolume;
    }
}

package com.sales.swiftsalescrm.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class CourierCompany {

    private Long id;
    private CompanyInfo companyInfo;
    private Set<ContactInfo> contactInfo = new HashSet<>();
    private CompanyType companyType;
    private Set<CompanyDocs> companyDocs = new HashSet<>();
    private Set<CourierService> courierService = new HashSet<>();
    private Set<ParcelTransactions> parcelTransactions = new HashSet<>();
    private Set<Finance> finance = new HashSet<>();
    private Customer customer;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne
    public CompanyInfo getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(CompanyInfo companyInfo) {
        this.companyInfo = companyInfo;
    }


    @OneToMany
    public Set<ContactInfo> getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(Set<ContactInfo> contactInfo) {
        this.contactInfo = contactInfo;
    }

    @OneToOne
    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    @OneToMany
    public Set<CompanyDocs> getCompanyDocs() {
        return companyDocs;
    }

    public void setCompanyDocs(Set<CompanyDocs> companyDocs) {
        this.companyDocs = companyDocs;
    }

    @ManyToMany
    public Set<CourierService> getCourierService() {
        return courierService;
    }

    public void setCourierService(Set<CourierService> courierService) {
        this.courierService = courierService;
    }

    @ManyToMany
    public Set<ParcelTransactions> getParcelTransactions() {
        return parcelTransactions;
    }

    public void setParcelTransactions(Set<ParcelTransactions> parcelTransactions) {
        this.parcelTransactions = parcelTransactions;
    }

    @ManyToMany
    public Set<Finance> getFinance() {
        return finance;
    }

    public void setFinance(Set<Finance> finance) {
        this.finance = finance;
    }

    @ManyToOne
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

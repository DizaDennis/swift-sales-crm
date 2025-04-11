package com.sales.swiftsalescrm.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {

    private Long id;
    private LocalDateTime createdDate;
    //private CompanyType companyType;
    private Set<CompanyDocs> companyDocs = new HashSet<>();
    private ContactInfo contactInfo;
    private CompanyInfo companyInfo;
    private CompanyStatus companyStatus;
    private Prospect prospect;
    private Set<ParcelTransactions> parcelTransactions = new HashSet<>();
    private Set<Finance> finance = new HashSet<>();
    private Set<CourierCompany> courierCompany = new HashSet<>();
    private Set<CourierService> courierService = new HashSet<>();
    private ServiceName serviceName;


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

    /*

    Made company type a string in companyInfo
    @OneToOne
    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }


     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
    public Set<CompanyDocs> getCompanyDocs() {
        return companyDocs;
    }

    public void setCompanyDocs(Set<CompanyDocs> companyDocs) {
        this.companyDocs = companyDocs;
    }

    @OneToOne(cascade = CascadeType.ALL)
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

    @OneToOne
    public CompanyStatus getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(CompanyStatus companyStatus) {
        this.companyStatus = companyStatus;
    }

    @OneToOne
    public Prospect getProspect() {
        return prospect;
    }

    public void setProspect(Prospect prospect) {
        this.prospect = prospect;
    }

    @OneToMany(mappedBy = "customer")
    public Set<ParcelTransactions> getParcelTransactions() {
        return parcelTransactions;
    }

    public void setParcelTransactions(Set<ParcelTransactions> parcelTransactions) {
        this.parcelTransactions = parcelTransactions;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
    public Set<Finance> getFinance() {
        return finance;
    }

    public void setFinance(Set<Finance> finance) {
        this.finance = finance;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
    public Set<CourierCompany> getCourierCompany() {
        return courierCompany;
    }

    public void setCourierCompany(Set<CourierCompany> courierCompany) {
        this.courierCompany = courierCompany;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
    public Set<CourierService> getCourierService() {
        return courierService;
    }

    public void setCourierService(Set<CourierService> courierService) {
        this.courierService = courierService;
    }


    @Enumerated(EnumType.STRING)
    public ServiceName getServiceName() {
        return serviceName;
    }

    public void setServiceName(ServiceName serviceName) {
        this.serviceName = serviceName;
    }
}

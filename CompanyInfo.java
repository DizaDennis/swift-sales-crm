package com.sales.swiftsalescrm.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class CompanyInfo {

    private Long id;
    private String companyName;
    private String companyAddress;
    private String industry;
    private String website;
    private Set<ContactInfo> contactInfo = new HashSet<>();
    private String companyTypes;
    private Set<CompanyDocs> companyDocs = new HashSet<>();
    private CompanyStatus companyStatus;
    private Leads leads;
    private Prospect prospect;
    private CourierCompany courierCompany;
    private Customer customer;
    private String notes;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "companyInfo")
    public Set<ContactInfo> getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(Set<ContactInfo> contactInfo) {
        this.contactInfo = contactInfo;
    }

   // @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "companyInfo")
    public String getCompanyTypes() {
        return companyTypes;
    }

    public void setCompanyTypes(String companyTypes) {
        this.companyTypes = companyTypes;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "companyInfo")
    public Set<CompanyDocs> getCompanyDocs() {
        return companyDocs;
    }

    public void setCompanyDocs(Set<CompanyDocs> companyDocs) {
        this.companyDocs = companyDocs;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "companyInfo")
    public CompanyStatus getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(CompanyStatus companyStatus) {
        this.companyStatus = companyStatus;
    }

    //Inverse side of the 1:1 relationship with Leads
    @OneToOne(mappedBy = "companyInfo")
    public Leads getLeads() {
        return leads;
    }

    public void setLeads(Leads leads) {
        this.leads = leads;
    }

    @OneToOne(mappedBy = "companyInfo")
    public Prospect getProspect() {
        return prospect;
    }

    public void setProspect(Prospect prospect) {
        this.prospect = prospect;
    }

    @OneToOne
    public CourierCompany getCourierCompany() {
        return courierCompany;
    }

    public void setCourierCompany(CourierCompany courierCompany) {
        this.courierCompany = courierCompany;
    }

    @OneToOne(mappedBy = "companyInfo")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "CompanyInfo{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", industry='" + industry + '\'' +
                ", website='" + website + '\'' +
                ", contactInfo=" + contactInfo +
                ", companyDocs=" + companyDocs +
                ", companyStatus=" + companyStatus +
                ", leads=" + leads +
                ", prospect=" + prospect +
                ", courierCompany=" + courierCompany +
                ", customer=" + customer +
                ", notes='" + notes + '\'' +
                '}';
    }
}

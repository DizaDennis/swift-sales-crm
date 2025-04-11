package com.sales.swiftsalescrm.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.engine.internal.Cascade;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Leads entity that leverages CompanyInfo and ContactInfo fields to store values
 * Main issue in the beginning was around "mappedBy" - to show the correct owner of the relationship
 * @author dennisdiza
 */

@Entity
@Table(name = "Leads")
public class Leads {

    private Long id;

    private CompanyInfo companyInfo;
    private ContactInfo contactInfo;
    private Prospect prospect;
    //private CompanyType companyType;
    private LocalDateTime createdDate; //variable to assist with ordering

    private boolean converted; // this will help with moving the lead to a prospect


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
    Leads owns the relationship with CompanyInfo
    "mappedBy" - required on the companyInfo side
     */
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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "prospect_id", referencedColumnName = "id")
    public Prospect getProspect() {
        return prospect;
    }

    public void setProspect(Prospect prospect) {
        this.prospect = prospect;
    }
/*
    *Made company type a string in companyInfo
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "leads")
    @JoinColumn(name = "company_type_id", referencedColumnName = "id")
    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }


 */
    public boolean isConverted() {
        return converted;
    }

    public void setConverted(boolean converted) {
        this.converted = converted;
    }

    @Override
    public String toString() {
        return "Leads{" +
                "id=" + id +
                ", companyInfo=" + companyInfo +
                ", contactInfo=" + contactInfo +
                ", prospect=" + prospect +

                '}';
    }
}

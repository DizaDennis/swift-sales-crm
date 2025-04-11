package com.sales.swiftsalescrm.entities;

import jakarta.persistence.*;

@Entity
public class CompanyStatus {

    private Long id;
    private String statusName;
    private CompanyInfo companyInfo;
    private Leads leads;
    private Prospect prospect;
    private Customer customer;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @OneToOne
    public CompanyInfo getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(CompanyInfo companyInfo) {
        this.companyInfo = companyInfo;
    }

    @OneToOne
    public Leads getLeads() {
        return leads;
    }

    public void setLeads(Leads leads) {
        this.leads = leads;
    }

    @OneToOne
    public Prospect getProspect() {
        return prospect;
    }

    public void setProspect(Prospect prospect) {
        this.prospect = prospect;
    }

    @OneToOne
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

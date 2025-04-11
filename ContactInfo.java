package com.sales.swiftsalescrm.entities;

import jakarta.persistence.*;



@Entity
public class ContactInfo {

    private Long id;
    private String companyNumber;
    private String email;
    private String contactPerson;
    private String decisionMaker;
    private String contactPersonPosition;
    private CompanyInfo companyInfo;
    private Leads leads;
    private Prospect prospect;
    private Customer customer;
    private CourierCompany courierCompany;
    private User user;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(String decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public String getContactPersonPosition() {
        return contactPersonPosition;
    }

    public void setContactPersonPosition(String contactPersonPosition) {
        this.contactPersonPosition = contactPersonPosition;
    }

    @ManyToOne
    @JoinColumn(name="company_info_id", referencedColumnName = "id")
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

    @ManyToOne
    public CourierCompany getCourierCompany() {
        return courierCompany;
    }

    public void setCourierCompany(CourierCompany courierCompany) {
        this.courierCompany = courierCompany;
    }

    @OneToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "id=" + id +
                ", companyNumber='" + companyNumber + '\'' +
                ", email='" + email + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", decisionMaker='" + decisionMaker + '\'' +
                ", contactPersonPosition='" + contactPersonPosition + '\'' +
                ", companyInfo=" + companyInfo +
                ", leads=" + leads +
                ", prospect=" + prospect +
                ", customer=" + customer +
                ", courierCompany=" + courierCompany +
                ", user=" + user +
                '}';
    }
}

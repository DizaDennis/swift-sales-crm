package com.sales.swiftsalescrm.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Finance {

    private Long id;
    private Double invoiceValue;
    private Double statementValue;
    private Set<ParcelTransactions> parcelTransactions = new HashSet<>();
    private Set<Customer> customer = new HashSet<>();
    private Set <CourierCompany> courierCompany = new HashSet<>();


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getInvoiceValue() {
        return invoiceValue;
    }

    public void setInvoiceValue(Double invoiceValue) {
        this.invoiceValue = invoiceValue;
    }

    public Double getStatementValue() {
        return statementValue;
    }

    public void setStatementValue(Double statementValue) {
        this.statementValue = statementValue;
    }

    @ManyToMany
    public Set<ParcelTransactions> getParcelTransactions() {
        return parcelTransactions;
    }

    public void setParcelTransactions(Set<ParcelTransactions> parcelTransactions) {
        this.parcelTransactions = parcelTransactions;
    }

    @ManyToMany
    public Set<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Set<Customer> customer) {
        this.customer = customer;
    }


    @ManyToMany
    public Set<CourierCompany> getCourierCompany() {
        return courierCompany;
    }

    public void setCourierCompany(Set<CourierCompany> courierCompany) {
        this.courierCompany = courierCompany;
    }
}

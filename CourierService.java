package com.sales.swiftsalescrm.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class CourierService {

    private Long id;
    private ServiceName serviceName;
    private Set <CourierCompany> courierCompany = new HashSet<>();
    private ParcelTransactions parcelTransactions;
    private Set<Customer> customer = new HashSet<>();



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    public ServiceName getServiceName() {
        return serviceName;
    }

    public void setServiceName(ServiceName serviceName) {
        this.serviceName = serviceName;
    }

    @ManyToMany
    public Set<CourierCompany> getCourierCompany() {
        return courierCompany;
    }

    public void setCourierCompany(Set<CourierCompany> courierCompany) {
        this.courierCompany = courierCompany;
    }

    @OneToOne
    public ParcelTransactions getParcelTransactions() {
        return parcelTransactions;
    }

    public void setParcelTransactions(ParcelTransactions parcelTransactions) {
        this.parcelTransactions = parcelTransactions;
    }

    @ManyToMany
    public Set<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Set<Customer> customer) {
        this.customer = customer;
    }


}

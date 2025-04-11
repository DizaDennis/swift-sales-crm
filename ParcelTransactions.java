package com.sales.swiftsalescrm.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class ParcelTransactions {

    private Long id;
    private Set <CourierService> courierService = new HashSet <> ();
    private Double costOfShipment;
    private Customer customer;
    private Set <CourierCompany> courierCompany = new HashSet<>();
    private Integer numberOfParcels;
    private Set<Finance> finance = new HashSet<>();


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToMany
    public Set<CourierService> getCourierService() {
        return courierService;
    }

    public void setCourierService(Set<CourierService> courierService) {
        this.courierService = courierService;
    }


    public Double getCostOfShipment() {
        return costOfShipment;
    }

    public void setCostOfShipment(Double costOfShipment) {
        this.costOfShipment = costOfShipment;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToMany
    public Set<CourierCompany> getCourierCompany() {
        return courierCompany;
    }

    public void setCourierCompany(Set<CourierCompany> courierCompany) {
        this.courierCompany = courierCompany;
    }


    public Integer getNumberOfParcels() {
        return numberOfParcels;
    }

    public void setNumberOfParcels(Integer numberOfParcels) {
        this.numberOfParcels = numberOfParcels;
    }

    @ManyToMany
    public Set<Finance> getFinance() {
        return finance;
    }

    public void setFinance(Set<Finance> finance) {
        this.finance = finance;
    }
}

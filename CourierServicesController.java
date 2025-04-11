package com.sales.swiftsalescrm.controllers;


import com.sales.swiftsalescrm.entities.CourierService;
import com.sales.swiftsalescrm.entities.ParcelTransactions;
import com.sales.swiftsalescrm.service.CustomerService;
import com.sales.swiftsalescrm.service.ParcelTransactionsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/services")
public class CourierServicesController {

    private CustomerService customerService;
    private CourierService courierService;
    private ParcelTransactionsService parcelTransactionsService;

    public CourierServicesController(CustomerService theCustomerService) {
        this.customerService = theCustomerService;

    }


}

package com.sales.swiftsalescrm.controllers;

import com.sales.swiftsalescrm.entities.CourierService;
import com.sales.swiftsalescrm.entities.Customer;
import com.sales.swiftsalescrm.entities.ParcelTransactions;
import com.sales.swiftsalescrm.service.CourierServiceService;
import com.sales.swiftsalescrm.service.CustomerService;
import com.sales.swiftsalescrm.service.ParcelTransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/parcels")
public class ParcelTransactionsController {

    private CourierServiceService courierServiceService;
    private CustomerService customerService;
    private ParcelTransactionsService parcelTransactionsService;

    @Autowired
    public ParcelTransactionsController(CourierServiceService theCourierServiceService, CustomerService theCustomerService,
                                        ParcelTransactionsService theParcelTransactionsService){

        this.courierServiceService = theCourierServiceService;
        this.customerService = theCustomerService;
        this.parcelTransactionsService = theParcelTransactionsService;
    }

    @GetMapping("/list")
    public String listParcelTransactions(Model theModel){

        List<ParcelTransactions> theParcelTransactions = parcelTransactionsService.findAll();

        theModel.addAttribute("parcelTransactions", theParcelTransactions);

        return "listParcelTransactions";//still need to create this view

    }

    @GetMapping("/addService")
    public String addService(@RequestParam("customerId")Long theId, Model theModel){

        Customer theCustomer = customerService.findById(theId);
        ParcelTransactions theParcelTransactions = new ParcelTransactions();

        CourierService theCourierService = new CourierService();


        theModel.addAttribute("courierService", theCourierService);
        theModel.addAttribute("parcelTransactions", theParcelTransactions);


        return "operations/parcelTransactions"; //still to create view

    }

    @GetMapping("/update")
    public String updateParcelTransactions(@RequestParam("parcelTransactionId") Long theId, Model theModel){

        ParcelTransactions theParcelTransactions = parcelTransactionsService.findById(theId);

        theModel.addAttribute("parcelTransactions", theParcelTransactions);

        return "operations/parcelTransactions";


    }

    @PostMapping("/save")
    public String saveParcelTransactions(@ModelAttribute("parcelTransactions") ParcelTransactions theParcelTransactions){

        parcelTransactionsService.save(theParcelTransactions);

        return "redirect:/customers/list";
    }


}

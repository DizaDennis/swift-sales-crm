package com.sales.swiftsalescrm.controllers;

import com.sales.swiftsalescrm.entities.*;
import com.sales.swiftsalescrm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;
    private ProspectsService prospectsService;
    private CompanyInfoService companyInfoService;
    private ContactInfoService contactInfoService;
    private CourierServiceService courierService;
    private ParcelTransactionsService parcelTransactionsService;

    @Autowired
    public CustomerController(CustomerService theCustomerService, ProspectsService theProspectsService,
                              ContactInfoService theContactInfoService, CompanyInfoService theCompanyInfoService, ParcelTransactionsService theParcelTransactionsService) {

        this.prospectsService = theProspectsService;
        this.customerService = theCustomerService;
        this.companyInfoService = theCompanyInfoService;
        this.contactInfoService = theContactInfoService;
        this.parcelTransactionsService = theParcelTransactionsService;
    }

    @GetMapping("/list")
    public String listCustomers(Model theModel) {

        List<Customer> theCustomer = customerService.findAll();

        theModel.addAttribute("customers", theCustomer);

        return "customers/customer-list";
    }

    @GetMapping("/convert")
    public String convert(@RequestParam("prospectId") Long theId, Model theModel) {

        Prospect theProspect = prospectsService.findById(theId);

        theModel.addAttribute("customers", theProspect);

        Customer theCustomer;
        if (theProspect.getCustomer() != null) {
            theCustomer = theProspect.getCustomer();
        } else {
            theCustomer = new Customer();
            theCustomer.setProspect(theProspect);
        }


        return "customers/addCustomer-form";

    }

    @GetMapping("/addCustomer")
    public String addCustomer(Model theModel) {

        //Creating the model attribute that will be used to bind the data
        Customer theCustomer = new Customer();

        theModel.addAttribute("customers", theCustomer);

        return "customers/addCustomer-form";

    }


    @GetMapping("/update")
    public String updateCustomer(@RequestParam("customerId") Long theId, Model theModel) {

        Customer theCustomer = customerService.findById(theId);

        theModel.addAttribute("customers", theCustomer);

        return "customers/addCustomer-form";

    }

    @GetMapping("/view")
    public String viewCustomer(@RequestParam("customerId") Long theId, Model theModel) {

        Customer theCustomer = customerService.findById(theId);
        theModel.addAttribute("customers", theCustomer);

        return "customers/viewCustomer";

    }


    @PostMapping("/save")
    public String save(@ModelAttribute("customers") Customer theCustomer) {


        customerService.save(theCustomer);
        return "redirect:/customers/list";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") Long theId) {

        customerService.delete(theId);

        return "redirect:/customers/list";

    }


    @GetMapping("/addService")
    public String addService(Model theModel){

        ParcelTransactions theParcelTransactions = new ParcelTransactions();

        CourierService theCourierService = new CourierService();


        theModel.addAttribute("courierService", theCourierService);
        theModel.addAttribute("parcelTransactions", theParcelTransactions);


        return "operations/parcelTransactions"; //still to create view

    }



}

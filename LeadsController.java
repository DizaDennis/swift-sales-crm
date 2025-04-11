package com.sales.swiftsalescrm.controllers;

import com.sales.swiftsalescrm.entities.CompanyInfo;
import com.sales.swiftsalescrm.entities.ContactInfo;
import com.sales.swiftsalescrm.entities.Leads;
import com.sales.swiftsalescrm.service.LeadsService;
import com.sales.swiftsalescrm.service.ProspectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Standard Leads controller, managing all communication regarding leads
 * Defines all endpoints available to the customer/user
 * @author dennisdiza
 */



@Controller
@RequestMapping("/leads")
public class LeadsController {

    /*
    Controller communication done with the service class to access the repo/data
    Any unit that we communicate with must be brought in and added to the constructor in order to access it
     */
    private LeadsService leadsService;
    private ProspectsService prospectsService;

    //Autowire annotation option with 1 element in the constructor
    @Autowired
    public LeadsController(LeadsService theLeadsService, ProspectsService theProspectsService){

        prospectsService = theProspectsService;
        leadsService = theLeadsService;

    }

    @GetMapping("/list")
    public String listLeads(Model theModel){

        //Accessing the 'findAll' query defined in the service class
        List<Leads> theLeads = leadsService.findAllUnconvertedLeads();


        //Model supplies attribute for rendering views - binds data for the view
        //'leads' is the object referenced using thymeleaf
        //theLeads is the variable holding the value/data
        theModel.addAttribute("leads", theLeads);

        return "leads/lead-list";
    }

    @GetMapping("/newLeadForm")
    public String newLeadForm(Model theModel){

        //First creating a Leads object assign the attribute value to
        Leads theLeads = new Leads();

        //'theLeads' is the param that holds the 'leads' value passed as an argument via the view
        theModel.addAttribute("leads", theLeads); //Binding the value passed with the object created

        return "leads/addLead-form";
    }

    /*
    Id is required in order to know which object in the DB is being edited
     */
    @GetMapping("/updateLead/{leadId}")
    public String updateLead(@PathVariable("leadId") Long theId, Model theModel){

        Leads theLeads = leadsService.findById(theId);

        theModel.addAttribute("leads", theLeads);

        return "leads/addLead-form";

    }



    //@ModelAttribute takes in data from the specific field in the view
    @PostMapping("/save")
    public String saveLead(@ModelAttribute("leads") Leads theLeads){

        System.out.println(theLeads);

        leadsService.save(theLeads);

        //Redirects to the list view once saved
        return "redirect:/leads/list";
    }


    /*
    @RequestParam extracts params from the request the is made and binds it to the method
    Binding 'leadId' to the 'delete' method defined in the service class
     */

    @GetMapping("/delete")
    public String delete(@RequestParam("leadId") Long theId, Model theModel){

        leadsService.deleteById(theId);

        return "redirect:/leads/list";

    }


}

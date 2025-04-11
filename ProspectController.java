package com.sales.swiftsalescrm.controllers;


import com.sales.swiftsalescrm.entities.CompanyInfo;
import com.sales.swiftsalescrm.entities.Leads;
import com.sales.swiftsalescrm.entities.Prospect;
import com.sales.swiftsalescrm.service.CompanyInfoService;
import com.sales.swiftsalescrm.service.LeadsService;
import com.sales.swiftsalescrm.service.ProspectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/prospects")
public class ProspectController {

    private ProspectsService prospectService;
    private LeadsService leadsService;
    private CompanyInfoService companyInfoService;



    @Autowired
    public ProspectController(ProspectsService theProspectService, LeadsService theLeadsService, CompanyInfoService theCompanyInfoService){

        leadsService = theLeadsService;
        prospectService = theProspectService;
        companyInfoService = theCompanyInfoService;
    }

    @GetMapping("/list")
    public String listProspects(Model theModel){

        List<Prospect> theProspects = prospectService.findAll();

        theModel.addAttribute("prospects", theProspects);

        return "prospects/prospect-list";

    }




    @GetMapping("/showAddForm")
    public String showAddForm(Model theModel){

        //Creating the model attribute that will be used to bind the data
        Prospect theProspect = new Prospect();

        theModel.addAttribute("prospects", theProspect);

        return "prospects/addProspect-form";


    }

    @GetMapping("/updateProspect")
    public String updateProspect(@RequestParam("prospectId") Long theId, Model theModel){

        Prospect theProspect = prospectService.findById(theId);

        theModel.addAttribute("prospects", theProspect);

        return "prospects/addProspect-form";

    }

    @GetMapping("/qualifiedLead")
    public String qualifiedLead(@RequestParam("leadId")Long theId, Model theModel){

        Leads theLeads = leadsService.findById(theId);

        theModel.addAttribute("prospects",theLeads);

        Prospect theProspect;
        if (theLeads.getProspect() != null) {
            theProspect = theLeads.getProspect();
        } else {
            theProspect = new Prospect();
            theProspect.setLeads(theLeads);

            // Pre-populate the prospect with the lead's information
            theLeads.getCompanyInfo().getCompanyName();
            theLeads.getCompanyInfo().getIndustry();
            theLeads.getCompanyInfo().getWebsite();
        }

        // Add the prospect to the model
        theModel.addAttribute("prospects", theProspect);

        return "prospects/addProspect-form";

    }







    /*
    TODO: Ensure that the lead id / prospect id attributes update accordingly
    Convert
     */

    @PostMapping("/save")
    public String saveProspect(@ModelAttribute("prospects") Prospect theProspect){


        //Method to save the prospect
        prospectService.save(theProspect);

        return "redirect:/prospects/list";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("prospectId") Long theId){

        prospectService.deleteById(theId);

        return "redirect:/prospects/list";
    }

}

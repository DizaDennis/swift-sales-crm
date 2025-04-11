package com.sales.swiftsalescrm.controllers;

import com.sales.swiftsalescrm.entities.Customer;
import com.sales.swiftsalescrm.entities.Leads;
import com.sales.swiftsalescrm.entities.Prospect;
import com.sales.swiftsalescrm.service.CustomerService;
import com.sales.swiftsalescrm.service.DataService;
import com.sales.swiftsalescrm.service.LeadsService;
import com.sales.swiftsalescrm.service.ProspectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/***
 * Controller class to manage everything on the landing page
 * Currently access by all (the only user)
 * View will need to be managed for different user roles
 */



@Controller
public class DashboardController {


    @Autowired
    private DataService dataService;
    private CustomerService customerService;
    private ProspectsService prospectsService;
    private LeadsService leadsService;

    //Autowire needed when injecting multiple services
    @Autowired
    public DashboardController(DataService theDataService, CustomerService theCustomerService, ProspectsService theProspectsService, LeadsService theLeadsService){
        dataService = theDataService;
        customerService = theCustomerService;
        prospectsService = theProspectsService;
        leadsService = theLeadsService;
    }

    @GetMapping("/index") //testing the falcon template
    public String index(){
        return "index";
    }



    @GetMapping("/")
    public String rootView(){
        return "dashboard2";
    }


    /*
    Method below is pulling all the data needed for the cards.
    SQL queries defined specifically in each service/repo
     */
    @GetMapping("/dashboard")
    public String dashboard(Model theModel) {

        long theCustomerCount = dataService.getCustomerCount();
        long theProspectCount = dataService.getProspectCount();
        long theLeadCount = dataService.getLeadCount();
        List<Prospect> theProspect = prospectsService.findTop5RecentProspects();
        List<Leads>theLeads = leadsService.findTop10RecentLeads();
        List<Customer>theCustomer = customerService.findTop5NewCustomers();


        theModel.addAttribute("customerCount", theCustomerCount);
        theModel.addAttribute("prospectCount", theProspectCount);
        theModel.addAttribute("customers", theCustomer);
        theModel.addAttribute("leadCount", theLeadCount);
        theModel.addAttribute("prospects", theProspect);
        theModel.addAttribute("leads",theLeads);


        return "dashboard";
    }

    /*
    Data required for the graph
    Working off similar values (counts) as the cards in the methods above
     */
    @GetMapping("/data")
    @ResponseBody
    public Map<String, Object> getData(){
        Map<String, Object> response = new HashMap<>();

        response.put("categories", List.of("Total"));
        response.put("leads",List.of(leadsService.getLeadsCount()));
        response.put("prospects",List.of(prospectsService.getProspectCount()));
        response.put("customers",List.of(customerService.getCustomerCount()));

        return response;

    }



}

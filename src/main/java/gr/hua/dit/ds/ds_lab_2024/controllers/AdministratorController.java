package gr.hua.dit.ds.ds_lab_2024.controllers;

import gr.hua.dit.ds.ds_lab_2024.entities.Property;
import gr.hua.dit.ds.ds_lab_2024.entities.Tenant;
import gr.hua.dit.ds.ds_lab_2024.repositories.PropertyRepository;
import gr.hua.dit.ds.ds_lab_2024.repositories.TenantRepository;
import gr.hua.dit.ds.ds_lab_2024.service.AdministratorService;
import gr.hua.dit.ds.ds_lab_2024.service.PropertyService;
import gr.hua.dit.ds.ds_lab_2024.service.TenantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("administrator")
public class AdministratorController {

    private final TenantRepository tenantRepository;
    private PropertyRepository propertyRepository;
    private PropertyService propertyService;
    private AdministratorService administratorService;
    private TenantService tenantService;

    public AdministratorController(PropertyService propertyService, AdministratorService administratorService, PropertyRepository propertyRepository, TenantService tenantService, TenantRepository tenantRepository) {
        this.propertyService = propertyService;
        this.administratorService = administratorService;
        this.propertyRepository = propertyRepository;
        this.tenantService = tenantService;
        this.tenantRepository = tenantRepository;
    }

    @GetMapping("/allRegistrations")
    public String showAllProperties(Model model) {
        // Create sample data
        List<Property> properties = new ArrayList<>();
        properties = propertyService.getAllProperties();
        //properties.add(new Property("USA", "New York", "123 Elm Street", "3rd", "10001", "1200 sqft", true, false));
        //properties.add(new Property("Canada", "Toronto", "456 Maple Ave", "5th", "M4B 1B3", "1500 sqft", false, true));
        //properties.add(new Property("UK", "London", "789 Oak Road", "Ground", "SW1A 1AA", "1100 sqft", true, true));


        // Add the list to the model
        model.addAttribute("properties", properties);

        return "view_all_registrations"; // Name of the Thymeleaf template
    }

    @PostMapping("/properties/confirm")
    public String confirmProperty(@RequestParam Long propertyId) {
        System.out.println("Confirming property with ID: " + propertyId);
        administratorService.comfirmOrDeclineProperty(0,propertyId);
        System.out.println ("CONFIRMED WITH STATUS:" + propertyRepository.findById(propertyId).get().getRegistrationStatus());
        // Add logic to confirm the property (e.g., update its status)
        return "redirect:/administrator/allRegistrations"; // Redirect back to the list
    }

    @PostMapping("/properties/decline")
    public String declineProperty(@RequestParam Long propertyId) {
        System.out.println("Declining property with ID: " + propertyId);
        administratorService.comfirmOrDeclineProperty(1,propertyId);
        System.out.println ("DECLINED WITH STATUS:" + propertyRepository.findById(propertyId).get().getRegistrationStatus());
        // Add logic to decline the property
        return "redirect:/administrator/allRegistrations"; // Redirect back to the list

    }

    @GetMapping("/allTenatnsRegtresions")
    public String showAllTenants(Model model) {
        // Create sample data
        List<Tenant> tenants = new ArrayList<>();
        tenants = tenantService.getAllTenants();
        //properties.add(new Property("USA", "New York", "123 Elm Street", "3rd", "10001", "1200 sqft", true, false));
        //properties.add(new Property("Canada", "Toronto", "456 Maple Ave", "5th", "M4B 1B3", "1500 sqft", false, true));
        //properties.add(new Property("UK", "London", "789 Oak Road", "Ground", "SW1A 1AA", "1100 sqft", true, true));

        // Add the list to the model
        model.addAttribute("tenants", tenants);

        return "/view_all_tenants"; // Name of the Thymeleaf template
    }

    @PostMapping("/tenants/confirm")
    public String confirmTenant(@RequestParam Long tenantId) {
        System.out.println("Confirming tenant with ID: " + tenantId);
        administratorService.comfirmOrDeclineTenant(0,tenantId);
        System.out.println("Declining tenant with ID: " + tenantRepository.findById(tenantId).get().getAdminConfirmation());
        // Add logic to confirm the property (e.g., update its status)
        return "redirect:/administrator/allTenatnsRegtresions"; // Redirect back to the list
    }

    @PostMapping("/tenants/decline")
    public String declineTenant(@RequestParam Long tenantId) {
        System.out.println("Declining tenant with ID: " + tenantId);
        administratorService.comfirmOrDeclineTenant(1,tenantId);
        System.out.println("Declining tenant with ID: " + tenantRepository.findById(tenantId).get().getAdminConfirmation());
        //asdadasasd;
        // Add logic to decline the property
        return "redirect:/administrator/allTenatnsRegtresions"; // Redirect back to the list
    }

}

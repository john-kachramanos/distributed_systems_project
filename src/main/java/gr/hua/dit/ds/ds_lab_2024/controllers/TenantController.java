package gr.hua.dit.ds.ds_lab_2024.controllers;

import gr.hua.dit.ds.ds_lab_2024.entities.Filter;
import gr.hua.dit.ds.ds_lab_2024.entities.Property;
import gr.hua.dit.ds.ds_lab_2024.entities.Tenant;
import gr.hua.dit.ds.ds_lab_2024.repositories.TenantRepository;
import gr.hua.dit.ds.ds_lab_2024.service.PropertyService;
import gr.hua.dit.ds.ds_lab_2024.service.TenantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("tenant")

public class TenantController {
    TenantService tenantService ;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @GetMapping("/create")
    public String showCreateTenantForm(Model model) {
        model.addAttribute("tenant", new Tenant());
        return "create_tenant_form"; // Match this to your HTML template file name
    }

    @PostMapping("/create")
    public String createNewTenant(@ModelAttribute Tenant tenant, Model model) {
        tenantService.createNewTenant(
                tenant.getUsername(),
                tenant.getPassword(),
                tenant.getFirstName(),
                tenant.getLastName(),
                tenant.getEmail(),
                tenant.getPasssportNumber(),
                tenant.getAfm()
        );
        model.addAttribute("message", "Tenant registered successfully!");
        return "redirect:/tenant/success"; // Redirect to a success page after registration
    }


    @GetMapping("/properties/search")
    public String searchTenantProperties(@ModelAttribute Filter filters, Model model) {
        try {
            // Call the service method to get the filtered properties
            List<Property> filteredProperties = tenantService.searchTenantProperties(filters.getCountry(), filters.getTown(), filters.getDimensions(), filters.getPrice());
            model.addAttribute("properties", filteredProperties);
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
        }

        return "search_properties"; // This should map to an HTML template to display the results
    }

}

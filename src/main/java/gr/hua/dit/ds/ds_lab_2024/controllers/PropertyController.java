package gr.hua.dit.ds.ds_lab_2024.controllers;

//import ch.qos.logback.core.model.Model;
import gr.hua.dit.ds.ds_lab_2024.service.AdministratorService;
import gr.hua.dit.ds.ds_lab_2024.service.PropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import gr.hua.dit.ds.ds_lab_2024.entities.Property;
import org.springframework.ui.Model;

@Controller
@RequestMapping("property")
public class PropertyController {

    PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    // Show the form page
    @GetMapping("/create")
    public String showCreatePropertyForm(Model model) {
        model.addAttribute("property", new Property());
        return "create_property_form"; // Match this to your HTML template file name
    }

    // Handle form submission
    @PostMapping("/create")
    public String createNewProperty(@ModelAttribute Property property, Model model) {
        propertyService.createNewProperty(
                property.getCountry(),
                property.getTown(),
                property.getAddress(),
                property.getFloor(),
                property.getPostalCode(),
                property.getDimensions()
        );
        model.addAttribute("message", "Property registered successfully!");
        return "redirect:/property/success"; // Redirect or return a success page
    }

}

package gr.hua.dit.ds.ds_lab_2024.controllers;

import gr.hua.dit.ds.ds_lab_2024.entities.Property;
import gr.hua.dit.ds.ds_lab_2024.repositories.PropertyRepository;
import gr.hua.dit.ds.ds_lab_2024.service.PropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("administrator")
public class AdministratorController {

    private PropertyRepository propertyRepository;
    private PropertyService propertyService;

    public AdministratorController(PropertyService propertyService) {
        this.propertyService = propertyService;
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
}

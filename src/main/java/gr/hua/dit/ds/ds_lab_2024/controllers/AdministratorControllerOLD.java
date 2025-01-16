/*
package gr.hua.dit.ds.ds_lab_2024.controllers;

import gr.hua.dit.ds.ds_lab_2024.entities.Property;
import gr.hua.dit.ds.ds_lab_2024.service.PropertyService;
import org.springframework.ui.Model;
import gr.hua.dit.ds.ds_lab_2024.entities.Administrator;
import org.springframework.web.bind.annotation.*;
import gr.hua.dit.ds.ds_lab_2024.service.AdministratorService;

import java.util.ArrayList;
import java.util.List;


//@CrossOrigin(origins = "http://localhost:5173")  // Επιτρέπει μόνο αιτήματα από το frontend στο http://localhost:3000/
@RestController
@RequestMapping("administrator")
//@CrossOrigin(origins = "", allowedHeaders = "", methods = {RequestMethod.GET, RequestMethod.POST})
//@CrossOrigin(origins = "http://localhost:5173") // Frontend URL
//@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class AdministratorController {

    AdministratorService administratorService;
    PropertyService propertyService;

    public AdministratorController(AdministratorService administratorService, PropertyService propertyService) {
        this.administratorService = administratorService;
        this.propertyService = propertyService;
    }

    @GetMapping("BRUH")
    public String showStudents(){
        return "BRUHBRUHBRUH";
    }

    @GetMapping("METHOD")
    public String shoWMethod(){
        return administratorService.hiFun();
    }

    @GetMapping("")
    public String empty(){
        return ".";
    }

    @GetMapping("getOne/{username}")
    public Administrator getOne(@PathVariable String username){
        return administratorService.getOne(username);
    }

    @GetMapping("getAll")
    public Iterable<Administrator> getAll(){
        return administratorService.getAll();
    }

    @GetMapping("/createOne/{username}/{password}")
    public Administrator createOne(@PathVariable String username,@PathVariable String password){
        return administratorService.createOne(username, password);
    }

    @GetMapping("/allRegistrations")
    public String showAllProperties(Model model) {
        // Retrieve the list of properties from the service
        List<Property> listOfProperties = propertyService.getAllProperties();

        // Add the list to the model
        model.addAttribute("properties", listOfProperties);

        // Return the name of the Thymeleaf template
        return "administrator/view_all_registrations"; // Ensure this matches your HTML file
    }

}
*/
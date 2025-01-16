package gr.hua.dit.ds.ds_lab_2024.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import gr.hua.dit.ds.ds_lab_2024.entities.Owner;
import gr.hua.dit.ds.ds_lab_2024.service.OwnerService;

//@CrossOrigin(origins = "http://localhost:5173")  // Επιτρέπει μόνο αιτήματα από το frontend στο http://localhost:3000/
@Controller
@RequestMapping("owner")
//@CrossOrigin(origins = "", allowedHeaders = "", methods = {RequestMethod.GET, RequestMethod.POST})
//@CrossOrigin(origins = "http://localhost:5173") // Frontend URL
//@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class OwnerController {

    OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("BRUH")
    public String showStudents(){
        return "BRUHBRUHBRUH";
    }

    @GetMapping("getOne/{username}")
    public Owner getOne(@PathVariable String username){
        return ownerService.getOne(username);
    }

    @GetMapping("getAll")
    public Iterable<Owner> getAll(){
        return ownerService.getAll();
    }

    @GetMapping("/createOne/{firstName}/{lastName}/{username}/{password}/{email}/{afm}/{passportNumber}")
    public Owner createOne(@PathVariable String firstName,@PathVariable String lastName,@PathVariable String username,@PathVariable String password,@PathVariable String email,@PathVariable String afm,@PathVariable String passportNumber){
        return ownerService.createOne(firstName,lastName,username,password,email,afm,passportNumber);
    }

    //@GetMapping("/createNewProperty")





}

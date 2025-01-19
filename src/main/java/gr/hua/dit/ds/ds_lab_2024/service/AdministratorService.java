package gr.hua.dit.ds.ds_lab_2024.service;

import gr.hua.dit.ds.ds_lab_2024.entities.Administrator;
import gr.hua.dit.ds.ds_lab_2024.entities.Property;
import gr.hua.dit.ds.ds_lab_2024.entities.Tenant;
import gr.hua.dit.ds.ds_lab_2024.repositories.AdministratorRepository;
import gr.hua.dit.ds.ds_lab_2024.repositories.PropertyRepository;
import gr.hua.dit.ds.ds_lab_2024.repositories.TenantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AdministratorService {

    private AdministratorRepository administratorRepository;
    private PropertyRepository propertyRepository;
    private TenantRepository tenantRepository;

    public AdministratorService(AdministratorRepository administratorRepository, PropertyRepository propertyRepository, TenantRepository tenantRepository) {
        this.administratorRepository = administratorRepository;
        this.propertyRepository = propertyRepository;
        this.tenantRepository = tenantRepository;
    }

    @Transactional
    public String hiFun() {
        return "Hello World!";
    }

    @Transactional
    public Administrator getOne(String username) {//EDO PROSOXI MIN XALASE
        return administratorRepository.findByUsername(username);
    }

    //Returns all Admins object
    @Transactional
    public Iterable<Administrator> getAll() {
        return administratorRepository.findAll();
    }

    @Transactional
    //@ResponseStatus(HttpStatus.CREATED)
    public Administrator createOne(String username, String password) {
        Administrator administrator = new Administrator(username, password);
        return administratorRepository.save(administrator);
    }


    //diko mou


    //i==0 for COMFIRM and i ==1 DECLNIE
    @Transactional
    public void comfirmOrDeclineProperty(int i, Long id) {

        Optional<Property> optionalProperty = propertyRepository.findById(id);
        //elenxi ama odos to sigkikrimeno property
        if (optionalProperty.isPresent()) {
            Property property = optionalProperty.get();
            if (i == 0) {
                property.setRegistrationStatus(true);

            } else if (i == 1) {
                property.setRegistrationStatus(false);
            }
            propertyRepository.save(property);
            // Use the property object
        } else {
            // Handle the case where the property is not found
            //throw new ResourceNotFoundException("Property not found with ID: " + id);
            //error handling
        }
    }

    //i==0 for COMFIRM and i ==1 DECLNIE
    @Transactional
    public void comfirmOrDeclineTenant(int i, Long id) {

        Optional<Tenant> optionalTenant = tenantRepository.findById(id);
        //elenxi ama odos to sigkikrimeno property
        if (optionalTenant.isPresent()) {
            Tenant tenant = optionalTenant.get();
            if (i == 0) {
                optionalTenant.get().setAdminConfirmation(true);

            } else if (i == 1) {
                optionalTenant.get().setAdminConfirmation(false);
            }
            tenantRepository.save(tenant);
            // Use the property object
        } else {
            // Handle the case where the property is not found
            //throw new ResourceNotFoundException("Property not found with ID: " + id);
            //error handling
        }
    }

}

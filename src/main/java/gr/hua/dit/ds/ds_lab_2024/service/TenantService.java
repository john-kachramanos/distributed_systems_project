package gr.hua.dit.ds.ds_lab_2024.service;

import gr.hua.dit.ds.ds_lab_2024.entities.Property;
import gr.hua.dit.ds.ds_lab_2024.entities.Rental;
import gr.hua.dit.ds.ds_lab_2024.entities.Tenant;
import gr.hua.dit.ds.ds_lab_2024.repositories.PropertyRepository;
import gr.hua.dit.ds.ds_lab_2024.repositories.TenantRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class TenantService {

    private TenantRepository tenantRepository;
    private PropertyRepository propertyRepository;

    public TenantService(TenantRepository tenantRepository, PropertyRepository propertyRepository) {
        this.tenantRepository = tenantRepository;
        this.propertyRepository = propertyRepository;
    }


    @Transactional
    public List<Property> searchTenantProperties(String country, String city, String dimensions, int rentalPrice) {
        // Fetch the tenant from the repository
        //Tenant tenant = tenantRepository.findById(tenantId)
        //        .orElseThrow(() -> new RuntimeException("Tenant not found"));

        // Get the list of rentals for the tenant
        //List<Rental> rentals = tenant.getRentals();

        List<Property> confirmedProperties = new ArrayList<>();

        propertyRepository.findAll().forEach(property -> {
            if (property.getRegistrationStatus()) {
                confirmedProperties.add(property);
            }
        });


        // Create a list to store the filtered properties
        List<Property> filteredProperties = new ArrayList<>();

        confirmedProperties.forEach(property -> {
            if (property.getCountry().equals(country)) {
                filteredProperties.add(property);
            }
            if (property.getTown().equals(city)) {
                filteredProperties.add(property);
            }
            if (property.getDimensions().equals(dimensions)) {
                filteredProperties.add(property);
            }
            if (property.getRentalPrice() == rentalPrice) {
                filteredProperties.add(property);
            }
        });

        // Loop through the rentals and filter properties based on the search criteria
        /*
        for (Rental rental : rentals) {
            Property property = rental.getProperty(); // Assuming Rental has a reference to Property
            boolean matches = true;

            if (country != null && !country.isEmpty() && !property.getCountry().equalsIgnoreCase(country)) {
                matches = false;
            }

            if (city != null && !city.isEmpty() && !property.getTown().equalsIgnoreCase(city)) {
                matches = false;
            }

//            if (rentPrice != null && !property.getRentPrice().equals(rentPrice)) {
//                matches = false;
//            }
//
//            if (location != null && !location.isEmpty() && !property.getLocation().equalsIgnoreCase(location)) {
//                matches = false;
//            }

            // If the property matches all criteria, add it to the results
            if (matches) {
                filteredProperties.add(property);
            }
        }

        */

        return filteredProperties;
    }



    public Tenant createNewTenant(String username, String password, String firstName, String lastName, String email, String passsportNumber, String afm) {
        Tenant tenant = new Tenant();
        tenant.setUsername(username);
        tenant.setPassword(password);
        tenant.setFirstName(firstName);
        tenant.setLastName(lastName);
        tenant.setEmail(email);
        tenant.setPassword(passsportNumber);
        tenant.setAfm(afm);
        tenant.setAdminConfirmation(null);
        tenantRepository.save(tenant);
        return tenant ;
    }


    @Transactional
    public List<Tenant> getAllTenants() {
        //System.out.println("BRUH" + propertyRepository.findAll());
        return  tenantRepository.findAll();

    }

}

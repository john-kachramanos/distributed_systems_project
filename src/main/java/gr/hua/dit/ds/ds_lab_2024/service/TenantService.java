package gr.hua.dit.ds.ds_lab_2024.service;

import gr.hua.dit.ds.ds_lab_2024.entities.Property;
import gr.hua.dit.ds.ds_lab_2024.entities.Rental;
import gr.hua.dit.ds.ds_lab_2024.entities.Tenant;
import gr.hua.dit.ds.ds_lab_2024.repositories.PropertyRepository;
import gr.hua.dit.ds.ds_lab_2024.repositories.TenantRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class TenantService {

    private TenantRepository tenantRepository;
    public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Transactional
    public List<Property> searchTenantProperties(Long tenantId, String country, String city, Double rentPrice, String location) {
        // Fetch the tenant from the repository
        Tenant tenant = tenantRepository.findById(tenantId)
                .orElseThrow(() -> new RuntimeException("Tenant not found"));

        // Get the list of rentals for the tenant
        List<Rental> rentals = tenant.getRentals();

        // Create a list to store the filtered properties
        List<Property> filteredProperties = new ArrayList<>();

        // Loop through the rentals and filter properties based on the search criteria
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

        return filteredProperties;
    }


    public void createNewTenant(String username, String password, String firstName, String lastName, String email, String passsportNumber, String afm) {

    }
}

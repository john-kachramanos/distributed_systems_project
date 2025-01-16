package gr.hua.dit.ds.ds_lab_2024.service;

import gr.hua.dit.ds.ds_lab_2024.entities.Property;
import gr.hua.dit.ds.ds_lab_2024.repositories.PropertyRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyService {

    private PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Transactional
    public Property createNewProperty (String country, String town, String address, String floor, String postalCode, String dimensions) {
        Property property = new Property();
        property.setCountry(country);
        property.setTown(town);
        property.setAddress(address);
        property.setFloor(floor);
        property.setPostalCode(postalCode);
        property.setDimensions(dimensions);
        property.setStatus(null);
        property.setRegistrationStatus(null);
        propertyRepository.save(property);
        return property;
    }


    @Transactional
    public List<Property> getAllProperties() {
        //System.out.println("BRUH" + propertyRepository.findAll());
        return  propertyRepository.findAll();

    }

}

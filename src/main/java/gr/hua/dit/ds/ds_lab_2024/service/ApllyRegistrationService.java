/*
package gr.hua.dit.ds.ds_lab_2024.service;

import gr.hua.dit.ds.ds_lab_2024.entities.ApplyRegistration;
import gr.hua.dit.ds.ds_lab_2024.entities.Property;
import gr.hua.dit.ds.ds_lab_2024.repositories.ApplyRegistrationRepository;
import gr.hua.dit.ds.ds_lab_2024.repositories.PropertyRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ApllyRegistrationService {

    private ApplyRegistrationRepository apllyRegistrationRepository;
    private PropertyRepository propertyRepository;

    @Transactional
    public ApplyRegistration createNewRegistration (Boolean status) {
        ApplyRegistration applyRegistration = new ApplyRegistration();
        status = null;
        apllyRegistrationRepository.save(applyRegistration);
        return applyRegistration;
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
        propertyRepository.save(property);
        return property;
    }

    @Transactional
    public combineApplyRegistrationProperty bruh (Boolean status, String country, String town, String address, String floor, String postalCode, String dimensions){
        return new combineApplyRegistrationProperty(createNewRegistration(status), createNewProperty (country, town, address, floor, postalCode, dimensions));
    }

    public class combineApplyRegistrationProperty {
        ApplyRegistration applyRegistration;
        Property property;

        public combineApplyRegistrationProperty(ApplyRegistration applyRegistration, Property property) {
            this.applyRegistration = applyRegistration;
            this.property = property;
        }

        public Property getProperty() {
            return property;
        }

        public void setProperty(Property property) {
            this.property = property;
        }

        public ApplyRegistration getApplyRegistration() {
            return applyRegistration;
        }

        public void setApplyRegistration(ApplyRegistration applyRegistration) {
            this.applyRegistration = applyRegistration;
        }
    }

}
*/
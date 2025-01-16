package gr.hua.dit.ds.ds_lab_2024.entities;

import jakarta.persistence.*;
//import lombok.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@Table
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "username")
    private String username;
    @Column(name = "passwords")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "afm")
    private String afm;
    @Column(name = "passport_number")
    private String passportNumber;

    @OneToMany
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private List<Property> properties;

//    @OneToMany
//    @JoinColumn(name = "owner_id")
//    private List<ApplyRegistration> applyRegistration;

//    @OneToMany
//    @JoinColumn(name = "owner_id", referencedColumnName = "id")
//    private List<Rental> rentals;

    public Owner() {
    }

    public Owner(String firstName, String lastName, String username, String password, String email, String afm, String passportNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.afm = afm;
        this.passportNumber = passportNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

//    public List<ApplyRegistration> getApplyRegistration() {
//        return applyRegistration;
//    }
//
//    public void setApplyRegistration(List<ApplyRegistration> applyRegistration) {
//        this.applyRegistration = applyRegistration;
//    }

//    public List<Rental> getRentals() {
//        return rentals;
//    }
//
//    public void setRentals(List<Rental> rentals) {
//        this.rentals = rentals;
//    }

}

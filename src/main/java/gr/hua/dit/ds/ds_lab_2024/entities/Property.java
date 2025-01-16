package gr.hua.dit.ds.ds_lab_2024.entities;

import jakarta.persistence.*;
//import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "country")
    private String country;
    @Column(name = "town")
    private String town;
    @Column(name = "address")
    private String address;
    @Column(name = "floor")
    private String floor;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "dimensions")
    private String dimensions;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "registration_status")
    private Boolean registrationStatus;
    @ElementCollection
    List<LocalDate> occupiedDatesStart = new ArrayList<LocalDate>();
    @ElementCollection
    List<LocalDate> occupiedDatesEnd = new ArrayList<LocalDate>();

//    @OneToMany
//    @JoinColumn(name = "realesta_id")
//    private List<ApplyRegistration> applyRegistrations;

//    @OneToMany
//    @JoinColumn(name = "property_id", referencedColumnName = "id")
//    private List<Rental> rentals;

//    @OneToMany
//    @JoinColumn(name = "property_id")
//    private List<ApplyRental> applyRentals;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Owner owner;

    public Property() {
    }

    public Property(String country, String town, String address, String floor, String postalCode, String dimensions, Boolean status, Boolean registrationStatus) {
        this.country = country;
        this.town = town;
        this.address = address;
        this.floor = floor;
        this.postalCode = postalCode;
        this.dimensions = dimensions;
        this.status = status;
        this.registrationStatus = null;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(Boolean registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public List<LocalDate> getOccupiedDatesStart() {
        return occupiedDatesStart;
    }

    public void setOccupiedDatesStart(List<LocalDate> occupiedDatesStart) {
        this.occupiedDatesStart = occupiedDatesStart;
    }

    public List<LocalDate> getOccupiedDatesEnd() {
        return occupiedDatesEnd;
    }

    public void setOccupiedDatesEnd(List<LocalDate> occupiedDatesEnd) {
        this.occupiedDatesEnd = occupiedDatesEnd;
    }

//    public List<Rental> getRentals() {
//        return rentals;
//    }
//
//    public void setRentals(List<Rental> rentals) {
//        this.rentals = rentals;
//    }

//    public List<ApplyRental> getApplyRentals() {
//        return applyRentals;
//    }
//
//    public void setApplyRentals(List<ApplyRental> applyRentals) {
//        this.applyRentals = applyRentals;
//    }

}

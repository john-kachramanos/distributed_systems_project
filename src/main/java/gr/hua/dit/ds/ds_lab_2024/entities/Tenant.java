package gr.hua.dit.ds.ds_lab_2024.entities;

import jakarta.persistence.*;
//import lombok.*;

import java.util.List;

@Entity
@Table
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "passport_number")
    private String passsportNumber;
    @Column(name = "afm")
    private String afm;

    @OneToMany
    @JoinColumn(name = "tenant_id", referencedColumnName = "id")
    private List<Rental> rentals;

//    @OneToMany
//    @JoinColumn(name = "tenant_id")
//    private List<ApplyRental> applyRentals;

    public Tenant(String username, String password, String firstName, String lastName, String email, String passsportNumber, String afm) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passsportNumber = passsportNumber;
        this.afm = afm;
    }

    public Tenant() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasssportNumber() {
        return passsportNumber;
    }

    public void setPasssportNumber(String passsportNumber) {
        this.passsportNumber = passsportNumber;
    }

    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

//    public List<ApplyRental> getApplyRentals() {
//        return applyRentals;
//    }
//
//    public void setApplyRentals(List<ApplyRental> applyRentals) {
//        this.applyRentals = applyRentals;
//    }
}

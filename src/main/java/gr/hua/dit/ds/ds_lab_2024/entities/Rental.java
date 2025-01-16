package gr.hua.dit.ds.ds_lab_2024.entities;

import jakarta.persistence.*;
//import lombok.*;

import java.time.LocalDate;

@Entity
@Table
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "occupied_date_start")
    private LocalDate occupiedDateStart;
    @Column(name = "occupied_date_end")
    private LocalDate occupiedDateEnd;
    @Column(name = "payment_amount")
    private Long paymentAmount;
    @Column(name = "rental_status")
    private Boolean registrationStatus;

//    @ManyToOne
//    @JoinColumn(name = "owner_id", referencedColumnName = "id")
//    private Owner owner;  // Ο Owner του Property

    // Σχέση Many-to-One με Property (πολλές ενοικιάσεις αφορούν το ίδιο Property)
    @OneToOne
    @JoinColumn(name = "property_id", referencedColumnName = "id")
    private Property property;  // Το Property που ενοικιάστηκε

    // Σχέση Many-to-One με Tenant (πολλές ενοικιάσεις αφορούν τον ίδιο Tenant)
    @ManyToOne
    @JoinColumn(name = "tenant_id", referencedColumnName = "id")
    private Tenant tenant;

    public Rental(LocalDate occupiedDateStart, LocalDate occupiedDateEnd, Long paymentAmount, Boolean registrationStatus) {
        this.occupiedDateStart = occupiedDateStart;
        this.occupiedDateEnd = occupiedDateEnd;
        this.paymentAmount = paymentAmount;
        this.registrationStatus = null;
    }

    public Rental() {
    }

    public LocalDate getOccupiedDateStart() {
        return occupiedDateStart;
    }

    public void setOccupiedDateStart(LocalDate occupiedDateStart) {
        this.occupiedDateStart = occupiedDateStart;
    }

    public LocalDate getOccupiedDateEnd() {
        return occupiedDateEnd;
    }

    public void setOccupiedDateEnd(LocalDate occupiedDateEnd) {
        this.occupiedDateEnd = occupiedDateEnd;
    }

    public Long getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Long paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

//    public Owner getOwner() {
//        return owner;
//    }
//
//    public void setOwner(Owner owner) {
//        this.owner = owner;
//    }

    public Boolean getRentalStatus() {
        return registrationStatus;
    }

    public void setRentalStatus(Boolean registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Tenant getTenants() {
        return tenant;
    }

    public void setTenants(Tenant tenant) {
        this.tenant = tenant;
    }
}
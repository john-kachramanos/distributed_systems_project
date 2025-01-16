/*
package gr.hua.dit.ds.ds_lab_2024.entities;

import jakarta.persistence.*;
//import lombok.*;

import java.time.LocalDate;

@Entity
@Table
public class ApplyRental {
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
    @Column(name = "status")
    private Boolean status;

    // Foreign key reference to the tenant
    @ManyToOne
    @JoinColumn(name = "tenant_id", referencedColumnName = "id")  // Ρητά αναφερόμαστε στην στήλη "id" του πίνακα "tenant"
    private Tenant tenants;  // Ο ενοικιαστής που συνδέεται με την αίτηση ενοικίασης

    // Ξένο κλειδί για το ακίνητο
    @ManyToOne
    @JoinColumn(name = "property_id", referencedColumnName = "id")
    private Property properties;

    public ApplyRental() {
    }

    public ApplyRental(LocalDate occupiedDateStart, LocalDate occupiedDateEnd, Long paymentAmount, Boolean status) {
        this.occupiedDateStart = occupiedDateStart;
        this.occupiedDateEnd = occupiedDateEnd;
        this.paymentAmount = paymentAmount;
        this.status = status;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
*/
/*
package gr.hua.dit.ds.ds_lab_2024.entities;

import jakarta.persistence.*;
//import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class ApplyRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "status")
    private Boolean status;

    @ElementCollection
    List<LocalDate> occupiedDatesStart = new ArrayList<LocalDate>();
    @ElementCollection
    List<LocalDate> occupiedDatesEnd = new ArrayList<LocalDate>();

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Owner owner;

    public ApplyRegistration() {
    }

    public ApplyRegistration(Owner owner, List<LocalDate> occupiedDatesStart, List<LocalDate> occupiedDatesEnd, Boolean status) {
        this.owner = owner;
        this.occupiedDatesStart = occupiedDatesStart;
        this.occupiedDatesEnd = occupiedDatesEnd;
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

}
*/
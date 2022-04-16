package com.dh.DentistClinicHibernate.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String lastname;
    private Integer identitycard;
    private LocalDate dateofadmission;
    // Relacion con Address
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address", referencedColumnName = "id")
    private Address address;
    // Relacion con Appoinment
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_appointment", referencedColumnName = "id")
    private Set<Appointment> appointment;


}
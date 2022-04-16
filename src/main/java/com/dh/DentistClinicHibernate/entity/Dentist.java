package com.dh.DentistClinicHibernate.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "dentists")
public class Dentist{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String lastname;
    private Integer enrollment;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_appointment", referencedColumnName = "id")
    private Set<Appointment> appointment;

}

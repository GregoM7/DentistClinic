package com.dh.DentistClinicHibernate.entity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_dentist", referencedColumnName = "id")
    private Dentist dentist;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_patient", referencedColumnName = "id")
    private Patient patient;


}
